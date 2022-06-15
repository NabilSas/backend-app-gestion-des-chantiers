package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.PaiementMarche;
import com.ird.faa.ws.rest.provided.vo.PaiementMarcheVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PaiementMarcheAdminService extends AbstractService<PaiementMarche,Long,PaiementMarcheVo>{



    /**
    * find PaiementMarche from database by reference (reference)
    * @param reference - reference of PaiementMarche
    * @return the founded PaiementMarche , If no PaiementMarche were
    *         found in database return  null.
    */
    PaiementMarche findByReference(String reference);

    /**
    * find PaiementMarche from database by id (PK) or reference (reference)
    * @param id - id of PaiementMarche
    * @param reference - reference of PaiementMarche
    * @return the founded PaiementMarche , If no PaiementMarche were
    *         found in database return  null.
    */
    PaiementMarche findByIdOrReference(PaiementMarche paiementMarche);


/**
    * delete PaiementMarche from database
    * @param id - id of PaiementMarche to be deleted
    *
    */
    int deleteById(Long id);



    List<PaiementMarche> findByTypePaiementMarcheId(Long id);

    int deleteByTypePaiementMarcheId(Long id);
    List<PaiementMarche> findByMarcheCode(Long code);

    int deleteByMarcheCode(Long code);

    List<PaiementMarche> findByMarcheId(Long id);

    int deleteByMarcheId(Long id);


    /**
    * delete PaiementMarche from database by reference (reference)
    *
    * @param reference - reference of PaiementMarche to be deleted
    * @return 1 if PaiementMarche deleted successfully
    */
    int deleteByReference(String reference);





}
