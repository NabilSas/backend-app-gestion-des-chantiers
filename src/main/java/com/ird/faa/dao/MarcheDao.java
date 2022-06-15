package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Marche;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface MarcheDao extends JpaRepository<Marche,Long> {



    @Query("SELECT item FROM Marche item ORDER BY item.dateFin ASC")
    List<Marche> findAll();

    Marche findByCode(Long code);

    int deleteByCode(Long code);

    List<Marche> findByMaitreOuvrageIce(String ice);
    int deleteByMaitreOuvrageIce(String ice);

    List<Marche> findByMaitreOuvrageId(Long id);

    int deleteByMaitreOuvrageId(Long id);

    List<Marche> findByEtatMarcheId(Long id);

    int deleteByEtatMarcheId(Long id);


}
