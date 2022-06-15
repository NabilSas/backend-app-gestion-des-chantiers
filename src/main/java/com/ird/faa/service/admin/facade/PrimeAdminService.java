package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Prime;
import com.ird.faa.ws.rest.provided.vo.PrimeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PrimeAdminService extends AbstractService<Prime,Long,PrimeVo>{





/**
    * delete Prime from database
    * @param id - id of Prime to be deleted
    *
    */
    int deleteById(Long id);



    List<Prime> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);

    List<Prime> findByLotId(Long id);

    int deleteByLotId(Long id);







}
