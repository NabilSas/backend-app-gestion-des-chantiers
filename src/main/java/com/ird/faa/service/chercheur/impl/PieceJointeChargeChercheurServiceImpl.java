package com.ird.faa.service.chercheur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
    import com.ird.faa.service.util.StringUtil;
    import com.ird.faa.security.common.SecurityUtil;
    import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeCharge;
        import com.ird.faa.bean.Charge;
import com.ird.faa.dao.PieceJointeChargeDao;
import com.ird.faa.service.chercheur.facade.PieceJointeChargeChercheurService;
        import com.ird.faa.service.chercheur.facade.ChargeChercheurService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeChargeVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeChargeChercheurServiceImpl extends AbstractServiceImpl<PieceJointeCharge> implements PieceJointeChargeChercheurService {

@Autowired
private PieceJointeChargeDao pieceJointeChargeDao;

    @Autowired
    private ArchivableService<PieceJointeCharge> archivableService;
        @Autowired
        private ChargeChercheurService chargeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeCharge> findAll(){
    List<PieceJointeCharge> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}
        @Override
        public List<PieceJointeCharge> findByChargeId(Long id){
        return pieceJointeChargeDao.findByChargeId(id);
        }

        @Override
        @Transactional
        public int deleteByChargeId(Long id){
        return pieceJointeChargeDao.deleteByChargeId(id);
        }


@Override
public PieceJointeCharge findById(Long id){
if(id==null) return null;
return pieceJointeChargeDao.getOne(id);
}

@Override
public PieceJointeCharge findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(pieceJointeChargeDao.findById(id).isPresent())  {
pieceJointeChargeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PieceJointeCharge update(PieceJointeCharge pieceJointeCharge){
PieceJointeCharge foundedPieceJointeCharge = findById(pieceJointeCharge.getId());
if(foundedPieceJointeCharge==null) return null;
else{
    archivableService.prepare(pieceJointeCharge);
return  pieceJointeChargeDao.save(pieceJointeCharge);
}
}
    private void prepareSave(PieceJointeCharge pieceJointeCharge){
        pieceJointeCharge.setDateCreation(new Date());
        if(pieceJointeCharge.getDateArchivage() == null)
        pieceJointeCharge.setDateArchivage(new Date());
                    if(pieceJointeCharge.getArchive() == null)
                pieceJointeCharge.setArchive(false);




    }

@Override
public PieceJointeCharge save (PieceJointeCharge pieceJointeCharge){
    prepareSave(pieceJointeCharge);



    findCharge(pieceJointeCharge);

    return pieceJointeChargeDao.save(pieceJointeCharge);


}

@Override
public List<PieceJointeCharge> save(List<PieceJointeCharge> pieceJointeCharges){
List<PieceJointeCharge> list = new ArrayList<>();
for(PieceJointeCharge pieceJointeCharge: pieceJointeCharges){
list.add(save(pieceJointeCharge));
}
return list;
}



@Override
@Transactional
public int delete(PieceJointeCharge pieceJointeCharge){
    if(pieceJointeCharge.getId()==null) return -1;
    PieceJointeCharge foundedPieceJointeCharge = findById(pieceJointeCharge.getId());
    if(foundedPieceJointeCharge==null) return -1;
pieceJointeChargeDao.delete(foundedPieceJointeCharge);
return 1;
}


public List<PieceJointeCharge> findByCriteria(PieceJointeChargeVo pieceJointeChargeVo){

String query = "SELECT o FROM PieceJointeCharge o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",pieceJointeChargeVo.getId());
            query += SearchUtil.addConstraint( "o", "path","LIKE",pieceJointeChargeVo.getPath());
        query += SearchUtil.addConstraintDate( "o", "datePaiement","=",pieceJointeChargeVo.getDatePaiement());
            query += SearchUtil.addConstraint( "o", "montant","=",pieceJointeChargeVo.getMontant());
            query += SearchUtil.addConstraint( "o", "archive","=",pieceJointeChargeVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",pieceJointeChargeVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",pieceJointeChargeVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","datePaiement",pieceJointeChargeVo.getDatePaiementMin(),pieceJointeChargeVo.getDatePaiementMax());
            query += SearchUtil.addConstraintMinMax("o","montant",pieceJointeChargeVo.getMontantMin(),pieceJointeChargeVo.getMontantMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",pieceJointeChargeVo.getDateArchivageMin(),pieceJointeChargeVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",pieceJointeChargeVo.getDateCreationMin(),pieceJointeChargeVo.getDateCreationMax());
    if(pieceJointeChargeVo.getChargeVo()!=null){
        query += SearchUtil.addConstraint( "o", "charge.id","=",pieceJointeChargeVo.getChargeVo().getId());
    }

    query+= " ORDER BY o.datePaiement";
return entityManager.createQuery(query).getResultList();
}

    private void findCharge(PieceJointeCharge pieceJointeCharge){
        Charge loadedCharge = null;
        if(pieceJointeCharge.getCharge() != null && pieceJointeCharge.getCharge().getId() !=null)
        loadedCharge =chargeService.findById(pieceJointeCharge.getCharge().getId());

    if(loadedCharge==null ) {
    return;
    }
    pieceJointeCharge.setCharge(loadedCharge);
    }

@Override
@Transactional
public void delete(List<PieceJointeCharge> pieceJointeCharges){
if(ListUtil.isNotEmpty(pieceJointeCharges)){
pieceJointeCharges.forEach(e->pieceJointeChargeDao.delete(e));
}
}
@Override
public void update(List<PieceJointeCharge> pieceJointeCharges){
if(ListUtil.isNotEmpty(pieceJointeCharges)){
pieceJointeCharges.forEach(e->pieceJointeChargeDao.save(e));
}
}




        public List<PieceJointeCharge> findAllNonArchive(){
        String query = "SELECT o FROM PieceJointeCharge o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.datePaiement";
        return entityManager.createQuery(query).getResultList();
        }

        public List<PieceJointeCharge> findAllByOwner(){
        List<PieceJointeCharge> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM PieceJointeCharge o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.datePaiement";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }
