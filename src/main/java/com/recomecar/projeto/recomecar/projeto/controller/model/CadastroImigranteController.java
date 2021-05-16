package com.recomecar.projeto.recomecar.projeto.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.recomecar.projeto.recomecar.projeto.repository.CandidateRepository;

@Controller
public class CadastroImigranteController {
	
	@Autowired
	private CandidateRepository repo;
	
	
	@GetMapping("/cadastro-imigrante")
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getName() != "anonymousUser") {
			Long id = repo.findByEmailCandidate(auth.getName()).getId();
			model.addAttribute("id", id.toString());
			model.addAttribute("auth", auth.getAuthorities());
		}
		return "cadastro-imigrante";
	}

}
