package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypePieceJointe;
import com.ird.faa.dao.TypePieceJointeDao;
import com.ird.faa.service.admin.facade.TypePieceJointeAdminService;

import com.ird.faa.ws.rest.provided.vo.TypePieceJointeVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypePieceJointeAdminServiceImpl extends AbstractServiceImpl<TypePieceJointe> implements TypePieceJointeAdminService {

@Autowired
private TypePieceJointeDao typePieceJointeDao;

    @Autowired
    private ArchivableService<TypePieceJointe> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<TypePieceJointe> findAll(){
        return typePieceJointeDao.findAll();
}
    @Override
    public TypePieceJointe findByCode(String code){
    if( code==null) return null;
    return typePieceJointeDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typePieceJointeDao.deleteByCode(code);
    }
    @Override
    public TypePieceJointe findByIdOrCode(TypePieceJointe typePieceJointe){
    TypePieceJointe resultat=null;
    if(typePieceJointe != null){
    if(StringUtil.isNotEmpty(typePieceJointe.getId())){
    resultat= typePieceJointeDao.getOne(typePieceJointe.getId());
    }else if(StringUtil.isNotEmpty(typePieceJointe.getCode())) {
    resultat= typePieceJointeDao.findByCode(typePieceJointe.getCode());
    }
    }
    return resultat;
    }

@Override
public TypePieceJointe findById(Long id){
if(id==null) return null;
return typePieceJointeDao.getOne(id);
}

@Override
public TypePieceJointe findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public TypePieceJointe archiver(TypePieceJointe typePieceJointe) {
    if (typePieceJointe.getArchive() == null) {
    typePieceJointe.setArchive(false);
    }
    typePieceJointe.setArchive(true);
    typePieceJointe.setDateArchivage(new Date());
    typePieceJointeDao.save(typePieceJointe);
    return typePieceJointe;

    }

    @Override
    public TypePieceJointe desarchiver(TypePieceJointe typePieceJointe) {
    if (typePieceJointe.getArchive() == null) {
    typePieceJointe.setArchive(false);
    }
    typePieceJointe.setArchive(false);
    typePieceJointeDao.save(typePieceJointe);
    return typePieceJointe;
    }




@Transactional
public int deleteById(Long id){
int res=0;
if(typePieceJointeDao.findById(id).isPresent())  {
typePieceJointeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypePieceJointe update(TypePieceJointe typePieceJointe){
TypePieceJointe foundedTypePieceJointe = findById(typePieceJointe.getId());
if(foundedTypePieceJointe==null) return null;
else{
    archivableService.prepare(typePieceJointe);
return  typePieceJointeDao.save(typePieceJointe);
}
}
    private void prepareSave(TypePieceJointe typePieceJointe){
        typePieceJointe.setDateCreation(new Date());
        if(typePieceJointe.getDateArchivage() == null)
        typePieceJointe.setDateArchivage(new Date());
                    if(typePieceJointe.getArchive() == null)
                typePieceJointe.setArchive(false);




    }

@Override
public TypePieceJointe save (TypePieceJointe typePieceJointe){
    prepareSave(typePieceJointe);

    TypePieceJointe result =null;
    TypePieceJointe foundedTypePieceJointe = findByCode(typePieceJointe.getCode());
    if(foundedTypePieceJointe == null){




    TypePieceJointe savedTypePieceJointe = typePieceJointeDao.save(typePieceJointe);

    result = savedTypePieceJointe;
    }

    return result;
}

@Override
public List<TypePieceJointe> save(List<TypePieceJointe> typePieceJointes){
List<TypePieceJointe> list = new ArrayList<>();
for(TypePieceJointe typePieceJointe: typePieceJointes){
list.add(save(typePieceJointe));
}
return list;
}



@Override
@Transactional
public int delete(TypePieceJointe typePieceJointe){
    if(typePieceJointe.getCode()==null) return -1;

    TypePieceJointe foundedTypePieceJointe = findByCode(typePieceJointe.getCode());
    if(foundedTypePieceJointe==null) return -1;
typePieceJointeDao.delete(foundedTypePieceJointe);
return 1;
}


public List<TypePieceJointe> findByCriteria(TypePieceJointeVo typePieceJointeVo){

String query = "SELECT o FROM TypePieceJointe o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typePieceJointeVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typePieceJointeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typePieceJointeVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",typePieceJointeVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",typePieceJointeVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",typePieceJointeVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",typePieceJointeVo.getDateArchivageMin(),typePieceJointeVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",typePieceJointeVo.getDateCreationMin(),typePieceJointeVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypePieceJointe> typePieceJointes){
if(ListUtil.isNotEmpty(typePieceJointes)){
typePieceJointes.forEach(e->typePieceJointeDao.delete(e));
}
}
@Override
public void update(List<TypePieceJointe> typePieceJointes){
if(ListUtil.isNotEmpty(typePieceJointes)){
typePieceJointes.forEach(e->typePieceJointeDao.save(e));
}
}





    }
