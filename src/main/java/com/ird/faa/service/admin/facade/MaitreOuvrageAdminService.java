package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.MaitreOuvrage;
import com.ird.faa.ws.rest.provided.vo.MaitreOuvrageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MaitreOuvrageAdminService extends AbstractService<MaitreOuvrage,Long,MaitreOuvrageVo>{

    MaitreOuvrage findByUsername(String username);


    /**
    * find MaitreOuvrage from database by ice (reference)
    * @param ice - reference of MaitreOuvrage
    * @return the founded MaitreOuvrage , If no MaitreOuvrage were
    *         found in database return  null.
    */
    MaitreOuvrage findByIce(String ice);

    /**
    * find MaitreOuvrage from database by id (PK) or ice (reference)
    * @param id - id of MaitreOuvrage
    * @param ice - reference of MaitreOuvrage
    * @return the founded MaitreOuvrage , If no MaitreOuvrage were
    *         found in database return  null.
    */
    MaitreOuvrage findByIdOrIce(MaitreOuvrage maitreOuvrage);


/**
    * delete MaitreOuvrage from database
    * @param id - id of MaitreOuvrage to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete MaitreOuvrage from database by ice (reference)
    *
    * @param ice - reference of MaitreOuvrage to be deleted
    * @return 1 if MaitreOuvrage deleted successfully
    */
    int deleteByIce(String ice);





}
