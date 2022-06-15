package com.ird.faa.service.maitreouvrage.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.MaitreOuvrage;
import com.ird.faa.dao.MaitreOuvrageDao;
import com.ird.faa.service.maitreouvrage.facade.MaitreOuvrageMaitreouvrageService;

import com.ird.faa.ws.rest.provided.vo.MaitreOuvrageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MaitreOuvrageMaitreouvrageServiceImpl extends AbstractServiceImpl<MaitreOuvrage> implements MaitreOuvrageMaitreouvrageService {

@Autowired
private MaitreOuvrageDao maitreOuvrageDao;



@Autowired
private EntityManager entityManager;

    @Override
    public MaitreOuvrage findByUsername(String username){
    return maitreOuvrageDao.findByUsername(username);
    }

@Override
public List<MaitreOuvrage> findAll(){
        return maitreOuvrageDao.findAll();
}
    @Override
    public MaitreOuvrage findByIce(String ice){
    if( ice==null) return null;
    return maitreOuvrageDao.findByIce(ice);
    }

    @Override
    @Transactional
    public int deleteByIce(String  ice) {
    return maitreOuvrageDao.deleteByIce(ice);
    }
    @Override
    public MaitreOuvrage findByIdOrIce(MaitreOuvrage maitreOuvrage){
    MaitreOuvrage resultat=null;
    if(maitreOuvrage != null){
    if(StringUtil.isNotEmpty(maitreOuvrage.getId())){
    resultat= maitreOuvrageDao.getOne(maitreOuvrage.getId());
    }else if(StringUtil.isNotEmpty(maitreOuvrage.getIce())) {
    resultat= maitreOuvrageDao.findByIce(maitreOuvrage.getIce());
    }else if(StringUtil.isNotEmpty(maitreOuvrage.getUsername())) {
    resultat = maitreOuvrageDao.findByUsername(maitreOuvrage.getUsername());
    }
    }
    return resultat;
    }

@Override
public MaitreOuvrage findById(Long id){
if(id==null) return null;
return maitreOuvrageDao.getOne(id);
}

@Override
public MaitreOuvrage findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(maitreOuvrageDao.findById(id).isPresent())  {
maitreOuvrageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public MaitreOuvrage update(MaitreOuvrage maitreOuvrage){
MaitreOuvrage foundedMaitreOuvrage = findById(maitreOuvrage.getId());
if(foundedMaitreOuvrage==null) return null;
else{
return  maitreOuvrageDao.save(maitreOuvrage);
}
}
    private void prepareSave(MaitreOuvrage maitreOuvrage){
                maitreOuvrage.setCredentialsNonExpired(false);
                maitreOuvrage.setEnabled(false);
                maitreOuvrage.setAccountNonExpired(false);
                maitreOuvrage.setAccountNonLocked(false);
                maitreOuvrage.setPasswordChanged(false);




    }

@Override
public MaitreOuvrage save (MaitreOuvrage maitreOuvrage){
    prepareSave(maitreOuvrage);

    MaitreOuvrage result =null;
        MaitreOuvrage foundedMaitreOuvrage = findByIce(maitreOuvrage.getIce());
        MaitreOuvrage foundedMaitreOuvrageByUsername = findByIce(maitreOuvrage.getIce());
        if(foundedMaitreOuvrage == null && foundedMaitreOuvrageByUsername == null){

maitreOuvrage.setCredentialsNonExpired(false);
maitreOuvrage.setAccountNonExpired(false);
maitreOuvrage.setEnabled(false);
maitreOuvrage.setPasswordChanged(false);
maitreOuvrage.setAccountNonLocked(false);


    MaitreOuvrage savedMaitreOuvrage = maitreOuvrageDao.save(maitreOuvrage);

    result = savedMaitreOuvrage;
    }

    return result;
}

@Override
public List<MaitreOuvrage> save(List<MaitreOuvrage> maitreOuvrages){
List<MaitreOuvrage> list = new ArrayList<>();
for(MaitreOuvrage maitreOuvrage: maitreOuvrages){
list.add(save(maitreOuvrage));
}
return list;
}



@Override
@Transactional
public int delete(MaitreOuvrage maitreOuvrage){
    if(maitreOuvrage.getIce()==null) return -1;

    MaitreOuvrage foundedMaitreOuvrage = findByIce(maitreOuvrage.getIce());
    if(foundedMaitreOuvrage==null) return -1;
maitreOuvrageDao.delete(foundedMaitreOuvrage);
return 1;
}


public List<MaitreOuvrage> findByCriteria(MaitreOuvrageVo maitreOuvrageVo){

String query = "SELECT o FROM MaitreOuvrage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",maitreOuvrageVo.getId());
            query += SearchUtil.addConstraint( "o", "ice","LIKE",maitreOuvrageVo.getIce());
            query += SearchUtil.addConstraint( "o", "identifiantFiscale","LIKE",maitreOuvrageVo.getIdentifiantFiscale());
            query += SearchUtil.addConstraint( "o", "adresse","LIKE",maitreOuvrageVo.getAdresse());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",maitreOuvrageVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",maitreOuvrageVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",maitreOuvrageVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",maitreOuvrageVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",maitreOuvrageVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",maitreOuvrageVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",maitreOuvrageVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",maitreOuvrageVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",maitreOuvrageVo.getPassword());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",maitreOuvrageVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",maitreOuvrageVo.getNom());
            query += SearchUtil.addConstraint( "o", "equivalenceAvecPanelErc","LIKE",maitreOuvrageVo.getEquivalenceAvecPanelErc());
            query += SearchUtil.addConstraint( "o", "baseHorizon","LIKE",maitreOuvrageVo.getBaseHorizon());
            query += SearchUtil.addConstraint( "o", "role","LIKE",maitreOuvrageVo.getRole());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",maitreOuvrageVo.getCreatedAtMin(),maitreOuvrageVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",maitreOuvrageVo.getUpdatedAtMin(),maitreOuvrageVo.getUpdatedAtMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<MaitreOuvrage> maitreOuvrages){
if(ListUtil.isNotEmpty(maitreOuvrages)){
maitreOuvrages.forEach(e->maitreOuvrageDao.delete(e));
}
}
@Override
public void update(List<MaitreOuvrage> maitreOuvrages){
if(ListUtil.isNotEmpty(maitreOuvrages)){
maitreOuvrages.forEach(e->maitreOuvrageDao.save(e));
}
}





    }
