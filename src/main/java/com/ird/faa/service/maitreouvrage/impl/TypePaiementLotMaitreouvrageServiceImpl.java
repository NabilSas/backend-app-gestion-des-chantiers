package com.ird.faa.service.maitreouvrage.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypePaiementLot;
import com.ird.faa.dao.TypePaiementLotDao;
import com.ird.faa.service.maitreouvrage.facade.TypePaiementLotMaitreouvrageService;

import com.ird.faa.ws.rest.provided.vo.TypePaiementLotVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypePaiementLotMaitreouvrageServiceImpl extends AbstractServiceImpl<TypePaiementLot> implements TypePaiementLotMaitreouvrageService {

@Autowired
private TypePaiementLotDao typePaiementLotDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypePaiementLot> findAll(){
        return typePaiementLotDao.findAll();
}

@Override
public TypePaiementLot findById(Long id){
if(id==null) return null;
return typePaiementLotDao.getOne(id);
}

@Override
public TypePaiementLot findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typePaiementLotDao.findById(id).isPresent())  {
typePaiementLotDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypePaiementLot update(TypePaiementLot typePaiementLot){
TypePaiementLot foundedTypePaiementLot = findById(typePaiementLot.getId());
if(foundedTypePaiementLot==null) return null;
else{
return  typePaiementLotDao.save(typePaiementLot);
}
}

@Override
public TypePaiementLot save (TypePaiementLot typePaiementLot){




    return typePaiementLotDao.save(typePaiementLot);


}

@Override
public List<TypePaiementLot> save(List<TypePaiementLot> typePaiementLots){
List<TypePaiementLot> list = new ArrayList<>();
for(TypePaiementLot typePaiementLot: typePaiementLots){
list.add(save(typePaiementLot));
}
return list;
}



@Override
@Transactional
public int delete(TypePaiementLot typePaiementLot){
    if(typePaiementLot.getId()==null) return -1;
    TypePaiementLot foundedTypePaiementLot = findById(typePaiementLot.getId());
    if(foundedTypePaiementLot==null) return -1;
typePaiementLotDao.delete(foundedTypePaiementLot);
return 1;
}


public List<TypePaiementLot> findByCriteria(TypePaiementLotVo typePaiementLotVo){

String query = "SELECT o FROM TypePaiementLot o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typePaiementLotVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typePaiementLotVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","=",typePaiementLotVo.getCode());
            query += SearchUtil.addConstraintMinMax("o","code",typePaiementLotVo.getCodeMin(),typePaiementLotVo.getCodeMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypePaiementLot> typePaiementLots){
if(ListUtil.isNotEmpty(typePaiementLots)){
typePaiementLots.forEach(e->typePaiementLotDao.delete(e));
}
}
@Override
public void update(List<TypePaiementLot> typePaiementLots){
if(ListUtil.isNotEmpty(typePaiementLots)){
typePaiementLots.forEach(e->typePaiementLotDao.save(e));
}
}





    }
