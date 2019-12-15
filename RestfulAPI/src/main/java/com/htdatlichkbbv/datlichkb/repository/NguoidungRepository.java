package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Nguoidung;
import com.htdatlichkbbv.datlichkb.entities.context.LoginContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface NguoidungRepository extends JpaRepository<Nguoidung, String> {

    @Transactional
    @Modifying
    @Query(value = "select a.matk from Nguoidung a where a.tentk=?1 and a.mat_khau=?2",
            nativeQuery = true)
    List<String> findByNamePasswordTK(String tentk, String matkhau);
}
