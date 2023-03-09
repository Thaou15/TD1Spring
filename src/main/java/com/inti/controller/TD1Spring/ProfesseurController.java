package com.inti.controller.TD1Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Professeur;
import com.inti.service.ProfesseurService;


@Controller
@RequestMapping("professeur")
public class ProfesseurController {
	
	@Autowired
	ProfesseurService ps;
	
	@GetMapping("save")
	public String enregistrerProfesseur(@RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom, @RequestParam("salaire") String salaire, Model m)
	{
		Professeur p = new Professeur(nom, prenom, salaire);

		ps.saveProfeseeur(p);
		
		m.addAttribute("p", p);
		return "enregistrerP";
	}
	

	@GetMapping("listeP")
	public String getAllProfesseur(Model m)
	{
		
	    m.addAttribute("listeP", ps.getProfesseurs());
	
	
	return "listeProfesseur";
	
	}
	@GetMapping("P")
	public String getOneProfesseur(@RequestParam("id") int id, Model m )
	{
		
	   m.addAttribute("p" , ps.getProfesseur(id));
	
	
	return "professeur";
	
	}
	@GetMapping("supprimer")
	public String deleteProfesseur(@RequestParam("id") int id, Model m )
	{
		
	   ps.deleteProfesseur(id);;
	
	
	return "deleteP";
	
	}
	

}
