package com.kosmos.app.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosmos.app.model.Doctor;
import com.kosmos.app.service.DoctorService;

@Controller
@RequestMapping
public class DoctorController {

	@Autowired
	private DoctorService doctorservice;

	@GetMapping("/list-doctor")
	public String list(Model model) {
		List<Doctor> doctor = doctorservice.listDoctor();
		model.addAttribute("doctor", doctor);
		return "doctor";
	}

	@GetMapping("/new-doctor")
	public String add(Model model) {
		model.addAttribute("doctor", new Doctor());
		return "agregardoctor";
	}

	@PostMapping("/save-doctor")
	public String save(@Valid Doctor d, Model model) {
		doctorservice.saveDoctor(d);
		return "redirect:/list-doctor";
	}

}
