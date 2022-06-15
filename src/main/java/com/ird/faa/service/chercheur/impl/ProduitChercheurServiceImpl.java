package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Produit;
import com.ird.faa.dao.ProduitDao;
import com.ird.faa.service.chercheur.facade.ProduitChercheurService;

import com.ird.faa.ws.rest.provided.vo.ProduitVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ProduitChercheurServiceImpl extends AbstractServiceImpl<Produit> implements ProduitChercheurService {

@Autowired
private ProduitDao produitDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Produit> findAll(){
        return produitDao.findAll();
}
    @Override
    public Produit findByReference(String reference){
    if( reference==null) return null;
    return produitDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return produitDao.deleteByReference(reference);
    }
    @Override
    public Produit findByIdOrReference(Produit produit){
    Produit resultat=null;
    if(produit != null){
    if(StringUtil.isNotEmpty(produit.getId())){
    resultat= produitDao.getOne(produit.getId());
    }else if(StringUtil.isNotEmpty(produit.getReference())) {
    resultat= produitDao.findByReference(produit.getReference());
    }
    }
    return resultat;
    }

@Override
public Produit findById(Long id){
if(id==null) return null;
return produitDao.getOne(id);
}

@Override
public Produit findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(produitDao.findById(id).isPresent())  {
produitDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Produit update(Produit produit){
Produit foundedProduit = findById(produit.getId());
if(foundedProduit==null) return null;
else{
return  produitDao.save(produit);
}
}

@Override
public Produit save (Produit produit){

    Produit result =null;
    Produit foundedProduit = findByReference(produit.getReference());
    if(foundedProduit == null){




    Produit savedProduit = produitDao.save(produit);

    result = savedProduit;
    }

    return result;
}

@Override
public List<Produit> save(List<Produit> produits){
List<Produit> list = new ArrayList<>();
for(Produit produit: produits){
list.add(save(produit));
}
return list;
}



@Override
@Transactional
public int delete(Produit produit){
    if(produit.getReference()==null) return -1;

    Produit foundedProduit = findByReference(produit.getReference());
    if(foundedProduit==null) return -1;
produitDao.delete(foundedProduit);
return 1;
}


public List<Produit> findByCriteria(ProduitVo produitVo){

String query = "SELECT o FROM Produit o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",produitVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",produitVo.getReference());
            query += SearchUtil.addConstraint( "o", "montant","=",produitVo.getMontant());
            query += SearchUtil.addConstraint( "o", "description","LIKE",produitVo.getDescription());
            query += SearchUtil.addConstraintMinMax("o","montant",produitVo.getMontantMin(),produitVo.getMontantMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Produit> produits){
if(ListUtil.isNotEmpty(produits)){
produits.forEach(e->produitDao.delete(e));
}
}
@Override
public void update(List<Produit> produits){
if(ListUtil.isNotEmpty(produits)){
produits.forEach(e->produitDao.save(e));
}
}





    }
