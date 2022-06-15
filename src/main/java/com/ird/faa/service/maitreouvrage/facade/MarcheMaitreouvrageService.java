package com.ird.faa.service.maitreouvrage.facade;

import java.util.List;
import com.ird.faa.bean.Marche;
import com.ird.faa.ws.rest.provided.vo.MarcheVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MarcheMaitreouvrageService extends AbstractService<Marche,Long,MarcheVo>{



    /**
    * find Marche from database by code (reference)
    * @param code - reference of Marche
    * @return the founded Marche , If no Marche were
    *         found in database return  null.
    */
    Marche findByCode(Long code);

    /**
    * find Marche from database by id (PK) or code (reference)
    * @param id - id of Marche
    * @param code - reference of Marche
    * @return the founded Marche , If no Marche were
    *         found in database return  null.
    */
    Marche findByIdOrCode(Marche marche);


/**
    * delete Marche from database
    * @param id - id of Marche to be deleted
    *
    */
    int deleteById(Long id);


    List<Marche> findByMaitreOuvrageIce(String ice);

    int deleteByMaitreOuvrageIce(String ice);

    List<Marche> findByMaitreOuvrageId(Long id);

    int deleteByMaitreOuvrageId(Long id);

    List<Marche> findByEtatMarcheId(Long id);

    int deleteByEtatMarcheId(Long id);


    /**
    * delete Marche from database by code (reference)
    *
    * @param code - reference of Marche to be deleted
    * @return 1 if Marche deleted successfully
    */
    int deleteByCode(Long code);




    Marche archiver(Marche marche) ;
    Marche desarchiver(Marche marche);

}
