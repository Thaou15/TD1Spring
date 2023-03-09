package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Etudiant;
import com.inti.model.Professeur;

@Service
public interface ProfesseurService {
	public List<Professeur> getProfesseurs();
	public void saveProfeseeur(Professeur p);
	public Professeur getProfesseur(int id);
	public void deleteProfesseur(int id);
	

}
