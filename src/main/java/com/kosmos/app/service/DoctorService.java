package com.kosmos.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmos.app.interfaceService.IDoctorService;
import com.kosmos.app.interfaces.IDoctor;
import com.kosmos.app.model.Doctor;

@Service
public class DoctorService implements IDoctorService {
	@Autowired
	private IDoctor data;

	@Override
	public List<Doctor> listDoctor() {
		return (List<Doctor>) data.findAll();
	}

	@Override
	public Optional<Doctor> listDoctorId(int id) {
		return data.findById(id);
	}

	@Override
	public int saveDoctor(Doctor d) {
		int res = 0;
		Doctor doctor = data.save(d);
		if (!doctor.equals(null)) {
			res = 1;
		}
		return res;
	}
}
