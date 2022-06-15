package com.ird.faa.service.maitreouvrage.facade;

import java.util.List;
import com.ird.faa.bean.CategorieCharge;
import com.ird.faa.ws.rest.provided.vo.CategorieChargeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CategorieChargeMaitreouvrageService extends AbstractService<CategorieCharge,Long,CategorieChargeVo>{





/**
    * delete CategorieCharge from database
    * @param id - id of CategorieCharge to be deleted
    *
    */
    int deleteById(Long id);








    CategorieCharge archiver(CategorieCharge categorieCharge) ;
    CategorieCharge desarchiver(CategorieCharge categorieCharge);

}
