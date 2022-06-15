package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.EtatMarche;
import com.ird.faa.ws.rest.provided.vo.EtatMarcheVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatMarcheChercheurService extends AbstractService<EtatMarche,Long,EtatMarcheVo>{





/**
    * delete EtatMarche from database
    * @param id - id of EtatMarche to be deleted
    *
    */
    int deleteById(Long id);









}
