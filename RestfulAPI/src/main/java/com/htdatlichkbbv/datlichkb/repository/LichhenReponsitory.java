package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import com.htdatlichkbbv.datlichkb.entities.context.ITKLichHenBSContext;
import com.htdatlichkbbv.datlichkb.entities.context.TKLichHenBSContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @Transactional
    @Modifying
    @Query(value = "select u.ma_lich_hen," +
            "u.thoi_gian," +
            "u.ngay_kham," +
            "u.ghi_chu," +
            "u.trang_thai," +
            "u.mabs," +
            "u.mabn from lichhen u where u.mabs = ?1",
            nativeQuery = true)
    List<Lichhen> findAllByMabs(String mabs);


    @Transactional
    @Modifying
    @Query(value = "SELECT bs.mabs as mabs, " +
            "bs.tenbs as tenbs, " +
            "lh.ngay_kham as ngaykham, " +
            "lh.trang_thai as trangthai, " +
            "count(lh.trang_thai) as soluong " +
            "from Bacsi bs " +
            "inner join Lichhen as lh " +
            "on bs.mabs = lh.mabs " +
            "group by bs.mabs, bs.tenbs, lh.ngay_kham, lh.trang_thai",
            nativeQuery = true)
    List<ITKLichHenBSContext> tkLichHenBS();

    @Transactional
    @Modifying
    @Query(value = "select lh.ma_lich_hen, lh.ghi_chu, lh.mabn, lh.mabs, lh.ngay_kham, lh.thoi_gian, lh.trang_thai from Lichhen lh where lh.mabs = ?1", nativeQuery = true)
    List<Lichhen> LichHenCuaBacSi(String mabs);

}
