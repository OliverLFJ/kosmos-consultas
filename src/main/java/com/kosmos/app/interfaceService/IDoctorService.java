package com.kosmos.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.kosmos.app.model.Doctor;

public interface IDoctorService {
	public List<Doctor> listDoctor();

	public Optional<Doctor> listDoctorId(int id);

	public int saveDoctor(Doctor p);

}
