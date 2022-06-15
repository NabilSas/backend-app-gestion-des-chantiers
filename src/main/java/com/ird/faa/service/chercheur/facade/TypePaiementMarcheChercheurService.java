package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.TypePaiementMarche;
import com.ird.faa.ws.rest.provided.vo.TypePaiementMarcheVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypePaiementMarcheChercheurService extends AbstractService<TypePaiementMarche,Long,TypePaiementMarcheVo>{





/**
    * delete TypePaiementMarche from database
    * @param id - id of TypePaiementMarche to be deleted
    *
    */
    int deleteById(Long id);









}
