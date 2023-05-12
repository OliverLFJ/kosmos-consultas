package com.kosmos.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosmos.app.model.Consultorio;
import com.kosmos.app.service.ConsultorioService;

@Controller
@RequestMapping
public class ConsultorioController {
	@Autowired
	private ConsultorioService consultorioservice;

	@GetMapping("/list-consultorio")
	public String list(Model model) {
		List<Consultorio> consultorio = consultorioservice.listConsultorio();
		model.addAttribute("consultorio", consultorio);
		return "consultorio";
	}

	@GetMapping("/new-consultorio")
	public String add(Model model) {
		model.addAttribute("consultorio", new Consultorio());
		return "agregarconsultorio";
	}

	@PostMapping("/save-consultorio")
	public String save(@Valid Consultorio c, Model model) {
		consultorioservice.saveConsultorio(c);
		return "redirect:/list-consultorio";
	}
}
