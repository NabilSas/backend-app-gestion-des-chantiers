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
import com.ird.faa.bean.EtatCharge;
import com.ird.faa.dao.EtatChargeDao;
import com.ird.faa.service.chercheur.facade.EtatChargeChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtatChargeVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatChargeChercheurServiceImpl extends AbstractServiceImpl<EtatCharge> implements EtatChargeChercheurService {

@Autowired
private EtatChargeDao etatChargeDao;

    @Autowired
    private ArchivableService<EtatCharge> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<EtatCharge> findAll(){
    List<EtatCharge> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}

@Override
public EtatCharge findById(Long id){
if(id==null) return null;
return etatChargeDao.getOne(id);
}

@Override
public EtatCharge findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etatChargeDao.findById(id).isPresent())  {
etatChargeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatCharge update(EtatCharge etatCharge){
EtatCharge foundedEtatCharge = findById(etatCharge.getId());
if(foundedEtatCharge==null) return null;
else{
    archivableService.prepare(etatCharge);
return  etatChargeDao.save(etatCharge);
}
}
    private void prepareSave(EtatCharge etatCharge){
        etatCharge.setDateCreation(new Date());
        if(etatCharge.getDateArchivage() == null)
        etatCharge.setDateArchivage(new Date());
                    if(etatCharge.getArchive() == null)
                etatCharge.setArchive(false);




    }

@Override
public EtatCharge save (EtatCharge etatCharge){
    prepareSave(etatCharge);




    return etatChargeDao.save(etatCharge);


}

@Override
public List<EtatCharge> save(List<EtatCharge> etatCharges){
List<EtatCharge> list = new ArrayList<>();
for(EtatCharge etatCharge: etatCharges){
list.add(save(etatCharge));
}
return list;
}



@Override
@Transactional
public int delete(EtatCharge etatCharge){
    if(etatCharge.getId()==null) return -1;
    EtatCharge foundedEtatCharge = findById(etatCharge.getId());
    if(foundedEtatCharge==null) return -1;
etatChargeDao.delete(foundedEtatCharge);
return 1;
}


public List<EtatCharge> findByCriteria(EtatChargeVo etatChargeVo){

String query = "SELECT o FROM EtatCharge o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatChargeVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatChargeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","=",etatChargeVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",etatChargeVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",etatChargeVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",etatChargeVo.getDateCreation());
            query += SearchUtil.addConstraintMinMax("o","code",etatChargeVo.getCodeMin(),etatChargeVo.getCodeMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",etatChargeVo.getDateArchivageMin(),etatChargeVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",etatChargeVo.getDateCreationMin(),etatChargeVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatCharge> etatCharges){
if(ListUtil.isNotEmpty(etatCharges)){
etatCharges.forEach(e->etatChargeDao.delete(e));
}
}
@Override
public void update(List<EtatCharge> etatCharges){
if(ListUtil.isNotEmpty(etatCharges)){
etatCharges.forEach(e->etatChargeDao.save(e));
}
}




        public List<EtatCharge> findAllNonArchive(){
        String query = "SELECT o FROM EtatCharge o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<EtatCharge> findAllByOwner(){
        List<EtatCharge> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM EtatCharge o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }
