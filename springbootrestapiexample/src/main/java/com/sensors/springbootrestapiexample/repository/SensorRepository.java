package com.sensors.springbootrestapiexample.repository;

import com.sensors.springbootrestapiexample.model.Sensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SensorRepository extends JpaRepository<Sensors,Long>{

}