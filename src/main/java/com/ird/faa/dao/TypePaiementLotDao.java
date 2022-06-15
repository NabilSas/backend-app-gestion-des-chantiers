package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypePaiementLot;


@Repository
public interface TypePaiementLotDao extends JpaRepository<TypePaiementLot,Long> {







}
