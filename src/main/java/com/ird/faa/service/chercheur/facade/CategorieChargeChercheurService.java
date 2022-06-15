package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.CategorieCharge;
import com.ird.faa.ws.rest.provided.vo.CategorieChargeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CategorieChargeChercheurService extends AbstractService<CategorieCharge,Long,CategorieChargeVo>{





/**
    * delete CategorieCharge from database
    * @param id - id of CategorieCharge to be deleted
    *
    */
    int deleteById(Long id);









}
