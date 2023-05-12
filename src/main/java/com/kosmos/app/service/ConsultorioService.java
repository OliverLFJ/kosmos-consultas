package com.kosmos.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmos.app.interfaceService.IConsultorioService;
import com.kosmos.app.interfaces.IConsultorio;
import com.kosmos.app.model.Consultorio;

@Service
public class ConsultorioService implements IConsultorioService {
	@Autowired
	private IConsultorio data;

	@Override
	public List<Consultorio> listConsultorio() {
		return (List<Consultorio>) data.findAll();
	}

	@Override
	public Optional<Consultorio> listConsultorioId(int id) {
		return data.findById(id);
	}

	@Override
	public int saveConsultorio(Consultorio c) {
		int res = 0;
		Consultorio consultorio = data.save(c);
		if (!consultorio.equals(null)) {
			res = 1;
		}
		return res;
	}
}
