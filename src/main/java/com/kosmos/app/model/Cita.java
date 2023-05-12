package com.kosmos.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cita")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCita;
	private LocalDateTime horario;
	private String nombrePaciente;

	@ManyToOne
	@JoinColumn(name = "idDoctor")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "idConsultorio")
	private Consultorio consultorio;

	public Cita() {

	}

	public Cita(int idCita, LocalDateTime horario, String nombrePaciente, Doctor doctor,
			Consultorio consultorio) {
		super();
		this.idCita = idCita;
		this.horario = horario;
		this.nombrePaciente = nombrePaciente;
		this.doctor = doctor;
		this.consultorio = consultorio;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

}
