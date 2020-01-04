package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface BenhnhanRepository extends JpaRepository<Benhnhan, String> {
    Benhnhan findBenhnhanByMatk_(String matk);
}
