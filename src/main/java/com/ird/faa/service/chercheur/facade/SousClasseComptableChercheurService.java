package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.ws.rest.provided.vo.SousClasseComptableVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface SousClasseComptableChercheurService extends AbstractService<SousClasseComptable,Long,SousClasseComptableVo>{





/**
    * delete SousClasseComptable from database
    * @param id - id of SousClasseComptable to be deleted
    *
    */
    int deleteById(Long id);



    List<SousClasseComptable> findByClasseComptableId(Long id);

    int deleteByClasseComptableId(Long id);







}
