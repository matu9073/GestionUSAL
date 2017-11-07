package edu.usal.negocio.dao.implementaciones;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import edu.usal.negocio.dao.interfaces.GenericDAO;
import edu.usal.util.HibernateUtil;

public class GenericDAOImpleHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {
	
	SessionFactory sessionFactory;
	
	public GenericDAOImpleHibernate() {
		this.sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	@Override
	public T create() {
		try {
		     return getEntityClass().newInstance();
		 } catch (InstantiationException | IllegalAccessException ex) {
		     throw new RuntimeException(ex);
		 } catch (RuntimeException ex) {
		     throw ex;
		 } catch (Exception ex) {
		     throw new RuntimeException(ex);
		 }
	}

	@Override
	public void saveOrUpdate(T entity) {
		Session session = sessionFactory.getCurrentSession();
		 try {
		     session.beginTransaction();
		     session.saveOrUpdate(entity);
		     session.getTransaction().commit();
		 } catch (org.hibernate.exception.ConstraintViolationException cve) {
		     try {
		         if (session.getTransaction().isActive()) {
		             session.getTransaction().rollback();
		         }
		     } catch (Exception exc) {
		         System.out.println("Falló al hacer un rollback");
		     }
		     //throw new BussinessException(cve);
		 } catch (RuntimeException ex) {
		     try {
		         if (session.getTransaction().isActive()) {
		             session.getTransaction().rollback();
		         }
		     } catch (Exception exc) {
		    	 System.out.println("Falló al hacer un rollback");
		     }
		     throw ex;
		 } catch (Exception ex) {
		     try {
		         if (session.getTransaction().isActive()) {
		             session.getTransaction().rollback();
		         }
		     } catch (Exception exc) {
		    	 System.out.println("Falló al hacer un rollback");
		     }
		     throw new RuntimeException(ex);
		 }
		
	}

	@Override
	public T get(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		try {
		    session.beginTransaction();
		    T entity = (T) session.get(getEntityClass(), id);
		    session.getTransaction().commit();
		    return entity;
		} catch (org.hibernate.exception.ConstraintViolationException cve) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		    	System.out.println("Falló al hacer un rollback");
		    }
		    //throw new BussinessException(cve);
		} catch (RuntimeException ex) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		    	System.out.println("Falló al hacer un rollback");
		    }
		    throw ex;
		} catch (Exception ex) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		    	System.out.println("Falló al hacer un rollback");
		    }
		    throw new RuntimeException(ex);
		}
		return null;
	}

	@Override
	public void delete(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		try {
		    session.beginTransaction();
		    T entity = (T) session.get(getEntityClass(), id);
		    if (entity == null) {
		        throw new RuntimeErrorException(null, "Los datos a borrar ya no existen");
		    }
		    session.delete(entity);
		    session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException cve) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		    	System.out.println("Falló al hacer un rollback");
		    }
		    //throw new BussinessException(cve);
		} catch (RuntimeException ex) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		    	System.out.println("Falló al hacer un rollback");
		    }
		    throw ex;
		} catch (Exception ex) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		        System.out.println("Falló al hacer un rollback");
		    }
		    throw new RuntimeException(ex);
		}		
	}

	@Override
	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
		    Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
		    List<T> entities = query.list();
		    return entities;
		} catch (org.hibernate.exception.ConstraintViolationException cve) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		    	System.out.println("Falló al hacer un rollback");
		    }
		    //throw new BussinessException(cve);
		} catch (RuntimeException ex) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		    	System.out.println("Falló al hacer un rollback");
		    }
		    throw ex;
		} catch (Exception ex) {
		    try {
		        if (session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		    } catch (Exception exc) {
		    	System.out.println("Falló al hacer un rollback");
		    }
		    throw new RuntimeException(ex);
		}
		return null;
	}	
	
	private Class<T> getEntityClass() {
	     return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
