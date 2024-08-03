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
public class EmployeeServiceImpl implements EmployeeService
{
	@Override
	public String addemployee(Registration employee) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(employee); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Registered Successfully";
	}

	@Override
	public Registration checkemplogin(String email, String password) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		// e is an alias of Employee Class
		Query qry = em.createQuery("select e from Registration e where e.email=? and e.password=?");
		
		qry.setParameter(1, email);
		qry.setParameter(2, password);
		
		Registration emp =null;
		
		if(qry.getResultList().size()>0)
		{
			emp = (Registration) qry.getSingleResult();
		}
		em.close();
		emf.close();
		
		return emp;
	}

	@Override
	public List<Registration> viewallemps() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select e from Registration e");
		// e is an alias of Employee Class
		List<Registration> emplist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return emplist;
	}

	@Override
	public String deleteemployee(int id) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Registration e = em.find(Registration.class, id);
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Deleted Successfully";
	}

	@Override
	public Registration viewempbyid(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
	Registration e = em.find(Registration.class, id);
		
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
	public String updateemprole(Registration employee) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Registration e = em.find(Registration.class, employee.getId());
		
		
		e.setId(employee.getId());
	    e.setFullname(employee.getFullname());
	    e.setEmail(employee.getEmail());
	    e.setGender(employee.getGender());
	    e.setMarital_status(employee.getMarital_status());
	    e.setContactno(employee.getContactno());
	    e.setSalary(employee.getSalary());
	    e.setStatus(employee.getStatus());
	    e.setRole(employee.getRole());

		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Employee Updated Successfully";	
	}

	@Override
	public String updatepwd(Registration employee) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Registration e = em.find(Registration.class, employee.getId());
		
		
        e.setPassword(employee.getPassword());

		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Password Updated Successfully";	
	}

	@Override
	public List<Registration> viewallhremps() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        
        String check = "employee";
        
        Query qry = em.createQuery("SELECT e FROM Registration e WHERE e.role = :role");
        qry.setParameter("role", check);
        
        List<Registration> emphrlist = qry.getResultList();
        
        em.close();
        emf.close();
        
        return emphrlist;
    }

	@Override
	public String updateemp(Registration employee) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Registration e = em.find(Registration.class, employee.getId());
		
		
		e.setId(employee.getId());
	    e.setFullname(employee.getFullname());
	    e.setEmail(employee.getEmail());
	    e.setGender(employee.getGender());
	    e.setMarital_status(employee.getMarital_status());
	    e.setContactno(employee.getContactno());
	    e.setSalary(employee.getSalary());
	    e.setStatus(employee.getStatus());

		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Employee Updated Successfully";	
	}

	
	}
	

