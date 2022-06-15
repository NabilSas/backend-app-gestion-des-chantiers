package com.ird.faa.service.maitreouvrage.facade;

import java.util.List;
import com.ird.faa.bean.ClasseComptable;
import com.ird.faa.ws.rest.provided.vo.ClasseComptableVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ClasseComptableMaitreouvrageService extends AbstractService<ClasseComptable,Long,ClasseComptableVo>{





/**
    * delete ClasseComptable from database
    * @param id - id of ClasseComptable to be deleted
    *
    */
    int deleteById(Long id);









}
