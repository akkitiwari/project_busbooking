package com.railway.irctc.Repository;

import com.railway.irctc.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}