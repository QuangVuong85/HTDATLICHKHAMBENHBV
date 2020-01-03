package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Khoa;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBNContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, String> {


}
