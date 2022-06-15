package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Lot;
import com.ird.faa.ws.rest.provided.vo.LotVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface LotChercheurService extends AbstractService<Lot,Long,LotVo>{





/**
    * delete Lot from database
    * @param id - id of Lot to be deleted
    *
    */
    int deleteById(Long id);


    List<Lot> findByPaiementLotReference(String reference);

    int deleteByPaiementLotReference(String reference);

    List<Lot> findByPaiementLotId(Long id);

    int deleteByPaiementLotId(Long id);

    List<Lot> findByEtatLotId(Long id);

    int deleteByEtatLotId(Long id);
    List<Lot> findByMarcheCode(Long code);

    int deleteByMarcheCode(Long code);

    List<Lot> findByMarcheId(Long id);

    int deleteByMarcheId(Long id);







}
