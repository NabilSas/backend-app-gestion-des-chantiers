package com.ird.faa.service.maitreouvrage.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.CategorieEmploye;
import com.ird.faa.dao.CategorieEmployeDao;
import com.ird.faa.service.maitreouvrage.facade.CategorieEmployeMaitreouvrageService;

import com.ird.faa.ws.rest.provided.vo.CategorieEmployeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CategorieEmployeMaitreouvrageServiceImpl extends AbstractServiceImpl<CategorieEmploye> implements CategorieEmployeMaitreouvrageService {

@Autowired
private CategorieEmployeDao categorieEmployeDao;



@Autowired
private EntityManager entityManager;


@Override
public List<CategorieEmploye> findAll(){
        return categorieEmployeDao.findAll();
}
    @Override
    public CategorieEmploye findByCode(String code){
    if( code==null) return null;
    return categorieEmployeDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return categorieEmployeDao.deleteByCode(code);
    }
    @Override
    public CategorieEmploye findByIdOrCode(CategorieEmploye categorieEmploye){
    CategorieEmploye resultat=null;
    if(categorieEmploye != null){
    if(StringUtil.isNotEmpty(categorieEmploye.getId())){
    resultat= categorieEmployeDao.getOne(categorieEmploye.getId());
    }else if(StringUtil.isNotEmpty(categorieEmploye.getCode())) {
    resultat= categorieEmployeDao.findByCode(categorieEmploye.getCode());
    }
    }
    return resultat;
    }

@Override
public CategorieEmploye findById(Long id){
if(id==null) return null;
return categorieEmployeDao.getOne(id);
}

@Override
public CategorieEmploye findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(categorieEmployeDao.findById(id).isPresent())  {
categorieEmployeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CategorieEmploye update(CategorieEmploye categorieEmploye){
CategorieEmploye foundedCategorieEmploye = findById(categorieEmploye.getId());
if(foundedCategorieEmploye==null) return null;
else{
return  categorieEmployeDao.save(categorieEmploye);
}
}

@Override
public CategorieEmploye save (CategorieEmploye categorieEmploye){

    CategorieEmploye result =null;
    CategorieEmploye foundedCategorieEmploye = findByCode(categorieEmploye.getCode());
    if(foundedCategorieEmploye == null){




    CategorieEmploye savedCategorieEmploye = categorieEmployeDao.save(categorieEmploye);

    result = savedCategorieEmploye;
    }

    return result;
}

@Override
public List<CategorieEmploye> save(List<CategorieEmploye> categorieEmployes){
List<CategorieEmploye> list = new ArrayList<>();
for(CategorieEmploye categorieEmploye: categorieEmployes){
list.add(save(categorieEmploye));
}
return list;
}



@Override
@Transactional
public int delete(CategorieEmploye categorieEmploye){
    if(categorieEmploye.getCode()==null) return -1;

    CategorieEmploye foundedCategorieEmploye = findByCode(categorieEmploye.getCode());
    if(foundedCategorieEmploye==null) return -1;
categorieEmployeDao.delete(foundedCategorieEmploye);
return 1;
}


public List<CategorieEmploye> findByCriteria(CategorieEmployeVo categorieEmployeVo){

String query = "SELECT o FROM CategorieEmploye o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",categorieEmployeVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",categorieEmployeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",categorieEmployeVo.getCode());
            query += SearchUtil.addConstraint( "o", "description","LIKE",categorieEmployeVo.getDescription());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<CategorieEmploye> categorieEmployes){
if(ListUtil.isNotEmpty(categorieEmployes)){
categorieEmployes.forEach(e->categorieEmployeDao.delete(e));
}
}
@Override
public void update(List<CategorieEmploye> categorieEmployes){
if(ListUtil.isNotEmpty(categorieEmployes)){
categorieEmployes.forEach(e->categorieEmployeDao.save(e));
}
}





    }
