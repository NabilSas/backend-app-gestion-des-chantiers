package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Charge;
import com.ird.faa.ws.rest.provided.vo.ChargeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ChargeChercheurService extends AbstractService<Charge,Long,ChargeVo>{





/**
    * delete Charge from database
    * @param id - id of Charge to be deleted
    *
    */
    int deleteById(Long id);



    List<Charge> findByCompteComptableId(Long id);

    int deleteByCompteComptableId(Long id);

    List<Charge> findByEtatChargeId(Long id);

    int deleteByEtatChargeId(Long id);

    List<Charge> findByCategorieChargeId(Long id);

    int deleteByCategorieChargeId(Long id);
    List<Charge> findByProduitReference(String reference);

    int deleteByProduitReference(String reference);

    List<Charge> findByProduitId(Long id);

    int deleteByProduitId(Long id);







}
