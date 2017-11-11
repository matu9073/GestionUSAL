package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementaciones.CatedraDAOImpleHibernate;
import edu.usal.negocio.dao.interfaces.CatedraDAO;

public class CatedraDAOFactory {
	
	public static CatedraDAO getImplementacion(String implementacion) {
		if(implementacion.equals("Hibernate")) {
			return new CatedraDAOImpleHibernate();
		} else {
			throw new RuntimeException("Implementacion no encontrada para Profesor");
		}		
	}

}
