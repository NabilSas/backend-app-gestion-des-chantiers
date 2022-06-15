package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PaiementMarche;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface PaiementMarcheDao extends JpaRepository<PaiementMarche,Long> {



    @Query("SELECT item FROM PaiementMarche item ORDER BY item.datePaiement ASC")
    List<PaiementMarche> findAll();

    PaiementMarche findByReference(String reference);

    int deleteByReference(String reference);


    List<PaiementMarche> findByTypePaiementMarcheId(Long id);

    int deleteByTypePaiementMarcheId(Long id);
    List<PaiementMarche> findByMarcheCode(Long code);
    int deleteByMarcheCode(Long code);

    List<PaiementMarche> findByMarcheId(Long id);

    int deleteByMarcheId(Long id);


}
