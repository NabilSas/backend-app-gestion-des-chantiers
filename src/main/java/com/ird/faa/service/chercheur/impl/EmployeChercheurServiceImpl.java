package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Employe;
        import com.ird.faa.bean.CategorieEmploye;
        import com.ird.faa.bean.Prime;
import com.ird.faa.dao.EmployeDao;
import com.ird.faa.service.chercheur.facade.EmployeChercheurService;
        import com.ird.faa.service.chercheur.facade.PrimeChercheurService;
        import com.ird.faa.service.chercheur.facade.CategorieEmployeChercheurService;

import com.ird.faa.ws.rest.provided.vo.EmployeVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.Prime;
        import com.ird.faa.service.chercheur.facade.PrimeChercheurService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EmployeChercheurServiceImpl extends AbstractServiceImpl<Employe> implements EmployeChercheurService {

@Autowired
private EmployeDao employeDao;

        @Autowired
        private PrimeChercheurService primeService ;
        @Autowired
        private CategorieEmployeChercheurService categorieEmployeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Employe> findAll(){
        return employeDao.findAll();
}

        @Override
        public List<Employe> findByCategorieEmployeCode(String code){
        return employeDao.findByCategorieEmployeCode(code);
        }

        @Override
        @Transactional
        public int deleteByCategorieEmployeCode(String code){
        return employeDao.deleteByCategorieEmployeCode(code);
        }

        @Override
        public List<Employe> findByCategorieEmployeId(Long id){
        return employeDao.findByCategorieEmployeId(id);
        }

        @Override
        @Transactional
        public int deleteByCategorieEmployeId(Long id){
        return employeDao.deleteByCategorieEmployeId(id);
        }


@Override
public Employe findById(Long id){
if(id==null) return null;
return employeDao.getOne(id);
}

@Override
public Employe findByIdWithAssociatedList(Long id){
    Employe employe  = findById(id);
    findAssociatedLists(employe);
    return employe;
}

    private void findAssociatedLists(Employe employe){
    if(employe!=null && employe.getId() != null) {
            List<Prime> primes = primeService.findByEmployeId(employe.getId());
            employe.setPrimes(primes);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            primeService.deleteByEmployeId(id);
    }
    }

    private void updateAssociatedLists(Employe employe){
    if(employe !=null && employe.getId() != null){
            List
            <List<Prime>> resultPrimes= primeService.getToBeSavedAndToBeDeleted(primeService.findByEmployeId(employe.getId()),employe.getPrimes());
            primeService.delete(resultPrimes.get(1));
            associatePrime(employe,resultPrimes.get(0));
            primeService.update(resultPrimes.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(employeDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
employeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Employe update(Employe employe){
Employe foundedEmploye = findById(employe.getId());
if(foundedEmploye==null) return null;
else{
    updateAssociatedLists(employe);
return  employeDao.save(employe);
}
}

@Override
public Employe save (Employe employe){

    Employe result =null;


    findCategorieEmploye(employe);

    Employe savedEmploye = employeDao.save(employe);

        savePrimes(savedEmploye,employe.getPrimes());
    result = savedEmploye;

    return result;
}

@Override
public List<Employe> save(List<Employe> employes){
List<Employe> list = new ArrayList<>();
for(Employe employe: employes){
list.add(save(employe));
}
return list;
}

        private List<Prime> preparePrimes(Employe employe,List<Prime> primes){
        for(Prime prime:primes ){
        prime.setEmploye(employe);
        }
        return primes;
        }


@Override
@Transactional
public int delete(Employe employe){
    if(employe.getId()==null) return -1;
    Employe foundedEmploye = findById(employe.getId());
    if(foundedEmploye==null) return -1;
employeDao.delete(foundedEmploye);
return 1;
}


public List<Employe> findByCriteria(EmployeVo employeVo){

String query = "SELECT o FROM Employe o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",employeVo.getId());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",employeVo.getCin());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",employeVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",employeVo.getNom());
            query += SearchUtil.addConstraint( "o", "numCouvertureMedicale","LIKE",employeVo.getNumCouvertureMedicale());
            query += SearchUtil.addConstraint( "o", "salaireBrut","=",employeVo.getSalaireBrut());
            query += SearchUtil.addConstraint( "o", "salaireNet","=",employeVo.getSalaireNet());
            query += SearchUtil.addConstraintMinMax("o","salaireBrut",employeVo.getSalaireBrutMin(),employeVo.getSalaireBrutMax());
            query += SearchUtil.addConstraintMinMax("o","salaireNet",employeVo.getSalaireNetMin(),employeVo.getSalaireNetMax());
    if(employeVo.getCategorieEmployeVo()!=null){
        query += SearchUtil.addConstraint( "o", "categorieEmploye.id","=",employeVo.getCategorieEmployeVo().getId());
            query += SearchUtil.addConstraint( "o", "categorieEmploye.code","LIKE",employeVo.getCategorieEmployeVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void savePrimes(Employe employe,List<Prime> primes){

        if (ListUtil.isNotEmpty(employe.getPrimes())) {
        List<Prime> savedPrimes = new ArrayList<>();
        primes.forEach(element -> {
        element.setEmploye(employe);
         primeService.save(element);
        });
        employe.setPrimes(savedPrimes);
        }
        }

    private void findCategorieEmploye(Employe employe){
        CategorieEmploye loadedCategorieEmploye =categorieEmployeService.findByIdOrCode(employe.getCategorieEmploye());

    if(loadedCategorieEmploye==null ) {
    return;
    }
    employe.setCategorieEmploye(loadedCategorieEmploye);
    }

@Override
@Transactional
public void delete(List<Employe> employes){
if(ListUtil.isNotEmpty(employes)){
employes.forEach(e->employeDao.delete(e));
}
}
@Override
public void update(List<Employe> employes){
if(ListUtil.isNotEmpty(employes)){
employes.forEach(e->employeDao.save(e));
}
}

        private void associatePrime(Employe employe, List<Prime> prime) {
        if (ListUtil.isNotEmpty(prime)) {
        prime.forEach(e -> e.setEmploye(employe));
        }
        }




    }
