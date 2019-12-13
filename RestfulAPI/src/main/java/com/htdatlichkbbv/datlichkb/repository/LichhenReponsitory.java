package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LichhenReponsitory extends JpaRepository<Lichhen, String> {

    @Transactional
    @Modifying
    @Query(value = "update Lichhen lh set lh.mabn=?2, lh.trang_thai=?3, lh.ghi_chu=?4 where lh.ma_lich_hen = ?1",
            nativeQuery = true)
    int updateLichHenOld(
            String malichhen,
            String mabn,
            Short trangthai,
            String ghichu);
}
