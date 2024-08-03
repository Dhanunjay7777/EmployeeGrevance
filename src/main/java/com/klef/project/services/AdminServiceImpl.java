package com.klef.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.project.models.Registration;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceImpl implements AdminService
{

	@Override
	public long empcount()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    Query qry = em.createQuery("select count(*) from Registration");
	    List list = qry.getResultList();
	    long count =  (long) list.get(0);
	    return count;
	}

	@Override
	public long hrcount() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    Query qry = em.createQuery("SELECT COUNT(r) FROM Registration r WHERE r.role = :role");
	    qry.setParameter("role", "HR");
	    long count = (Long) qry.getSingleResult();
	    return count;

	}

	@Override
	public long emcount() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    Query qry = em.createQuery("SELECT COUNT(r) FROM Registration r WHERE r.role = :role");
	    qry.setParameter("role", "employee");
	    long count = (Long) qry.getSingleResult();
	    return count;
	}

	@Override
	public long acount() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    Query qry = em.createQuery("SELECT COUNT(r) FROM Registration r WHERE r.role = :role");
	    qry.setParameter("role", "admin");
	    long count = (Long) qry.getSingleResult();
	    return count;
	}

      
}
