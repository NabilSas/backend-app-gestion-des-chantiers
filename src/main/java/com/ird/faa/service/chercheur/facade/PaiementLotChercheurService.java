package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.PaiementLot;
import com.ird.faa.ws.rest.provided.vo.PaiementLotVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PaiementLotChercheurService extends AbstractService<PaiementLot,Long,PaiementLotVo>{



    /**
    * find PaiementLot from database by reference (reference)
    * @param reference - reference of PaiementLot
    * @return the founded PaiementLot , If no PaiementLot were
    *         found in database return  null.
    */
    PaiementLot findByReference(String reference);

    /**
    * find PaiementLot from database by id (PK) or reference (reference)
    * @param id - id of PaiementLot
    * @param reference - reference of PaiementLot
    * @return the founded PaiementLot , If no PaiementLot were
    *         found in database return  null.
    */
    PaiementLot findByIdOrReference(PaiementLot paiementLot);


/**
    * delete PaiementLot from database
    * @param id - id of PaiementLot to be deleted
    *
    */
    int deleteById(Long id);



    List<PaiementLot> findByTypePaiementLotId(Long id);

    int deleteByTypePaiementLotId(Long id);

    List<PaiementLot> findByLotId(Long id);

    int deleteByLotId(Long id);


    /**
    * delete PaiementLot from database by reference (reference)
    *
    * @param reference - reference of PaiementLot to be deleted
    * @return 1 if PaiementLot deleted successfully
    */
    int deleteByReference(String reference);





}
