package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PaiementLot;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface PaiementLotDao extends JpaRepository<PaiementLot,Long> {



    @Query("SELECT item FROM PaiementLot item ORDER BY item.datePaiement ASC")
    List<PaiementLot> findAll();

    PaiementLot findByReference(String reference);

    int deleteByReference(String reference);


    List<PaiementLot> findByTypePaiementLotId(Long id);

    int deleteByTypePaiementLotId(Long id);

    List<PaiementLot> findByLotId(Long id);

    int deleteByLotId(Long id);


}
