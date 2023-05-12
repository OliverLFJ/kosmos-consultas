package com.kosmos.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmos.app.interfaceService.ICitaService;
import com.kosmos.app.interfaces.ICita;
import com.kosmos.app.model.Cita;

@Service
public class CitaService implements ICitaService {
	@Autowired
	private ICita data;

	@Override
	public List<Cita> listCita() {
		return (List<Cita>) data.findAll();
	}

	@Override
	public Optional<Cita> listCitaId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Cita c) {
		int res = 0;
		Cita cita = data.save(c);
		if (!cita.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void deleteCita(int id) {
		data.deleteById(id);
	}
}
