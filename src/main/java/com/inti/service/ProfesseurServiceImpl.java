package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;


import com.inti.model.Professeur;
import com.inti.util.HibernateUtil;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {
	
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Professeur> getProfesseurs() {
		List<Professeur> listeProfesseurs = null;
		try
		{
			session.beginTransaction();
			
		listeProfesseurs = session.createNativeQuery("select * from professeur", Professeur.class).list();
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return listeProfesseurs;
	}


	@Override
	public void saveProfeseeur(Professeur p) {
		
			try
			{
				session.beginTransaction();
				
				session.save(p);
				
				session.getTransaction().commit();
			}
			catch (Exception ex) {
				ex.printStackTrace();
				session.getTransaction().rollback();
			}
			
		
	}

	@Override
	public Professeur getProfesseur(int id) {
		Professeur p = null;
		try
		{
			session.beginTransaction();
			
			p = session.get(Professeur.class, id);
			
			session.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	}

	@Override
	public void deleteProfesseur(int id) {
		try
		{
			session.beginTransaction();
			
			session.delete(session.get(Professeur.class, id));;
			
			session.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
