package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.ClasseComptable;
        import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.dao.ClasseComptableDao;
import com.ird.faa.service.admin.facade.ClasseComptableAdminService;
        import com.ird.faa.service.admin.facade.SousClasseComptableAdminService;

import com.ird.faa.ws.rest.provided.vo.ClasseComptableVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.SousClasseComptable;
        import com.ird.faa.service.admin.facade.SousClasseComptableAdminService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ClasseComptableAdminServiceImpl extends AbstractServiceImpl<ClasseComptable> implements ClasseComptableAdminService {

@Autowired
private ClasseComptableDao classeComptableDao;

        @Autowired
        private SousClasseComptableAdminService sousClasseComptableService ;


@Autowired
private EntityManager entityManager;


@Override
public List<ClasseComptable> findAll(){
        return classeComptableDao.findAll();
}

@Override
public ClasseComptable findById(Long id){
if(id==null) return null;
return classeComptableDao.getOne(id);
}

@Override
public ClasseComptable findByIdWithAssociatedList(Long id){
    ClasseComptable classeComptable  = findById(id);
    findAssociatedLists(classeComptable);
    return classeComptable;
}

    private void findAssociatedLists(ClasseComptable classeComptable){
    if(classeComptable!=null && classeComptable.getId() != null) {
            List<SousClasseComptable> sousClasseComptables = sousClasseComptableService.findByClasseComptableId(classeComptable.getId());
            classeComptable.setSousClasseComptables(sousClasseComptables);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            sousClasseComptableService.deleteByClasseComptableId(id);
    }
    }

    private void updateAssociatedLists(ClasseComptable classeComptable){
    if(classeComptable !=null && classeComptable.getId() != null){
            List
            <List<SousClasseComptable>> resultSousClasseComptables= sousClasseComptableService.getToBeSavedAndToBeDeleted(sousClasseComptableService.findByClasseComptableId(classeComptable.getId()),classeComptable.getSousClasseComptables());
            sousClasseComptableService.delete(resultSousClasseComptables.get(1));
            associateSousClasseComptable(classeComptable,resultSousClasseComptables.get(0));
            sousClasseComptableService.update(resultSousClasseComptables.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(classeComptableDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
classeComptableDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ClasseComptable update(ClasseComptable classeComptable){
ClasseComptable foundedClasseComptable = findById(classeComptable.getId());
if(foundedClasseComptable==null) return null;
else{
    updateAssociatedLists(classeComptable);
return  classeComptableDao.save(classeComptable);
}
}

@Override
public ClasseComptable save (ClasseComptable classeComptable){

    ClasseComptable result =null;



    ClasseComptable savedClasseComptable = classeComptableDao.save(classeComptable);

        saveSousClasseComptables(savedClasseComptable,classeComptable.getSousClasseComptables());
    result = savedClasseComptable;

    return result;
}

@Override
public List<ClasseComptable> save(List<ClasseComptable> classeComptables){
List<ClasseComptable> list = new ArrayList<>();
for(ClasseComptable classeComptable: classeComptables){
list.add(save(classeComptable));
}
return list;
}

        private List<SousClasseComptable> prepareSousClasseComptables(ClasseComptable classeComptable,List<SousClasseComptable> sousClasseComptables){
        for(SousClasseComptable sousClasseComptable:sousClasseComptables ){
        sousClasseComptable.setClasseComptable(classeComptable);
        }
        return sousClasseComptables;
        }


@Override
@Transactional
public int delete(ClasseComptable classeComptable){
    if(classeComptable.getId()==null) return -1;
    ClasseComptable foundedClasseComptable = findById(classeComptable.getId());
    if(foundedClasseComptable==null) return -1;
classeComptableDao.delete(foundedClasseComptable);
return 1;
}


public List<ClasseComptable> findByCriteria(ClasseComptableVo classeComptableVo){

String query = "SELECT o FROM ClasseComptable o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",classeComptableVo.getId());
            query += SearchUtil.addConstraint( "o", "code","=",classeComptableVo.getCode());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",classeComptableVo.getLibelle());
            query += SearchUtil.addConstraintMinMax("o","code",classeComptableVo.getCodeMin(),classeComptableVo.getCodeMax());
return entityManager.createQuery(query).getResultList();
}
        private  void saveSousClasseComptables(ClasseComptable classeComptable,List<SousClasseComptable> sousClasseComptables){

        if (ListUtil.isNotEmpty(classeComptable.getSousClasseComptables())) {
        List<SousClasseComptable> savedSousClasseComptables = new ArrayList<>();
        sousClasseComptables.forEach(element -> {
        element.setClasseComptable(classeComptable);
         sousClasseComptableService.save(element);
        });
        classeComptable.setSousClasseComptables(savedSousClasseComptables);
        }
        }


@Override
@Transactional
public void delete(List<ClasseComptable> classeComptables){
if(ListUtil.isNotEmpty(classeComptables)){
classeComptables.forEach(e->classeComptableDao.delete(e));
}
}
@Override
public void update(List<ClasseComptable> classeComptables){
if(ListUtil.isNotEmpty(classeComptables)){
classeComptables.forEach(e->classeComptableDao.save(e));
}
}

        private void associateSousClasseComptable(ClasseComptable classeComptable, List<SousClasseComptable> sousClasseComptable) {
        if (ListUtil.isNotEmpty(sousClasseComptable)) {
        sousClasseComptable.forEach(e -> e.setClasseComptable(classeComptable));
        }
        }




    }
