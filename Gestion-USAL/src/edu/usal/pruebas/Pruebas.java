package edu.usal.pruebas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.usal.negocio.dto.Catedra;
import edu.usal.negocio.dto.Profesor;
import edu.usal.util.HibernateUtil;

public class Pruebas {

	public static void main(String[] args) {
		
		SessionFactory sessionF = HibernateUtil.getSessionFactory();
		Session session = sessionF.getCurrentSession();
		Profesor profesor = new Profesor(3, "Matias", "Macrino", "000000", "1111111", "San Martin");
		profesor.getCatedra().add(new Catedra(4, "Programacion", 3, "18:30-21:30", "Miercoles"));
		profesor.getCatedra().add(new Catedra(0, "Programacion Avanzada", 3, "18:30-21:30", "Jueves"));
		session.beginTransaction();
		//session.saveOrUpdate(profesor);
		session.update(profesor);
		session.getTransaction().commit();

	}

}
