package com.sensors.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.springbootrestapiexample.model.Sensors;
import com.sensors.springbootrestapiexample.repository.SensorRepository;



//Data Access Object -> DAO

@Service
public class SensorDAO {
	
	@Autowired
	SensorRepository sensorRepository;
	
	/*to save a sensor*/
	
	public Sensors save(Sensors sensor) {
		return sensorRepository.save(sensor);//pre-defined method -> save
	}
	
	/*search all sensor*/
	
	public List<Sensors> findAll(){
		return sensorRepository.findAll();
	}
	
	/*update a sensor*/
	
	public Sensors findOne(Long sensorid) {
		return sensorRepository.findOne(sensorid);
	}
	
	/*delete a sensor by object*/
	
	public void delete(Sensors sensor) {
		sensorRepository.delete(sensor);
	}
}
