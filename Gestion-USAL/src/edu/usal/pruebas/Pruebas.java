package edu.usal.pruebas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.usal.negocio.dao.factory.CatedraDAOFactory;
import edu.usal.negocio.dao.factory.ProfesorDAOFactory;
import edu.usal.negocio.dao.interfaces.CatedraDAO;
import edu.usal.negocio.dao.interfaces.ProfesorDAO;
import edu.usal.negocio.dto.Catedra;
import edu.usal.negocio.dto.Profesor;
import edu.usal.util.HibernateUtil;

public class Pruebas {

	public static void main(String[] args) {
		
		ProfesorDAO dao = ProfesorDAOFactory.getImplementacion("Hibernate");
		CatedraDAO dao_catedra = CatedraDAOFactory.getImplementacion("Hibernate");
		
		/*SessionFactory sessionF = HibernateUtil.getSessionFactory();
		Session session = sessionF.getCurrentSession();*/
		Profesor profesor = new Profesor(2, "Matias", "Macrino", "000000", "1111111", "San Martin");
		//profesor.getCatedra().add(new Catedra(4, "Programacion Avanzada ++", 3, "18:30-21:30", "Martes"));
		//profesor.getCatedra().add(new Catedra(0, "Programacion", 3, "18:30-21:30", "Miercoles"));
		//profesor.getCatedra().add(new Catedra(0, "Programacion Avanzada", 3, "18:30-21:30", "Jueves"));
		/*session.beginTransaction();
		session.saveOrUpdate(profesor);
		session.update(profesor);
		session.getTransaction().commit();*/
		dao.update(profesor);
		//Catedra ca = new Catedra(0, "Programacion Avanzada ++", 3, "18:30-21:30", "Martes");
		//dao_catedra.save(ca);
	}

}
