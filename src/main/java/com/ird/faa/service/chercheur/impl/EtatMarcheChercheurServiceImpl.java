package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatMarche;
import com.ird.faa.dao.EtatMarcheDao;
import com.ird.faa.service.chercheur.facade.EtatMarcheChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtatMarcheVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatMarcheChercheurServiceImpl extends AbstractServiceImpl<EtatMarche> implements EtatMarcheChercheurService {

@Autowired
private EtatMarcheDao etatMarcheDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatMarche> findAll(){
        return etatMarcheDao.findAll();
}

@Override
public EtatMarche findById(Long id){
if(id==null) return null;
return etatMarcheDao.getOne(id);
}

@Override
public EtatMarche findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etatMarcheDao.findById(id).isPresent())  {
etatMarcheDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatMarche update(EtatMarche etatMarche){
EtatMarche foundedEtatMarche = findById(etatMarche.getId());
if(foundedEtatMarche==null) return null;
else{
return  etatMarcheDao.save(etatMarche);
}
}

@Override
public EtatMarche save (EtatMarche etatMarche){




    return etatMarcheDao.save(etatMarche);


}

@Override
public List<EtatMarche> save(List<EtatMarche> etatMarches){
List<EtatMarche> list = new ArrayList<>();
for(EtatMarche etatMarche: etatMarches){
list.add(save(etatMarche));
}
return list;
}



@Override
@Transactional
public int delete(EtatMarche etatMarche){
    if(etatMarche.getId()==null) return -1;
    EtatMarche foundedEtatMarche = findById(etatMarche.getId());
    if(foundedEtatMarche==null) return -1;
etatMarcheDao.delete(foundedEtatMarche);
return 1;
}


public List<EtatMarche> findByCriteria(EtatMarcheVo etatMarcheVo){

String query = "SELECT o FROM EtatMarche o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatMarcheVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatMarcheVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","=",etatMarcheVo.getCode());
            query += SearchUtil.addConstraintMinMax("o","code",etatMarcheVo.getCodeMin(),etatMarcheVo.getCodeMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatMarche> etatMarches){
if(ListUtil.isNotEmpty(etatMarches)){
etatMarches.forEach(e->etatMarcheDao.delete(e));
}
}
@Override
public void update(List<EtatMarche> etatMarches){
if(ListUtil.isNotEmpty(etatMarches)){
etatMarches.forEach(e->etatMarcheDao.save(e));
}
}





    }
