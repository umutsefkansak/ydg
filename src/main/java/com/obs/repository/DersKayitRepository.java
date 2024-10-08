package com.obs.repository;

import com.obs.entities.DersKayit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DersKayitRepository extends JpaRepository<DersKayit,Integer> {



}
