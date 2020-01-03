package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Dichvu;
import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DichvuRepository extends JpaRepository<Dichvu, String> {
    @Transactional
    @Modifying
    @Query(value = "SELECT dv.madv, dv.don_gia, dv.mabs, dv.tendv FROM dichvu dv WHERE mabs = ?1", nativeQuery = true)
    List<Dichvu> DichVuCuaBacSi(String mabs);
}
