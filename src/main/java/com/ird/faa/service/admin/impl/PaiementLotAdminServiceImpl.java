package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PaiementLot;
        import com.ird.faa.bean.TypePaiementLot;
        import com.ird.faa.bean.Lot;
import com.ird.faa.dao.PaiementLotDao;
import com.ird.faa.service.admin.facade.PaiementLotAdminService;
        import com.ird.faa.service.admin.facade.LotAdminService;
        import com.ird.faa.service.admin.facade.TypePaiementLotAdminService;

import com.ird.faa.ws.rest.provided.vo.PaiementLotVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PaiementLotAdminServiceImpl extends AbstractServiceImpl<PaiementLot> implements PaiementLotAdminService {

@Autowired
private PaiementLotDao paiementLotDao;

        @Autowired
        private LotAdminService lotService ;
        @Autowired
        private TypePaiementLotAdminService typePaiementLotService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PaiementLot> findAll(){
        String query = "SELECT o FROM PaiementLot o where 1=1 ";
        query+= " ORDER BY o.datePaiement";
        return entityManager.createQuery(query).getResultList();
}
        @Override
        public List<PaiementLot> findByTypePaiementLotId(Long id){
        return paiementLotDao.findByTypePaiementLotId(id);
        }

        @Override
        @Transactional
        public int deleteByTypePaiementLotId(Long id){
        return paiementLotDao.deleteByTypePaiementLotId(id);
        }

        @Override
        public List<PaiementLot> findByLotId(Long id){
        return paiementLotDao.findByLotId(id);
        }

        @Override
        @Transactional
        public int deleteByLotId(Long id){
        return paiementLotDao.deleteByLotId(id);
        }

    @Override
    public PaiementLot findByReference(String reference){
    if( reference==null) return null;
    return paiementLotDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return paiementLotDao.deleteByReference(reference);
    }
    @Override
    public PaiementLot findByIdOrReference(PaiementLot paiementLot){
    PaiementLot resultat=null;
    if(paiementLot != null){
    if(StringUtil.isNotEmpty(paiementLot.getId())){
    resultat= paiementLotDao.getOne(paiementLot.getId());
    }else if(StringUtil.isNotEmpty(paiementLot.getReference())) {
    resultat= paiementLotDao.findByReference(paiementLot.getReference());
    }
    }
    return resultat;
    }

@Override
public PaiementLot findById(Long id){
if(id==null) return null;
return paiementLotDao.getOne(id);
}

@Override
public PaiementLot findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(paiementLotDao.findById(id).isPresent())  {
paiementLotDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PaiementLot update(PaiementLot paiementLot){
PaiementLot foundedPaiementLot = findById(paiementLot.getId());
if(foundedPaiementLot==null) return null;
else{
return  paiementLotDao.save(paiementLot);
}
}

@Override
public PaiementLot save (PaiementLot paiementLot){

    PaiementLot result =null;
    PaiementLot foundedPaiementLot = findByReference(paiementLot.getReference());
    if(foundedPaiementLot == null){



    findTypePaiementLot(paiementLot);
    findLot(paiementLot);

    PaiementLot savedPaiementLot = paiementLotDao.save(paiementLot);

    result = savedPaiementLot;
    }

    return result;
}

@Override
public List<PaiementLot> save(List<PaiementLot> paiementLots){
List<PaiementLot> list = new ArrayList<>();
for(PaiementLot paiementLot: paiementLots){
list.add(save(paiementLot));
}
return list;
}



@Override
@Transactional
public int delete(PaiementLot paiementLot){
    if(paiementLot.getReference()==null) return -1;

    PaiementLot foundedPaiementLot = findByReference(paiementLot.getReference());
    if(foundedPaiementLot==null) return -1;
paiementLotDao.delete(foundedPaiementLot);
return 1;
}


public List<PaiementLot> findByCriteria(PaiementLotVo paiementLotVo){

String query = "SELECT o FROM PaiementLot o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",paiementLotVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",paiementLotVo.getReference());
            query += SearchUtil.addConstraint( "o", "description","LIKE",paiementLotVo.getDescription());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",paiementLotVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "montant","=",paiementLotVo.getMontant());
        query += SearchUtil.addConstraintDate( "o", "datePaiement","=",paiementLotVo.getDatePaiement());
            query += SearchUtil.addConstraintMinMax("o","montant",paiementLotVo.getMontantMin(),paiementLotVo.getMontantMax());
            query += SearchUtil.addConstraintMinMaxDate("o","datePaiement",paiementLotVo.getDatePaiementMin(),paiementLotVo.getDatePaiementMax());
    if(paiementLotVo.getTypePaiementLotVo()!=null){
        query += SearchUtil.addConstraint( "o", "typePaiementLot.id","=",paiementLotVo.getTypePaiementLotVo().getId());
    }

    if(paiementLotVo.getLotVo()!=null){
        query += SearchUtil.addConstraint( "o", "lot.id","=",paiementLotVo.getLotVo().getId());
    }

    query+= " ORDER BY o.datePaiement";
return entityManager.createQuery(query).getResultList();
}

    private void findTypePaiementLot(PaiementLot paiementLot){
        TypePaiementLot loadedTypePaiementLot = null;
        if(paiementLot.getTypePaiementLot() != null && paiementLot.getTypePaiementLot().getId() !=null)
        loadedTypePaiementLot =typePaiementLotService.findById(paiementLot.getTypePaiementLot().getId());

    if(loadedTypePaiementLot==null ) {
    return;
    }
    paiementLot.setTypePaiementLot(loadedTypePaiementLot);
    }
    private void findLot(PaiementLot paiementLot){
        Lot loadedLot = null;
        if(paiementLot.getLot() != null && paiementLot.getLot().getId() !=null)
        loadedLot =lotService.findById(paiementLot.getLot().getId());

    if(loadedLot==null ) {
    return;
    }
    paiementLot.setLot(loadedLot);
    }

@Override
@Transactional
public void delete(List<PaiementLot> paiementLots){
if(ListUtil.isNotEmpty(paiementLots)){
paiementLots.forEach(e->paiementLotDao.delete(e));
}
}
@Override
public void update(List<PaiementLot> paiementLots){
if(ListUtil.isNotEmpty(paiementLots)){
paiementLots.forEach(e->paiementLotDao.save(e));
}
}





    }
