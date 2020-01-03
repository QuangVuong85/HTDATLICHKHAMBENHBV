package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BacsiRepository extends JpaRepository<Bacsi, String> {

    @Transactional
    @Modifying
    @Query(value = "call getDanhSachBacSiTheoKhoa(?1);",
            nativeQuery = true)
    public List<Bacsi> getBSKhoa(String makhoa);

    Bacsi findBacsiByMatk_(String matk);
}
