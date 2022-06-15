package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatMarche;


@Repository
public interface EtatMarcheDao extends JpaRepository<EtatMarche,Long> {







}
