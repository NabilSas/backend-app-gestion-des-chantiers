package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.CategorieEmploye;
import com.ird.faa.ws.rest.provided.vo.CategorieEmployeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CategorieEmployeChercheurService extends AbstractService<CategorieEmploye,Long,CategorieEmployeVo>{



    /**
    * find CategorieEmploye from database by code (reference)
    * @param code - reference of CategorieEmploye
    * @return the founded CategorieEmploye , If no CategorieEmploye were
    *         found in database return  null.
    */
    CategorieEmploye findByCode(String code);

    /**
    * find CategorieEmploye from database by id (PK) or code (reference)
    * @param id - id of CategorieEmploye
    * @param code - reference of CategorieEmploye
    * @return the founded CategorieEmploye , If no CategorieEmploye were
    *         found in database return  null.
    */
    CategorieEmploye findByIdOrCode(CategorieEmploye categorieEmploye);


/**
    * delete CategorieEmploye from database
    * @param id - id of CategorieEmploye to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete CategorieEmploye from database by code (reference)
    *
    * @param code - reference of CategorieEmploye to be deleted
    * @return 1 if CategorieEmploye deleted successfully
    */
    int deleteByCode(String code);





}
