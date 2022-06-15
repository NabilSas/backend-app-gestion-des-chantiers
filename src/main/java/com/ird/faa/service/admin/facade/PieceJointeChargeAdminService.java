package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeCharge;
import com.ird.faa.ws.rest.provided.vo.PieceJointeChargeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeChargeAdminService extends AbstractService<PieceJointeCharge,Long,PieceJointeChargeVo>{





/**
    * delete PieceJointeCharge from database
    * @param id - id of PieceJointeCharge to be deleted
    *
    */
    int deleteById(Long id);



    List<PieceJointeCharge> findByChargeId(Long id);

    int deleteByChargeId(Long id);






    PieceJointeCharge archiver(PieceJointeCharge pieceJointeCharge) ;
    PieceJointeCharge desarchiver(PieceJointeCharge pieceJointeCharge);

}
