package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.CompteComptable;


@Repository
public interface CompteComptableDao extends JpaRepository<CompteComptable,Long> {






    List<CompteComptable> findBySousClasseComptableId(Long id);

    int deleteBySousClasseComptableId(Long id);


}
