package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Prime;
        import com.ird.faa.bean.Employe;
        import com.ird.faa.bean.Lot;
import com.ird.faa.dao.PrimeDao;
import com.ird.faa.service.chercheur.facade.PrimeChercheurService;
        import com.ird.faa.service.chercheur.facade.LotChercheurService;
        import com.ird.faa.service.chercheur.facade.EmployeChercheurService;

import com.ird.faa.ws.rest.provided.vo.PrimeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PrimeChercheurServiceImpl extends AbstractServiceImpl<Prime> implements PrimeChercheurService {

@Autowired
private PrimeDao primeDao;

        @Autowired
        private LotChercheurService lotService ;
        @Autowired
        private EmployeChercheurService employeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Prime> findAll(){
        return primeDao.findAll();
}
        @Override
        public List<Prime> findByEmployeId(Long id){
        return primeDao.findByEmployeId(id);
        }

        @Override
        @Transactional
        public int deleteByEmployeId(Long id){
        return primeDao.deleteByEmployeId(id);
        }

        @Override
        public List<Prime> findByLotId(Long id){
        return primeDao.findByLotId(id);
        }

        @Override
        @Transactional
        public int deleteByLotId(Long id){
        return primeDao.deleteByLotId(id);
        }


@Override
public Prime findById(Long id){
if(id==null) return null;
return primeDao.getOne(id);
}

@Override
public Prime findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(primeDao.findById(id).isPresent())  {
primeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Prime update(Prime prime){
Prime foundedPrime = findById(prime.getId());
if(foundedPrime==null) return null;
else{
return  primeDao.save(prime);
}
}

@Override
public Prime save (Prime prime){



    findEmploye(prime);
    findLot(prime);

    return primeDao.save(prime);


}

@Override
public List<Prime> save(List<Prime> primes){
List<Prime> list = new ArrayList<>();
for(Prime prime: primes){
list.add(save(prime));
}
return list;
}



@Override
@Transactional
public int delete(Prime prime){
    if(prime.getId()==null) return -1;
    Prime foundedPrime = findById(prime.getId());
    if(foundedPrime==null) return -1;
primeDao.delete(foundedPrime);
return 1;
}


public List<Prime> findByCriteria(PrimeVo primeVo){

String query = "SELECT o FROM Prime o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",primeVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",primeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "description","LIKE",primeVo.getDescription());
        query += SearchUtil.addConstraintDate( "o", "datePrime","=",primeVo.getDatePrime());
            query += SearchUtil.addConstraintMinMaxDate("o","datePrime",primeVo.getDatePrimeMin(),primeVo.getDatePrimeMax());
    if(primeVo.getEmployeVo()!=null){
        query += SearchUtil.addConstraint( "o", "employe.id","=",primeVo.getEmployeVo().getId());
    }

    if(primeVo.getLotVo()!=null){
        query += SearchUtil.addConstraint( "o", "lot.id","=",primeVo.getLotVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEmploye(Prime prime){
        Employe loadedEmploye = null;
        if(prime.getEmploye() != null && prime.getEmploye().getId() !=null)
        loadedEmploye =employeService.findById(prime.getEmploye().getId());

    if(loadedEmploye==null ) {
    return;
    }
    prime.setEmploye(loadedEmploye);
    }
    private void findLot(Prime prime){
        Lot loadedLot = null;
        if(prime.getLot() != null && prime.getLot().getId() !=null)
        loadedLot =lotService.findById(prime.getLot().getId());

    if(loadedLot==null ) {
    return;
    }
    prime.setLot(loadedLot);
    }

@Override
@Transactional
public void delete(List<Prime> primes){
if(ListUtil.isNotEmpty(primes)){
primes.forEach(e->primeDao.delete(e));
}
}
@Override
public void update(List<Prime> primes){
if(ListUtil.isNotEmpty(primes)){
primes.forEach(e->primeDao.save(e));
}
}





    }
