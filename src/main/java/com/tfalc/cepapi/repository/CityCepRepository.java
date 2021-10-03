package com.tfalc.cepapi.repository;

import com.tfalc.cepapi.service.CityCep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityCepRepository extends JpaRepository<CityCep, Long> {

}
