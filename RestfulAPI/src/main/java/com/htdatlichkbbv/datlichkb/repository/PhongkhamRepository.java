package com.htdatlichkbbv.datlichkb.repository;

import com.htdatlichkbbv.datlichkb.entities.Phongkham;
import com.htdatlichkbbv.datlichkb.entities.PhongkhamId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongkhamRepository extends JpaRepository<Phongkham, PhongkhamId> {
}
