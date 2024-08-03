package com.klef.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.project.models.Empgrevance;
import com.klef.project.models.Registration;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class HrServiceImpl implements HrService
{

	@Override
	public String addGrievance(Empgrevance gre) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(gre); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Grevance Submited Successfully";
	}

	@Override
	public List<Empgrevance> viewallgre() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select e from Empgrevance e");
		List<Empgrevance> grelist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return grelist;
	}
	
	@Override
	public List<Empgrevance> mygre() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Registration emp = (Registration) facesContext.getExternalContext().getSessionMap().get("emps");
            String fullname = emp.getFullname();

            Query qry = em.createQuery("SELECT e FROM Empgrevance e WHERE e.ticket_raiser = :fullname");
            qry.setParameter("fullname", fullname);
            
            List<Empgrevance> grelist = qry.getResultList();
            
            return grelist;
        } finally {
            em.close();
            emf.close();
        }
    }

	@Override
	public long grecount() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    Query qry = em.createQuery("SELECT COUNT(r) FROM Empgrevance r");
	    long count = (Long) qry.getSingleResult();
	    return count;
	}

	@Override
	public long gresolcount() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    Query qry = em.createQuery("SELECT COUNT(r) FROM Empgrevance r WHERE r.gre_status = :grestatus");
	    qry.setParameter("grestatus", "Solved");
	    long count = (Long) qry.getSingleResult();
	    return count;
	}

	@Override
	public long grepencount()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    Query qry = em.createQuery("SELECT COUNT(r) FROM Empgrevance r WHERE r.gre_status = :grestatus");
	    qry.setParameter("grestatus", "Pending");
	    long count = (Long) qry.getSingleResult();
	    return count;
		
	}

	@Override
	public String deletegre(int ticket_id) 
	{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	Empgrevance e = em.find(Empgrevance.class, ticket_id);
	em.remove(e);
	em.getTransaction().commit();
	
	em.close();
	emf.close();
	
	return "Grevance Deleted Successfully";
		
	}

	@Override
	public Empgrevance viewgrebyid(int ticket_id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
	   Empgrevance e = em.find(Empgrevance.class, ticket_id);
		
		if(e==null)
		{
			em.close();
			emf.close();
			return null;
		}
		
		em.close();
		emf.close();
		
		return e;
	}

	@Override
	public String updategrestatus(Empgrevance gre) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Empgrevance e = em.find(Empgrevance.class, gre.getTicket_id());
		
        e.setTicket_id(gre.getTicket_id());
        e.setTicket_raiser(gre.getTicket_raiser());
        e.setResponsiblePerson(gre.getResponsiblePerson());
        e.setGre_status(gre.getGre_status());

		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Grevance Status Updated Successfully";
	}
	
}