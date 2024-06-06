package com.railway.irctc.Repository;

import com.railway.irctc.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainRepository extends JpaRepository<Train, Long> {

}
