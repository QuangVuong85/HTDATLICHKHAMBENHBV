package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Chitietdichvu;
import com.htdatlichkbbv.datlichkb.entities.ChitietdichvuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChitietdichvuRepository extends JpaRepository<Chitietdichvu, ChitietdichvuId> {
}
