package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PaiementMarche;
        import com.ird.faa.bean.TypePaiementMarche;
        import com.ird.faa.bean.Marche;
import com.ird.faa.dao.PaiementMarcheDao;
import com.ird.faa.service.admin.facade.PaiementMarcheAdminService;
        import com.ird.faa.service.admin.facade.MarcheAdminService;
        import com.ird.faa.service.admin.facade.TypePaiementMarcheAdminService;

import com.ird.faa.ws.rest.provided.vo.PaiementMarcheVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PaiementMarcheAdminServiceImpl extends AbstractServiceImpl<PaiementMarche> implements PaiementMarcheAdminService {

@Autowired
private PaiementMarcheDao paiementMarcheDao;

        @Autowired
        private MarcheAdminService marcheService ;
        @Autowired
        private TypePaiementMarcheAdminService typePaiementMarcheService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PaiementMarche> findAll(){
        String query = "SELECT o FROM PaiementMarche o where 1=1 ";
        query+= " ORDER BY o.datePaiement";
        return entityManager.createQuery(query).getResultList();
}
        @Override
        public List<PaiementMarche> findByTypePaiementMarcheId(Long id){
        return paiementMarcheDao.findByTypePaiementMarcheId(id);
        }

        @Override
        @Transactional
        public int deleteByTypePaiementMarcheId(Long id){
        return paiementMarcheDao.deleteByTypePaiementMarcheId(id);
        }


        @Override
        public List<PaiementMarche> findByMarcheCode(Long code){
        return paiementMarcheDao.findByMarcheCode(code);
        }

        @Override
        @Transactional
        public int deleteByMarcheCode(Long code){
        return paiementMarcheDao.deleteByMarcheCode(code);
        }

        @Override
        public List<PaiementMarche> findByMarcheId(Long id){
        return paiementMarcheDao.findByMarcheId(id);
        }

        @Override
        @Transactional
        public int deleteByMarcheId(Long id){
        return paiementMarcheDao.deleteByMarcheId(id);
        }

    @Override
    public PaiementMarche findByReference(String reference){
    if( reference==null) return null;
    return paiementMarcheDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return paiementMarcheDao.deleteByReference(reference);
    }
    @Override
    public PaiementMarche findByIdOrReference(PaiementMarche paiementMarche){
    PaiementMarche resultat=null;
    if(paiementMarche != null){
    if(StringUtil.isNotEmpty(paiementMarche.getId())){
    resultat= paiementMarcheDao.getOne(paiementMarche.getId());
    }else if(StringUtil.isNotEmpty(paiementMarche.getReference())) {
    resultat= paiementMarcheDao.findByReference(paiementMarche.getReference());
    }
    }
    return resultat;
    }

@Override
public PaiementMarche findById(Long id){
if(id==null) return null;
return paiementMarcheDao.getOne(id);
}

@Override
public PaiementMarche findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(paiementMarcheDao.findById(id).isPresent())  {
paiementMarcheDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PaiementMarche update(PaiementMarche paiementMarche){
PaiementMarche foundedPaiementMarche = findById(paiementMarche.getId());
if(foundedPaiementMarche==null) return null;
else{
return  paiementMarcheDao.save(paiementMarche);
}
}

@Override
public PaiementMarche save (PaiementMarche paiementMarche){

    PaiementMarche result =null;
    PaiementMarche foundedPaiementMarche = findByReference(paiementMarche.getReference());
    if(foundedPaiementMarche == null){



    findTypePaiementMarche(paiementMarche);
    findMarche(paiementMarche);

    PaiementMarche savedPaiementMarche = paiementMarcheDao.save(paiementMarche);

    result = savedPaiementMarche;
    }

    return result;
}

@Override
public List<PaiementMarche> save(List<PaiementMarche> paiementMarches){
List<PaiementMarche> list = new ArrayList<>();
for(PaiementMarche paiementMarche: paiementMarches){
list.add(save(paiementMarche));
}
return list;
}



@Override
@Transactional
public int delete(PaiementMarche paiementMarche){
    if(paiementMarche.getReference()==null) return -1;

    PaiementMarche foundedPaiementMarche = findByReference(paiementMarche.getReference());
    if(foundedPaiementMarche==null) return -1;
paiementMarcheDao.delete(foundedPaiementMarche);
return 1;
}


public List<PaiementMarche> findByCriteria(PaiementMarcheVo paiementMarcheVo){

String query = "SELECT o FROM PaiementMarche o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",paiementMarcheVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",paiementMarcheVo.getReference());
            query += SearchUtil.addConstraint( "o", "description","LIKE",paiementMarcheVo.getDescription());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",paiementMarcheVo.getLibelle());
        query += SearchUtil.addConstraintDate( "o", "datePaiement","=",paiementMarcheVo.getDatePaiement());
            query += SearchUtil.addConstraint( "o", "montant","=",paiementMarcheVo.getMontant());
            query += SearchUtil.addConstraintMinMaxDate("o","datePaiement",paiementMarcheVo.getDatePaiementMin(),paiementMarcheVo.getDatePaiementMax());
            query += SearchUtil.addConstraintMinMax("o","montant",paiementMarcheVo.getMontantMin(),paiementMarcheVo.getMontantMax());
    if(paiementMarcheVo.getTypePaiementMarcheVo()!=null){
        query += SearchUtil.addConstraint( "o", "typePaiementMarche.id","=",paiementMarcheVo.getTypePaiementMarcheVo().getId());
    }

    if(paiementMarcheVo.getMarcheVo()!=null){
        query += SearchUtil.addConstraint( "o", "marche.id","=",paiementMarcheVo.getMarcheVo().getId());
            query += SearchUtil.addConstraint( "o", "marche.code","=",paiementMarcheVo.getMarcheVo().getCode());
    }

    query+= " ORDER BY o.datePaiement";
return entityManager.createQuery(query).getResultList();
}

    private void findTypePaiementMarche(PaiementMarche paiementMarche){
        TypePaiementMarche loadedTypePaiementMarche = null;
        if(paiementMarche.getTypePaiementMarche() != null && paiementMarche.getTypePaiementMarche().getId() !=null)
        loadedTypePaiementMarche =typePaiementMarcheService.findById(paiementMarche.getTypePaiementMarche().getId());

    if(loadedTypePaiementMarche==null ) {
    return;
    }
    paiementMarche.setTypePaiementMarche(loadedTypePaiementMarche);
    }
    private void findMarche(PaiementMarche paiementMarche){
        Marche loadedMarche =marcheService.findByIdOrCode(paiementMarche.getMarche());

    if(loadedMarche==null ) {
    return;
    }
    paiementMarche.setMarche(loadedMarche);
    }

@Override
@Transactional
public void delete(List<PaiementMarche> paiementMarches){
if(ListUtil.isNotEmpty(paiementMarches)){
paiementMarches.forEach(e->paiementMarcheDao.delete(e));
}
}
@Override
public void update(List<PaiementMarche> paiementMarches){
if(ListUtil.isNotEmpty(paiementMarches)){
paiementMarches.forEach(e->paiementMarcheDao.save(e));
}
}





    }
