package com.ird.faa.service.maitreouvrage.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.CompteComptable;
        import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.dao.CompteComptableDao;
import com.ird.faa.service.maitreouvrage.facade.CompteComptableMaitreouvrageService;
        import com.ird.faa.service.maitreouvrage.facade.SousClasseComptableMaitreouvrageService;

import com.ird.faa.ws.rest.provided.vo.CompteComptableVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CompteComptableMaitreouvrageServiceImpl extends AbstractServiceImpl<CompteComptable> implements CompteComptableMaitreouvrageService {

@Autowired
private CompteComptableDao compteComptableDao;

        @Autowired
        private SousClasseComptableMaitreouvrageService sousClasseComptableService ;


@Autowired
private EntityManager entityManager;


@Override
public List<CompteComptable> findAll(){
        return compteComptableDao.findAll();
}
        @Override
        public List<CompteComptable> findBySousClasseComptableId(Long id){
        return compteComptableDao.findBySousClasseComptableId(id);
        }

        @Override
        @Transactional
        public int deleteBySousClasseComptableId(Long id){
        return compteComptableDao.deleteBySousClasseComptableId(id);
        }


@Override
public CompteComptable findById(Long id){
if(id==null) return null;
return compteComptableDao.getOne(id);
}

@Override
public CompteComptable findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(compteComptableDao.findById(id).isPresent())  {
compteComptableDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CompteComptable update(CompteComptable compteComptable){
CompteComptable foundedCompteComptable = findById(compteComptable.getId());
if(foundedCompteComptable==null) return null;
else{
return  compteComptableDao.save(compteComptable);
}
}

@Override
public CompteComptable save (CompteComptable compteComptable){



    findSousClasseComptable(compteComptable);

    return compteComptableDao.save(compteComptable);


}

@Override
public List<CompteComptable> save(List<CompteComptable> compteComptables){
List<CompteComptable> list = new ArrayList<>();
for(CompteComptable compteComptable: compteComptables){
list.add(save(compteComptable));
}
return list;
}



@Override
@Transactional
public int delete(CompteComptable compteComptable){
    if(compteComptable.getId()==null) return -1;
    CompteComptable foundedCompteComptable = findById(compteComptable.getId());
    if(foundedCompteComptable==null) return -1;
compteComptableDao.delete(foundedCompteComptable);
return 1;
}


public List<CompteComptable> findByCriteria(CompteComptableVo compteComptableVo){

String query = "SELECT o FROM CompteComptable o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",compteComptableVo.getId());
            query += SearchUtil.addConstraint( "o", "code","=",compteComptableVo.getCode());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",compteComptableVo.getLibelle());
            query += SearchUtil.addConstraintMinMax("o","code",compteComptableVo.getCodeMin(),compteComptableVo.getCodeMax());
    if(compteComptableVo.getSousClasseComptableVo()!=null){
        query += SearchUtil.addConstraint( "o", "sousClasseComptable.id","=",compteComptableVo.getSousClasseComptableVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findSousClasseComptable(CompteComptable compteComptable){
        SousClasseComptable loadedSousClasseComptable = null;
        if(compteComptable.getSousClasseComptable() != null && compteComptable.getSousClasseComptable().getId() !=null)
        loadedSousClasseComptable =sousClasseComptableService.findById(compteComptable.getSousClasseComptable().getId());

    if(loadedSousClasseComptable==null ) {
    return;
    }
    compteComptable.setSousClasseComptable(loadedSousClasseComptable);
    }

@Override
@Transactional
public void delete(List<CompteComptable> compteComptables){
if(ListUtil.isNotEmpty(compteComptables)){
compteComptables.forEach(e->compteComptableDao.delete(e));
}
}
@Override
public void update(List<CompteComptable> compteComptables){
if(ListUtil.isNotEmpty(compteComptables)){
compteComptables.forEach(e->compteComptableDao.save(e));
}
}





    }
