package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.MarcheEmploye;
        import com.ird.faa.bean.Marche;
        import com.ird.faa.bean.Employe;
import com.ird.faa.dao.MarcheEmployeDao;
import com.ird.faa.service.admin.facade.MarcheEmployeAdminService;
        import com.ird.faa.service.admin.facade.MarcheAdminService;
        import com.ird.faa.service.admin.facade.EmployeAdminService;

import com.ird.faa.ws.rest.provided.vo.MarcheEmployeVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MarcheEmployeAdminServiceImpl extends AbstractServiceImpl<MarcheEmploye> implements MarcheEmployeAdminService {

@Autowired
private MarcheEmployeDao marcheEmployeDao;

    @Autowired
    private ArchivableService<MarcheEmploye> archivableService;
        @Autowired
        private MarcheAdminService marcheService ;
        @Autowired
        private EmployeAdminService employeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<MarcheEmploye> findAll(){
        return marcheEmployeDao.findAll();
}

        @Override
        public List<MarcheEmploye> findByMarcheCode(Long code){
        return marcheEmployeDao.findByMarcheCode(code);
        }

        @Override
        @Transactional
        public int deleteByMarcheCode(Long code){
        return marcheEmployeDao.deleteByMarcheCode(code);
        }

        @Override
        public List<MarcheEmploye> findByMarcheId(Long id){
        return marcheEmployeDao.findByMarcheId(id);
        }

        @Override
        @Transactional
        public int deleteByMarcheId(Long id){
        return marcheEmployeDao.deleteByMarcheId(id);
        }

        @Override
        public List<MarcheEmploye> findByEmployeId(Long id){
        return marcheEmployeDao.findByEmployeId(id);
        }

        @Override
        @Transactional
        public int deleteByEmployeId(Long id){
        return marcheEmployeDao.deleteByEmployeId(id);
        }


@Override
public MarcheEmploye findById(Long id){
if(id==null) return null;
return marcheEmployeDao.getOne(id);
}

@Override
public MarcheEmploye findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public MarcheEmploye archiver(MarcheEmploye marcheEmploye) {
    if (marcheEmploye.getArchive() == null) {
    marcheEmploye.setArchive(false);
    }
    marcheEmploye.setArchive(true);
    marcheEmploye.setDateArchivage(new Date());
    marcheEmployeDao.save(marcheEmploye);
    return marcheEmploye;

    }

    @Override
    public MarcheEmploye desarchiver(MarcheEmploye marcheEmploye) {
    if (marcheEmploye.getArchive() == null) {
    marcheEmploye.setArchive(false);
    }
    marcheEmploye.setArchive(false);
    marcheEmployeDao.save(marcheEmploye);
    return marcheEmploye;
    }




@Transactional
public int deleteById(Long id){
int res=0;
if(marcheEmployeDao.findById(id).isPresent())  {
marcheEmployeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public MarcheEmploye update(MarcheEmploye marcheEmploye){
MarcheEmploye foundedMarcheEmploye = findById(marcheEmploye.getId());
if(foundedMarcheEmploye==null) return null;
else{
    archivableService.prepare(marcheEmploye);
return  marcheEmployeDao.save(marcheEmploye);
}
}
    private void prepareSave(MarcheEmploye marcheEmploye){
        marcheEmploye.setDateCreation(new Date());
        if(marcheEmploye.getDateArchivage() == null)
        marcheEmploye.setDateArchivage(new Date());
                    if(marcheEmploye.getArchive() == null)
                marcheEmploye.setArchive(false);




    }

@Override
public MarcheEmploye save (MarcheEmploye marcheEmploye){
    prepareSave(marcheEmploye);



    findMarche(marcheEmploye);
    findEmploye(marcheEmploye);

    return marcheEmployeDao.save(marcheEmploye);


}

@Override
public List<MarcheEmploye> save(List<MarcheEmploye> marcheEmployes){
List<MarcheEmploye> list = new ArrayList<>();
for(MarcheEmploye marcheEmploye: marcheEmployes){
list.add(save(marcheEmploye));
}
return list;
}



@Override
@Transactional
public int delete(MarcheEmploye marcheEmploye){
    if(marcheEmploye.getId()==null) return -1;
    MarcheEmploye foundedMarcheEmploye = findById(marcheEmploye.getId());
    if(foundedMarcheEmploye==null) return -1;
marcheEmployeDao.delete(foundedMarcheEmploye);
return 1;
}


public List<MarcheEmploye> findByCriteria(MarcheEmployeVo marcheEmployeVo){

String query = "SELECT o FROM MarcheEmploye o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",marcheEmployeVo.getId());
            query += SearchUtil.addConstraint( "o", "archive","=",marcheEmployeVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",marcheEmployeVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",marcheEmployeVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",marcheEmployeVo.getDateArchivageMin(),marcheEmployeVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",marcheEmployeVo.getDateCreationMin(),marcheEmployeVo.getDateCreationMax());
    if(marcheEmployeVo.getMarcheVo()!=null){
        query += SearchUtil.addConstraint( "o", "marche.id","=",marcheEmployeVo.getMarcheVo().getId());
            query += SearchUtil.addConstraint( "o", "marche.code","=",marcheEmployeVo.getMarcheVo().getCode());
    }

    if(marcheEmployeVo.getEmployeVo()!=null){
        query += SearchUtil.addConstraint( "o", "employe.id","=",marcheEmployeVo.getEmployeVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findMarche(MarcheEmploye marcheEmploye){
        Marche loadedMarche =marcheService.findByIdOrCode(marcheEmploye.getMarche());

    if(loadedMarche==null ) {
    return;
    }
    marcheEmploye.setMarche(loadedMarche);
    }
    private void findEmploye(MarcheEmploye marcheEmploye){
        Employe loadedEmploye = null;
        if(marcheEmploye.getEmploye() != null && marcheEmploye.getEmploye().getId() !=null)
        loadedEmploye =employeService.findById(marcheEmploye.getEmploye().getId());

    if(loadedEmploye==null ) {
    return;
    }
    marcheEmploye.setEmploye(loadedEmploye);
    }

@Override
@Transactional
public void delete(List<MarcheEmploye> marcheEmployes){
if(ListUtil.isNotEmpty(marcheEmployes)){
marcheEmployes.forEach(e->marcheEmployeDao.delete(e));
}
}
@Override
public void update(List<MarcheEmploye> marcheEmployes){
if(ListUtil.isNotEmpty(marcheEmployes)){
marcheEmployes.forEach(e->marcheEmployeDao.save(e));
}
}





    }
