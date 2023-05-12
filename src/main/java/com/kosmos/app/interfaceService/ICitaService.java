package com.kosmos.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.kosmos.app.model.Cita;

public interface ICitaService {
	public List<Cita> listCita();

	public Optional<Cita> listCitaId(int id);

	public int save(Cita c);

	public void deleteCita(int id);
}
