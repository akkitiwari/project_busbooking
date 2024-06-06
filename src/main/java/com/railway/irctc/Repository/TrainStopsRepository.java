package com.railway.irctc.Repository;

import com.railway.irctc.entity.TrainStops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TrainStopsRepository extends JpaRepository<TrainStops, Long> {


    @Query("SELECT t.trainName " +
            "FROM TrainStop ts1 " +
            "JOIN TrainStop ts2 ON ts1.train.id = ts2.train.id " +
            "JOIN Train t ON ts1.train.id = t.id " +
            "JOIN ts1.station s1 " +
            "JOIN ts2.station s2 " +
            "WHERE s1.stationName = :fromLocation " +
            "AND s2.stationName = :toLocation " +
            "AND ts1.departureDate = :departureDate " +
            "AND ts2.stopOrder > ts1.stopOrder")
    List<String> findTrainNamesByLocationsAndDepartureDate(@Param("fromLocation")String fromLocation,
                                                           @Param("toLocation")String toLocation,
                                                           @Param("departureDate")LocalDate departureDate);
}