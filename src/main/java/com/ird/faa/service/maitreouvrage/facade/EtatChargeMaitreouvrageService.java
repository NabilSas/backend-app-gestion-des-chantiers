package com.ird.faa.service.maitreouvrage.facade;

import java.util.List;
import com.ird.faa.bean.EtatCharge;
import com.ird.faa.ws.rest.provided.vo.EtatChargeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatChargeMaitreouvrageService extends AbstractService<EtatCharge,Long,EtatChargeVo>{





/**
    * delete EtatCharge from database
    * @param id - id of EtatCharge to be deleted
    *
    */
    int deleteById(Long id);








    EtatCharge archiver(EtatCharge etatCharge) ;
    EtatCharge desarchiver(EtatCharge etatCharge);

}
