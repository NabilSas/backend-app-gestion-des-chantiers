package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.SousClasseComptable;


@Repository
public interface SousClasseComptableDao extends JpaRepository<SousClasseComptable,Long> {






    List<SousClasseComptable> findByClasseComptableId(Long id);

    int deleteByClasseComptableId(Long id);


}
