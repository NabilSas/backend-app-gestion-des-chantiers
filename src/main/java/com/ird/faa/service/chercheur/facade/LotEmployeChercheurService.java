package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.LotEmploye;
import com.ird.faa.ws.rest.provided.vo.LotEmployeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface LotEmployeChercheurService extends AbstractService<LotEmploye,Long,LotEmployeVo>{





/**
    * delete LotEmploye from database
    * @param id - id of LotEmploye to be deleted
    *
    */
    int deleteById(Long id);



    List<LotEmploye> findByLotId(Long id);

    int deleteByLotId(Long id);

    List<LotEmploye> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);







}
