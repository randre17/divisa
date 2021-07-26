package com.moneda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moneda.model.MonedaEntity;

@Repository
public interface MonedaRepository extends JpaRepository<MonedaEntity, Long> {

}
