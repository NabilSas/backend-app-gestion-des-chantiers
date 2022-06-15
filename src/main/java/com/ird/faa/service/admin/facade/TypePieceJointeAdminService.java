package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.TypePieceJointe;
import com.ird.faa.ws.rest.provided.vo.TypePieceJointeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypePieceJointeAdminService extends AbstractService<TypePieceJointe,Long,TypePieceJointeVo>{



    /**
    * find TypePieceJointe from database by code (reference)
    * @param code - reference of TypePieceJointe
    * @return the founded TypePieceJointe , If no TypePieceJointe were
    *         found in database return  null.
    */
    TypePieceJointe findByCode(String code);

    /**
    * find TypePieceJointe from database by id (PK) or code (reference)
    * @param id - id of TypePieceJointe
    * @param code - reference of TypePieceJointe
    * @return the founded TypePieceJointe , If no TypePieceJointe were
    *         found in database return  null.
    */
    TypePieceJointe findByIdOrCode(TypePieceJointe typePieceJointe);


/**
    * delete TypePieceJointe from database
    * @param id - id of TypePieceJointe to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypePieceJointe from database by code (reference)
    *
    * @param code - reference of TypePieceJointe to be deleted
    * @return 1 if TypePieceJointe deleted successfully
    */
    int deleteByCode(String code);




    TypePieceJointe archiver(TypePieceJointe typePieceJointe) ;
    TypePieceJointe desarchiver(TypePieceJointe typePieceJointe);

}
