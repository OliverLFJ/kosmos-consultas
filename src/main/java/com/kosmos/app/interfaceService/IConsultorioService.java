package com.kosmos.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.kosmos.app.model.Consultorio;

public interface IConsultorioService {
	public List<Consultorio> listConsultorio();

	public Optional<Consultorio> listConsultorioId(int id);

	public int saveConsultorio(Consultorio c);
}
