package com.sensors.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.springbootrestapiexample.dao.SensorDAO;
import com.sensors.springbootrestapiexample.model.Sensors;

//from this class all the entered url through browser or postman will be added

@RestController
@RequestMapping("/firealarm")
@CrossOrigin("*")
public class SensorController {
	
	@Autowired
	SensorDAO sensorDAO;
	
	/*to save sensor details to the db*/
	@PostMapping("/sensors")
	public Sensors createSensor(@Valid @RequestBody Sensors sensor) {
		return sensorDAO.save(sensor);
	}
	
	/*get all sensor details*/
	@GetMapping("/sensors")
	public List<Sensors> getAllSensorDetails(){
		return sensorDAO.findAll();
	}
	
	/*get sensor details by particular id*/
	@GetMapping("/sensors/{id}")
	public ResponseEntity<Sensors> getSensorById(@PathVariable(value="id") Long sensorid){
		Sensors sensor = sensorDAO.findOne(sensorid);
		if(sensor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(sensor);
	}
	
	/*Update sensor details by id*/
	@PutMapping("/sensors/{id}")
	public ResponseEntity<Sensors> updateEmployee(@PathVariable(value="id") Long sensorid,@Valid @RequestBody Sensors sensorDetails){
		Sensors sensor = sensorDAO.findOne(sensorid);
		if(sensor == null) {
			return ResponseEntity.notFound().build();
		}
		sensor.setSensorname(sensorDetails.getSensorname());
		sensor.setFloor(sensorDetails.getFloor());
		sensor.setRoom(sensorDetails.getRoom());
		sensor.setCo2(sensorDetails.getCo2());
		sensor.setSmoke(sensorDetails.getSmoke());
		sensor.setStatus(sensorDetails.getStatus());
	
		
		Sensors updateSensor=sensorDAO.save(sensor);
		return ResponseEntity.ok().body(updateSensor);
	}
	
	/*Delete an employee*/
	@DeleteMapping("sensors/{id}")
	public ResponseEntity<Sensors> deleteEmployee(@PathVariable(value="id") Long sensorid){
		Sensors sensor = sensorDAO.findOne(sensorid);
		if(sensor == null) {
			return ResponseEntity.notFound().build();
		}
		sensorDAO.delete(sensor);
		
		return ResponseEntity.ok().build();
	}
	
	
}
