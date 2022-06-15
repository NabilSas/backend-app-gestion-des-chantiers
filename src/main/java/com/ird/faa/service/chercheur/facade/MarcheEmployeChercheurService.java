package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.MarcheEmploye;
import com.ird.faa.ws.rest.provided.vo.MarcheEmployeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MarcheEmployeChercheurService extends AbstractService<MarcheEmploye,Long,MarcheEmployeVo>{





/**
    * delete MarcheEmploye from database
    * @param id - id of MarcheEmploye to be deleted
    *
    */
    int deleteById(Long id);


    List<MarcheEmploye> findByMarcheCode(Long code);

    int deleteByMarcheCode(Long code);

    List<MarcheEmploye> findByMarcheId(Long id);

    int deleteByMarcheId(Long id);

    List<MarcheEmploye> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);







}
