package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypePaiementMarche;
import com.ird.faa.dao.TypePaiementMarcheDao;
import com.ird.faa.service.chercheur.facade.TypePaiementMarcheChercheurService;

import com.ird.faa.ws.rest.provided.vo.TypePaiementMarcheVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypePaiementMarcheChercheurServiceImpl extends AbstractServiceImpl<TypePaiementMarche> implements TypePaiementMarcheChercheurService {

@Autowired
private TypePaiementMarcheDao typePaiementMarcheDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypePaiementMarche> findAll(){
        return typePaiementMarcheDao.findAll();
}

@Override
public TypePaiementMarche findById(Long id){
if(id==null) return null;
return typePaiementMarcheDao.getOne(id);
}

@Override
public TypePaiementMarche findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typePaiementMarcheDao.findById(id).isPresent())  {
typePaiementMarcheDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypePaiementMarche update(TypePaiementMarche typePaiementMarche){
TypePaiementMarche foundedTypePaiementMarche = findById(typePaiementMarche.getId());
if(foundedTypePaiementMarche==null) return null;
else{
return  typePaiementMarcheDao.save(typePaiementMarche);
}
}

@Override
public TypePaiementMarche save (TypePaiementMarche typePaiementMarche){




    return typePaiementMarcheDao.save(typePaiementMarche);


}

@Override
public List<TypePaiementMarche> save(List<TypePaiementMarche> typePaiementMarches){
List<TypePaiementMarche> list = new ArrayList<>();
for(TypePaiementMarche typePaiementMarche: typePaiementMarches){
list.add(save(typePaiementMarche));
}
return list;
}



@Override
@Transactional
public int delete(TypePaiementMarche typePaiementMarche){
    if(typePaiementMarche.getId()==null) return -1;
    TypePaiementMarche foundedTypePaiementMarche = findById(typePaiementMarche.getId());
    if(foundedTypePaiementMarche==null) return -1;
typePaiementMarcheDao.delete(foundedTypePaiementMarche);
return 1;
}


public List<TypePaiementMarche> findByCriteria(TypePaiementMarcheVo typePaiementMarcheVo){

String query = "SELECT o FROM TypePaiementMarche o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typePaiementMarcheVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typePaiementMarcheVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","=",typePaiementMarcheVo.getCode());
            query += SearchUtil.addConstraintMinMax("o","code",typePaiementMarcheVo.getCodeMin(),typePaiementMarcheVo.getCodeMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypePaiementMarche> typePaiementMarches){
if(ListUtil.isNotEmpty(typePaiementMarches)){
typePaiementMarches.forEach(e->typePaiementMarcheDao.delete(e));
}
}
@Override
public void update(List<TypePaiementMarche> typePaiementMarches){
if(ListUtil.isNotEmpty(typePaiementMarches)){
typePaiementMarches.forEach(e->typePaiementMarcheDao.save(e));
}
}





    }
