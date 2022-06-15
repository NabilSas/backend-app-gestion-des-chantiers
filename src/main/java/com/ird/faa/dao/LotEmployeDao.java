package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.LotEmploye;


@Repository
public interface LotEmployeDao extends JpaRepository<LotEmploye,Long> {






    List<LotEmploye> findByLotId(Long id);

    int deleteByLotId(Long id);

    List<LotEmploye> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);


}
