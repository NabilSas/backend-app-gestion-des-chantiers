package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.EtatLot;
import com.ird.faa.ws.rest.provided.vo.EtatLotVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatLotChercheurService extends AbstractService<EtatLot,Long,EtatLotVo>{





/**
    * delete EtatLot from database
    * @param id - id of EtatLot to be deleted
    *
    */
    int deleteById(Long id);









}
