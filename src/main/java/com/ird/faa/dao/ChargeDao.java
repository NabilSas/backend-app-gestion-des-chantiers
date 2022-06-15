package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Charge;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ChargeDao extends JpaRepository<Charge,Long> {



    @Query("SELECT item FROM Charge item ORDER BY item.dateCharge ASC")
    List<Charge> findAll();



    List<Charge> findByCompteComptableId(Long id);

    int deleteByCompteComptableId(Long id);

    List<Charge> findByEtatChargeId(Long id);

    int deleteByEtatChargeId(Long id);

    List<Charge> findByCategorieChargeId(Long id);

    int deleteByCategorieChargeId(Long id);
    List<Charge> findByProduitReference(String reference);
    int deleteByProduitReference(String reference);

    List<Charge> findByProduitId(Long id);

    int deleteByProduitId(Long id);


}
