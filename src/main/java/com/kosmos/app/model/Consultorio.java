package com.kosmos.app.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="consultorio")
public class Consultorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsultorio;
	private String numConsultorio;
	private int piso;

	@OneToMany(mappedBy = "consultorio")
	private List<Cita> citas = new ArrayList<>();

	public Consultorio() {

	}

	public Consultorio(int idConsultorio, String numConsultorio, int piso, List<Cita> citas) {
		super();
		this.idConsultorio = idConsultorio;
		this.numConsultorio = numConsultorio;
		this.piso = piso;
		this.citas = citas;
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getNumConsultorio() {
		return numConsultorio;
	}

	public void setNumConsultorio(String numConsultorio) {
		this.numConsultorio = numConsultorio;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}
