package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AlumnoDao;
import com.example.demo.entity.Alumno;
import com.example.demo.service.AlumnoService;
@Service
public class AlumnoServiceImpl implements AlumnoService {
	@Autowired
	private AlumnoDao alumnoDao;

	@Override
	public Alumno create(Alumno c) {
		// TODO Auto-generated method stub
		return alumnoDao.create(c);
	}

	@Override
	public Alumno update(Alumno c) {
		// TODO Auto-generated method stub
		return alumnoDao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoDao.delete(id);
	}

	@Override
	public Optional<Alumno> read(Long id) {
		// TODO Auto-generated method stub
		return alumnoDao.read(id);
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return alumnoDao.readAll();
	}

}
