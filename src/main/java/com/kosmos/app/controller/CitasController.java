package com.kosmos.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosmos.app.model.Cita;
import com.kosmos.app.model.Consultorio;
import com.kosmos.app.model.Doctor;
import com.kosmos.app.service.CitaService;
import com.kosmos.app.service.ConsultorioService;
import com.kosmos.app.service.DoctorService;

@Controller
@RequestMapping
public class CitasController {

	@Autowired
	private CitaService servicecita;
	@Autowired
	private DoctorService servicedoctor;
	@Autowired
	private ConsultorioService serviceconsultorio;

	@GetMapping("/list-cita")
	public String list(Model model) {
		List<Cita> cita = servicecita.listCita();
		model.addAttribute("cita", cita);
		return "index";
	}

	@GetMapping("/new-cita")
	public String add(Model model) {
		List<Doctor> doctor = servicedoctor.listDoctor();
		List<Consultorio> consultorio = serviceconsultorio.listConsultorio();
		model.addAttribute("doctor", doctor);
		model.addAttribute("consultorio", consultorio);

		model.addAttribute("cita", new Cita());
		return "agregarcita";
	}

	@PostMapping("/save-cita")
	public String save(@Valid Cita c, Model model) {

		Optional<Doctor> optionalDoctor = servicedoctor.listDoctorId(c.getDoctor().getIdDoctor());
		Doctor doctor = optionalDoctor.get();
		Optional<Consultorio> optionalConsult = serviceconsultorio
				.listConsultorioId(c.getConsultorio().getIdConsultorio());
		Consultorio consultorio = optionalConsult.get();

		c.setDoctor(doctor);
		c.setConsultorio(consultorio);
		
		
		servicecita.save(c);
		return "redirect:/list-cita";
	}

	@GetMapping("/edit-cita/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Cita> cita = servicecita.listCitaId(id);
		model.addAttribute("cita", cita);
		return "agregarcita";
	}

	@GetMapping("/delete-cita/{id}")
	public String delete(@PathVariable int id, Model model) {
		servicecita.deleteCita(id);
		return "redirect:/list-cita";
	}
}
