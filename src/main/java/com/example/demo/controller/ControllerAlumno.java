package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.entity.Alumno;
import com.example.demo.service.AlumnoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/alumno")
public class ControllerAlumno {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> readAll(){
		try {
			List<Alumno> Alumnos = alumnoService.readAll();
			if (Alumnos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
			}
			return new ResponseEntity<>(Alumnos, HttpStatus.OK);			

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Alumno> crear(@Valid @RequestBody Alumno c) {
		//TODO: process POST request
		try {
			Alumno alumno = alumnoService.create(c);
			return new ResponseEntity<>(alumno, HttpStatus.CREATED);			

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumnoId(@PathVariable("id") Long id) {
		try {
			Alumno alumno = alumnoService.read(id).get();
			
			return new ResponseEntity<>(alumno, HttpStatus.CREATED);			

			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);			

		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Alumno> delAlumno(@PathVariable("id") Long id){
		try {
			alumnoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAlumno(@PathVariable("id") Long id, @RequestBody Alumno c) {
		//TODO: process PUT request
		Optional<Alumno> alumno = alumnoService.read(id);
		
		if(!alumno.isEmpty()) {
			return new ResponseEntity<>(alumnoService.update(c), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		
}
}