package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.MaitreOuvrage;


@Repository
public interface MaitreOuvrageDao extends JpaRepository<MaitreOuvrage,Long> {

    MaitreOuvrage findByUsername(String username);



    MaitreOuvrage findByIce(String ice);

    int deleteByIce(String ice);



}
