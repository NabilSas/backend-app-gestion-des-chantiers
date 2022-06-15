package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Employe;


@Repository
public interface EmployeDao extends JpaRepository<Employe,Long> {





    List<Employe> findByCategorieEmployeCode(String code);
    int deleteByCategorieEmployeCode(String code);

    List<Employe> findByCategorieEmployeId(Long id);

    int deleteByCategorieEmployeId(Long id);


}
