package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementaciones.ProfesorDAOImpleHibernate;
import edu.usal.negocio.dao.interfaces.ProfesorDAO;

public class ProfesorDAOFactory {
	
	public static ProfesorDAO getImplementacion(String implementacion) {
		if(implementacion.equals("Hibernate")) {
			return new ProfesorDAOImpleHibernate();
		} else {
			throw new RuntimeException("Implementacion no encontrada para Profesor");
		}		
	}

}
