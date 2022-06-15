package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.CategorieCharge;
import com.ird.faa.dao.CategorieChargeDao;
import com.ird.faa.service.admin.facade.CategorieChargeAdminService;

import com.ird.faa.ws.rest.provided.vo.CategorieChargeVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CategorieChargeAdminServiceImpl extends AbstractServiceImpl<CategorieCharge> implements CategorieChargeAdminService {

@Autowired
private CategorieChargeDao categorieChargeDao;

    @Autowired
    private ArchivableService<CategorieCharge> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<CategorieCharge> findAll(){
        return categorieChargeDao.findAll();
}

@Override
public CategorieCharge findById(Long id){
if(id==null) return null;
return categorieChargeDao.getOne(id);
}

@Override
public CategorieCharge findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public CategorieCharge archiver(CategorieCharge categorieCharge) {
    if (categorieCharge.getArchive() == null) {
    categorieCharge.setArchive(false);
    }
    categorieCharge.setArchive(true);
    categorieCharge.setDateArchivage(new Date());
    categorieChargeDao.save(categorieCharge);
    return categorieCharge;

    }

    @Override
    public CategorieCharge desarchiver(CategorieCharge categorieCharge) {
    if (categorieCharge.getArchive() == null) {
    categorieCharge.setArchive(false);
    }
    categorieCharge.setArchive(false);
    categorieChargeDao.save(categorieCharge);
    return categorieCharge;
    }




@Transactional
public int deleteById(Long id){
int res=0;
if(categorieChargeDao.findById(id).isPresent())  {
categorieChargeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CategorieCharge update(CategorieCharge categorieCharge){
CategorieCharge foundedCategorieCharge = findById(categorieCharge.getId());
if(foundedCategorieCharge==null) return null;
else{
    archivableService.prepare(categorieCharge);
return  categorieChargeDao.save(categorieCharge);
}
}
    private void prepareSave(CategorieCharge categorieCharge){
        categorieCharge.setDateCreation(new Date());
        if(categorieCharge.getDateArchivage() == null)
        categorieCharge.setDateArchivage(new Date());
                    if(categorieCharge.getArchive() == null)
                categorieCharge.setArchive(false);




    }

@Override
public CategorieCharge save (CategorieCharge categorieCharge){
    prepareSave(categorieCharge);




    return categorieChargeDao.save(categorieCharge);


}

@Override
public List<CategorieCharge> save(List<CategorieCharge> categorieCharges){
List<CategorieCharge> list = new ArrayList<>();
for(CategorieCharge categorieCharge: categorieCharges){
list.add(save(categorieCharge));
}
return list;
}



@Override
@Transactional
public int delete(CategorieCharge categorieCharge){
    if(categorieCharge.getId()==null) return -1;
    CategorieCharge foundedCategorieCharge = findById(categorieCharge.getId());
    if(foundedCategorieCharge==null) return -1;
categorieChargeDao.delete(foundedCategorieCharge);
return 1;
}


public List<CategorieCharge> findByCriteria(CategorieChargeVo categorieChargeVo){

String query = "SELECT o FROM CategorieCharge o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",categorieChargeVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",categorieChargeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "description","LIKE",categorieChargeVo.getDescription());
            query += SearchUtil.addConstraint( "o", "code","=",categorieChargeVo.getCode());
            query += SearchUtil.addConstraint( "o", "type","LIKE",categorieChargeVo.getType());
            query += SearchUtil.addConstraint( "o", "archive","=",categorieChargeVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",categorieChargeVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",categorieChargeVo.getDateCreation());
            query += SearchUtil.addConstraintMinMax("o","code",categorieChargeVo.getCodeMin(),categorieChargeVo.getCodeMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",categorieChargeVo.getDateArchivageMin(),categorieChargeVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",categorieChargeVo.getDateCreationMin(),categorieChargeVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<CategorieCharge> categorieCharges){
if(ListUtil.isNotEmpty(categorieCharges)){
categorieCharges.forEach(e->categorieChargeDao.delete(e));
}
}
@Override
public void update(List<CategorieCharge> categorieCharges){
if(ListUtil.isNotEmpty(categorieCharges)){
categorieCharges.forEach(e->categorieChargeDao.save(e));
}
}





    }
