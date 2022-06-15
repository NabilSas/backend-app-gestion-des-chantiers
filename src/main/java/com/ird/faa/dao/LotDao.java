package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Lot;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface LotDao extends JpaRepository<Lot,Long> {



    @Query("SELECT item FROM Lot item ORDER BY item.dateDelivrance ASC")
    List<Lot> findAll();


    List<Lot> findByPaiementLotReference(String reference);
    int deleteByPaiementLotReference(String reference);

    List<Lot> findByPaiementLotId(Long id);

    int deleteByPaiementLotId(Long id);

    List<Lot> findByEtatLotId(Long id);

    int deleteByEtatLotId(Long id);
    List<Lot> findByMarcheCode(Long code);
    int deleteByMarcheCode(Long code);

    List<Lot> findByMarcheId(Long id);

    int deleteByMarcheId(Long id);


}
