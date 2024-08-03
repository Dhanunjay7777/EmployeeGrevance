package com.klef.project.managedbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.klef.project.models.Empgrevance;
import com.klef.project.models.Registration;
import com.klef.project.services.HrService;

@ManagedBean(name = "hr", eager = true)
public class HrBean {
    public String getGre_status() {
		return gre_status;
	}

	public void setGre_status(String gre_status) {
		this.gre_status = gre_status;
	}
	@EJB(lookup = "java:global/EMPGREProject/HrServiceImpl!com.klef.project.services.HrService")
    HrService service;
    
    private int ticket_id;
    private String ticket_raiser;
    private String email;
    private String contact;
    private String grievanceType;
    private String grievanceDetails;
    private String incidentLocation;
    private Date dateofincident;
    private String responsiblePerson;
    private String gre_status;
    private List<Empgrevance> grelist;
    private List<Empgrevance> mygre;

    public List<Empgrevance> getGrelist() {
      return service.viewallgre();
    }
    
    public void setMyGrelist(List<Empgrevance> grelist) {
        this.grelist = grelist;
      }
    public List<Empgrevance> getMyGrelist() {
        return service.mygre();
      }
    
    

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTicket_raiser() {
        return ticket_raiser;
    }

    public void setTicket_raiser(String ticket_raiser) {
        this.ticket_raiser = ticket_raiser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGrievanceType() {
        return grievanceType;
    }

    public void setGrievanceType(String grievanceType) {
        this.grievanceType = grievanceType;
    }

    public String getGrievanceDetails() {
        return grievanceDetails;
    }

    public void setGrievanceDetails(String grievanceDetails) {
        this.grievanceDetails = grievanceDetails;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }

    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    public Date getDateofincident() {
        return dateofincident;
    }

    public void setDateofincident(Date dateofincident) {
        this.dateofincident = dateofincident;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    // Method to add grievance
    public String addGrievance(String fullname) {
        Empgrevance grievance = new Empgrevance();
        
        // Generate random ticket id
        int ticket_id = (int) (Math.random() * 9000) + 10000;
        grievance.setTicket_id(ticket_id);
        grievance.setTicket_raiser(fullname); // Assuming fullname is accessible here
        grievance.setEmail(email);
        grievance.setContact(contact);
        grievance.setGrievanceType(grievanceType);
        grievance.setGrievanceDetails(grievanceDetails);
        grievance.setIncidentLocation(incidentLocation);
        grievance.setDateofincident(dateofincident);
        grievance.setResponsiblePerson(responsiblePerson);
        grievance.setGre_status("Submitted");
        
        String result = service.addGrievance(grievance); // Assuming service is injected and handles grievance addition
        
        // Redirect to gresuccess.xhtml with ticket_id parameter
        return "gresuccess.xhtml?faces-redirect=true&ticket_id=" + ticket_id;
    }

    public  long getgrecount()
	  {
		  return service.grecount();
		  
	  }
    
    public  long getgresolcount()
	  {
		  return service.gresolcount();
		  
	  }
    public  long getgrepencount()
	  {
		  return service.grepencount();
		  
	  }
    public String deletegre(int ticket_id)
	  {
		  service.deletegre(ticket_id);
		  
		  return "viewgre.jsf";
	  }
    
    public String updategrestatus()
    {
    Empgrevance e = service.viewgrebyid(ticket_id);
	  if(e!=null)
	  {
		  //System.out.println("ID Found");
		  Empgrevance gre = new Empgrevance();
		  gre.setTicket_id(ticket_id);
		  gre.setEmail(email);
		  gre.setTicket_raiser(ticket_raiser);
		  gre.setResponsiblePerson(responsiblePerson);
		  gre.setGre_status(gre_status);

		  
		  service.updategrestatus(gre);
		  
		 return "updatesuccess.jsf";
	  }
	  else
	  {
	 return "updatefail.jsf";

	  }
    }
}
