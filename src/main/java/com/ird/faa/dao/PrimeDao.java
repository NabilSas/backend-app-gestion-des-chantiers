package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Prime;


@Repository
public interface PrimeDao extends JpaRepository<Prime,Long> {






    List<Prime> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);

    List<Prime> findByLotId(Long id);

    int deleteByLotId(Long id);


}
