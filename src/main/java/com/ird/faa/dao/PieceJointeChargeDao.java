package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointeCharge;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface PieceJointeChargeDao extends JpaRepository<PieceJointeCharge,Long> {



    @Query("SELECT item FROM PieceJointeCharge item ORDER BY item.datePaiement ASC")
    List<PieceJointeCharge> findAll();



    List<PieceJointeCharge> findByChargeId(Long id);

    int deleteByChargeId(Long id);


}
