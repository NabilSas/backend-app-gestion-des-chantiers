package com.ird.faa.service.maitreouvrage.facade;

import java.util.List;
import com.ird.faa.bean.TypePaiementLot;
import com.ird.faa.ws.rest.provided.vo.TypePaiementLotVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypePaiementLotMaitreouvrageService extends AbstractService<TypePaiementLot,Long,TypePaiementLotVo>{





/**
    * delete TypePaiementLot from database
    * @param id - id of TypePaiementLot to be deleted
    *
    */
    int deleteById(Long id);









}
