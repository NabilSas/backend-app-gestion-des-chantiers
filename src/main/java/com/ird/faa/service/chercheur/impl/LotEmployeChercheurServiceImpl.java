package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.LotEmploye;
        import com.ird.faa.bean.Lot;
        import com.ird.faa.bean.Employe;
import com.ird.faa.dao.LotEmployeDao;
import com.ird.faa.service.chercheur.facade.LotEmployeChercheurService;
        import com.ird.faa.service.chercheur.facade.LotChercheurService;
        import com.ird.faa.service.chercheur.facade.EmployeChercheurService;

import com.ird.faa.ws.rest.provided.vo.LotEmployeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class LotEmployeChercheurServiceImpl extends AbstractServiceImpl<LotEmploye> implements LotEmployeChercheurService {

@Autowired
private LotEmployeDao lotEmployeDao;

        @Autowired
        private LotChercheurService lotService ;
        @Autowired
        private EmployeChercheurService employeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<LotEmploye> findAll(){
        return lotEmployeDao.findAll();
}
        @Override
        public List<LotEmploye> findByLotId(Long id){
        return lotEmployeDao.findByLotId(id);
        }

        @Override
        @Transactional
        public int deleteByLotId(Long id){
        return lotEmployeDao.deleteByLotId(id);
        }

        @Override
        public List<LotEmploye> findByEmployeId(Long id){
        return lotEmployeDao.findByEmployeId(id);
        }

        @Override
        @Transactional
        public int deleteByEmployeId(Long id){
        return lotEmployeDao.deleteByEmployeId(id);
        }


@Override
public LotEmploye findById(Long id){
if(id==null) return null;
return lotEmployeDao.getOne(id);
}

@Override
public LotEmploye findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(lotEmployeDao.findById(id).isPresent())  {
lotEmployeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public LotEmploye update(LotEmploye lotEmploye){
LotEmploye foundedLotEmploye = findById(lotEmploye.getId());
if(foundedLotEmploye==null) return null;
else{
return  lotEmployeDao.save(lotEmploye);
}
}

@Override
public LotEmploye save (LotEmploye lotEmploye){



    findLot(lotEmploye);
    findEmploye(lotEmploye);

    return lotEmployeDao.save(lotEmploye);


}

@Override
public List<LotEmploye> save(List<LotEmploye> lotEmployes){
List<LotEmploye> list = new ArrayList<>();
for(LotEmploye lotEmploye: lotEmployes){
list.add(save(lotEmploye));
}
return list;
}



@Override
@Transactional
public int delete(LotEmploye lotEmploye){
    if(lotEmploye.getId()==null) return -1;
    LotEmploye foundedLotEmploye = findById(lotEmploye.getId());
    if(foundedLotEmploye==null) return -1;
lotEmployeDao.delete(foundedLotEmploye);
return 1;
}


public List<LotEmploye> findByCriteria(LotEmployeVo lotEmployeVo){

String query = "SELECT o FROM LotEmploye o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",lotEmployeVo.getId());
    if(lotEmployeVo.getLotVo()!=null){
        query += SearchUtil.addConstraint( "o", "lot.id","=",lotEmployeVo.getLotVo().getId());
    }

    if(lotEmployeVo.getEmployeVo()!=null){
        query += SearchUtil.addConstraint( "o", "employe.id","=",lotEmployeVo.getEmployeVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findLot(LotEmploye lotEmploye){
        Lot loadedLot = null;
        if(lotEmploye.getLot() != null && lotEmploye.getLot().getId() !=null)
        loadedLot =lotService.findById(lotEmploye.getLot().getId());

    if(loadedLot==null ) {
    return;
    }
    lotEmploye.setLot(loadedLot);
    }
    private void findEmploye(LotEmploye lotEmploye){
        Employe loadedEmploye = null;
        if(lotEmploye.getEmploye() != null && lotEmploye.getEmploye().getId() !=null)
        loadedEmploye =employeService.findById(lotEmploye.getEmploye().getId());

    if(loadedEmploye==null ) {
    return;
    }
    lotEmploye.setEmploye(loadedEmploye);
    }

@Override
@Transactional
public void delete(List<LotEmploye> lotEmployes){
if(ListUtil.isNotEmpty(lotEmployes)){
lotEmployes.forEach(e->lotEmployeDao.delete(e));
}
}
@Override
public void update(List<LotEmploye> lotEmployes){
if(ListUtil.isNotEmpty(lotEmployes)){
lotEmployes.forEach(e->lotEmployeDao.save(e));
}
}





    }
