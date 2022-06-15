package com.ird.faa.service.maitreouvrage.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatLot;
import com.ird.faa.dao.EtatLotDao;
import com.ird.faa.service.maitreouvrage.facade.EtatLotMaitreouvrageService;

import com.ird.faa.ws.rest.provided.vo.EtatLotVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatLotMaitreouvrageServiceImpl extends AbstractServiceImpl<EtatLot> implements EtatLotMaitreouvrageService {

@Autowired
private EtatLotDao etatLotDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatLot> findAll(){
        return etatLotDao.findAll();
}

@Override
public EtatLot findById(Long id){
if(id==null) return null;
return etatLotDao.getOne(id);
}

@Override
public EtatLot findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etatLotDao.findById(id).isPresent())  {
etatLotDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatLot update(EtatLot etatLot){
EtatLot foundedEtatLot = findById(etatLot.getId());
if(foundedEtatLot==null) return null;
else{
return  etatLotDao.save(etatLot);
}
}

@Override
public EtatLot save (EtatLot etatLot){




    return etatLotDao.save(etatLot);


}

@Override
public List<EtatLot> save(List<EtatLot> etatLots){
List<EtatLot> list = new ArrayList<>();
for(EtatLot etatLot: etatLots){
list.add(save(etatLot));
}
return list;
}



@Override
@Transactional
public int delete(EtatLot etatLot){
    if(etatLot.getId()==null) return -1;
    EtatLot foundedEtatLot = findById(etatLot.getId());
    if(foundedEtatLot==null) return -1;
etatLotDao.delete(foundedEtatLot);
return 1;
}


public List<EtatLot> findByCriteria(EtatLotVo etatLotVo){

String query = "SELECT o FROM EtatLot o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatLotVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatLotVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","=",etatLotVo.getCode());
            query += SearchUtil.addConstraintMinMax("o","code",etatLotVo.getCodeMin(),etatLotVo.getCodeMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatLot> etatLots){
if(ListUtil.isNotEmpty(etatLots)){
etatLots.forEach(e->etatLotDao.delete(e));
}
}
@Override
public void update(List<EtatLot> etatLots){
if(ListUtil.isNotEmpty(etatLots)){
etatLots.forEach(e->etatLotDao.save(e));
}
}





    }
