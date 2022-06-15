package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.SousClasseComptable;
        import com.ird.faa.bean.ClasseComptable;
        import com.ird.faa.bean.CompteComptable;
import com.ird.faa.dao.SousClasseComptableDao;
import com.ird.faa.service.admin.facade.SousClasseComptableAdminService;
        import com.ird.faa.service.admin.facade.ClasseComptableAdminService;
        import com.ird.faa.service.admin.facade.CompteComptableAdminService;

import com.ird.faa.ws.rest.provided.vo.SousClasseComptableVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.CompteComptable;
        import com.ird.faa.service.admin.facade.CompteComptableAdminService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class SousClasseComptableAdminServiceImpl extends AbstractServiceImpl<SousClasseComptable> implements SousClasseComptableAdminService {

@Autowired
private SousClasseComptableDao sousClasseComptableDao;

        @Autowired
        private ClasseComptableAdminService classeComptableService ;
        @Autowired
        private CompteComptableAdminService compteComptableService ;


@Autowired
private EntityManager entityManager;


@Override
public List<SousClasseComptable> findAll(){
        return sousClasseComptableDao.findAll();
}
        @Override
        public List<SousClasseComptable> findByClasseComptableId(Long id){
        return sousClasseComptableDao.findByClasseComptableId(id);
        }

        @Override
        @Transactional
        public int deleteByClasseComptableId(Long id){
        return sousClasseComptableDao.deleteByClasseComptableId(id);
        }


@Override
public SousClasseComptable findById(Long id){
if(id==null) return null;
return sousClasseComptableDao.getOne(id);
}

@Override
public SousClasseComptable findByIdWithAssociatedList(Long id){
    SousClasseComptable sousClasseComptable  = findById(id);
    findAssociatedLists(sousClasseComptable);
    return sousClasseComptable;
}

    private void findAssociatedLists(SousClasseComptable sousClasseComptable){
    if(sousClasseComptable!=null && sousClasseComptable.getId() != null) {
            List<CompteComptable> compteComptables = compteComptableService.findBySousClasseComptableId(sousClasseComptable.getId());
            sousClasseComptable.setCompteComptables(compteComptables);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            compteComptableService.deleteBySousClasseComptableId(id);
    }
    }

    private void updateAssociatedLists(SousClasseComptable sousClasseComptable){
    if(sousClasseComptable !=null && sousClasseComptable.getId() != null){
            List
            <List<CompteComptable>> resultCompteComptables= compteComptableService.getToBeSavedAndToBeDeleted(compteComptableService.findBySousClasseComptableId(sousClasseComptable.getId()),sousClasseComptable.getCompteComptables());
            compteComptableService.delete(resultCompteComptables.get(1));
            associateCompteComptable(sousClasseComptable,resultCompteComptables.get(0));
            compteComptableService.update(resultCompteComptables.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(sousClasseComptableDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
sousClasseComptableDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public SousClasseComptable update(SousClasseComptable sousClasseComptable){
SousClasseComptable foundedSousClasseComptable = findById(sousClasseComptable.getId());
if(foundedSousClasseComptable==null) return null;
else{
    updateAssociatedLists(sousClasseComptable);
return  sousClasseComptableDao.save(sousClasseComptable);
}
}

@Override
public SousClasseComptable save (SousClasseComptable sousClasseComptable){

    SousClasseComptable result =null;


    findClasseComptable(sousClasseComptable);

    SousClasseComptable savedSousClasseComptable = sousClasseComptableDao.save(sousClasseComptable);

        saveCompteComptables(savedSousClasseComptable,sousClasseComptable.getCompteComptables());
    result = savedSousClasseComptable;

    return result;
}

@Override
public List<SousClasseComptable> save(List<SousClasseComptable> sousClasseComptables){
List<SousClasseComptable> list = new ArrayList<>();
for(SousClasseComptable sousClasseComptable: sousClasseComptables){
list.add(save(sousClasseComptable));
}
return list;
}

        private List<CompteComptable> prepareCompteComptables(SousClasseComptable sousClasseComptable,List<CompteComptable> compteComptables){
        for(CompteComptable compteComptable:compteComptables ){
        compteComptable.setSousClasseComptable(sousClasseComptable);
        }
        return compteComptables;
        }


@Override
@Transactional
public int delete(SousClasseComptable sousClasseComptable){
    if(sousClasseComptable.getId()==null) return -1;
    SousClasseComptable foundedSousClasseComptable = findById(sousClasseComptable.getId());
    if(foundedSousClasseComptable==null) return -1;
sousClasseComptableDao.delete(foundedSousClasseComptable);
return 1;
}


public List<SousClasseComptable> findByCriteria(SousClasseComptableVo sousClasseComptableVo){

String query = "SELECT o FROM SousClasseComptable o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",sousClasseComptableVo.getId());
            query += SearchUtil.addConstraint( "o", "code","=",sousClasseComptableVo.getCode());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",sousClasseComptableVo.getLibelle());
            query += SearchUtil.addConstraintMinMax("o","code",sousClasseComptableVo.getCodeMin(),sousClasseComptableVo.getCodeMax());
    if(sousClasseComptableVo.getClasseComptableVo()!=null){
        query += SearchUtil.addConstraint( "o", "classeComptable.id","=",sousClasseComptableVo.getClasseComptableVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void saveCompteComptables(SousClasseComptable sousClasseComptable,List<CompteComptable> compteComptables){

        if (ListUtil.isNotEmpty(sousClasseComptable.getCompteComptables())) {
        List<CompteComptable> savedCompteComptables = new ArrayList<>();
        compteComptables.forEach(element -> {
        element.setSousClasseComptable(sousClasseComptable);
         compteComptableService.save(element);
        });
        sousClasseComptable.setCompteComptables(savedCompteComptables);
        }
        }

    private void findClasseComptable(SousClasseComptable sousClasseComptable){
        ClasseComptable loadedClasseComptable = null;
        if(sousClasseComptable.getClasseComptable() != null && sousClasseComptable.getClasseComptable().getId() !=null)
        loadedClasseComptable =classeComptableService.findById(sousClasseComptable.getClasseComptable().getId());

    if(loadedClasseComptable==null ) {
    return;
    }
    sousClasseComptable.setClasseComptable(loadedClasseComptable);
    }

@Override
@Transactional
public void delete(List<SousClasseComptable> sousClasseComptables){
if(ListUtil.isNotEmpty(sousClasseComptables)){
sousClasseComptables.forEach(e->sousClasseComptableDao.delete(e));
}
}
@Override
public void update(List<SousClasseComptable> sousClasseComptables){
if(ListUtil.isNotEmpty(sousClasseComptables)){
sousClasseComptables.forEach(e->sousClasseComptableDao.save(e));
}
}

        private void associateCompteComptable(SousClasseComptable sousClasseComptable, List<CompteComptable> compteComptable) {
        if (ListUtil.isNotEmpty(compteComptable)) {
        compteComptable.forEach(e -> e.setSousClasseComptable(sousClasseComptable));
        }
        }




    }
