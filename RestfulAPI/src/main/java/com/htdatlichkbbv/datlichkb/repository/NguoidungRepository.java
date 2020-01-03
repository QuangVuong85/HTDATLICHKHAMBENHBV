package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Nguoidung;
import com.htdatlichkbbv.datlichkb.entities.context.LoginContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBNContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBSContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface NguoidungRepository extends JpaRepository<Nguoidung, String> {

    @Transactional
    @Modifying
    @Query(value = "select a.matk from Nguoidung a where a.tentk=?1 and a.mat_khau=?2",
            nativeQuery = true)
    public List<String> getByNamePasswordTK(String tentk, String matkhau);


    @Transactional
    @Modifying
    @Query(value = "CALL getBenhnhanBacsiByMatk(?1, 'N3')",
            nativeQuery = true)
    public List<LoginResBSContext> getInfoBacSi(String matk);

    @Transactional
    @Modifying
    @Query(value = "CALL getBenhnhanBacsiByMatk(?1, 'N4')",
            nativeQuery = true)
    public List<LoginResBNContext> getInfoBenhNhan(String matk);
}
