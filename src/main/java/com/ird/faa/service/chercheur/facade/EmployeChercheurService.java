package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Employe;
import com.ird.faa.ws.rest.provided.vo.EmployeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EmployeChercheurService extends AbstractService<Employe,Long,EmployeVo>{





/**
    * delete Employe from database
    * @param id - id of Employe to be deleted
    *
    */
    int deleteById(Long id);


    List<Employe> findByCategorieEmployeCode(String code);

    int deleteByCategorieEmployeCode(String code);

    List<Employe> findByCategorieEmployeId(Long id);

    int deleteByCategorieEmployeId(Long id);







}
