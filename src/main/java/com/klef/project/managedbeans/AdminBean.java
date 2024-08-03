package com.klef.project.managedbeans;


import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;


import com.klef.project.services.AdminService;

@ManagedBean(name="adminbean",eager = true)
public class AdminBean 
{
	  @EJB(lookup="java:global/EMPGREProject/AdminServiceImpl!com.klef.project.services.AdminService")

	  AdminService adminService;


	  
	  public  long getempcount()
	  {
		  return adminService.empcount();
		  
	  }

	  public String updateRedirect(Integer id, String fullname, String email, String gender, String marital_status, String contactno, BigDecimal salary,String status, String role) {
		    // Construct the URL with all parameters
		    return "updateemprole.xhtml?faces-redirect=true&id=" + id +
		            "&fullname=" + fullname +
		            "&email=" + email +
		            "&gender=" + gender +
		            "&marital_status=" + marital_status +
		            "&contactno=" + contactno +
		            "&salary=" + salary.toString() +
		            "&status=" +status +
		            "&role=" + role;
		}
	  public String updatehrRedirect(Integer id, String fullname, String email, String gender, String marital_status, String contactno, BigDecimal salary,String status) {
		    // Construct the URL with all parameters
		    return "updateemp.xhtml?faces-redirect=true&id=" + id +
		            "&fullname=" + fullname +
		            "&email=" + email +
		            "&gender=" + gender +
		            "&marital_status=" + marital_status +
		            "&contactno=" + contactno +
		            "&salary=" + salary.toString() +
		            "&status=" +status;
		         
		}
	  
	  public String updategreRedirect(String ticket_id,String ticket_raiser, String responsiblePerson, String gre_status)
	  {
		  return "update_gstatus.xhtml?faces-redirect=true&ticket_id=" + ticket_id+
				  "&ticket_raiser=" + ticket_raiser +
		          "&responsible_person=" + responsiblePerson +
		          "&gre_status=" + gre_status ;
	  }
	  
	  public String updateempgreRedirect(String ticket_id,String ticket_raiser, String responsiblePerson, String gre_status)
	  {
		  return "update_gre_status.xhtml?faces-redirect=true&ticket_id=" + ticket_id+
				  "&ticket_raiser=" + ticket_raiser +
		          "&responsible_person=" + responsiblePerson +
		          "&gre_status=" + gre_status ;
	  }
	  public long gethrcount()
	  {
		  return adminService.hrcount();
	  }
	  
	  public long getemployeescount()
	  {
		  return adminService.emcount();
	  }
public long getadmincount()
{
	return adminService.acount();
}


}
