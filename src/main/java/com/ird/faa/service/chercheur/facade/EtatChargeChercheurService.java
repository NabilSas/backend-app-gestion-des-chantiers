package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.EtatCharge;
import com.ird.faa.ws.rest.provided.vo.EtatChargeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatChargeChercheurService extends AbstractService<EtatCharge,Long,EtatChargeVo>{





/**
    * delete EtatCharge from database
    * @param id - id of EtatCharge to be deleted
    *
    */
    int deleteById(Long id);









}
