package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.CompteComptable;
import com.ird.faa.ws.rest.provided.vo.CompteComptableVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CompteComptableChercheurService extends AbstractService<CompteComptable,Long,CompteComptableVo>{





/**
    * delete CompteComptable from database
    * @param id - id of CompteComptable to be deleted
    *
    */
    int deleteById(Long id);



    List<CompteComptable> findBySousClasseComptableId(Long id);

    int deleteBySousClasseComptableId(Long id);







}
