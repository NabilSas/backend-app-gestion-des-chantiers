package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.MarcheEmploye;


@Repository
public interface MarcheEmployeDao extends JpaRepository<MarcheEmploye,Long> {





    List<MarcheEmploye> findByMarcheCode(Long code);
    int deleteByMarcheCode(Long code);

    List<MarcheEmploye> findByMarcheId(Long id);

    int deleteByMarcheId(Long id);

    List<MarcheEmploye> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);


}
