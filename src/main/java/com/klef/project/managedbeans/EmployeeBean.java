package com.klef.project.managedbeans;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.project.models.Registration;
import com.klef.project.services.EmployeeService;

@ManagedBean(name = "emp", eager = true)
public class EmployeeBean {

    @EJB(lookup = "java:global/EMPGREProject/EmployeeServiceImpl!com.klef.project.services.EmployeeService")
    EmployeeService service;
    
    private int id;
    private String fullname;
    private String email;
    private String password;
    private Date dob;
    private String gender;
    private String marital_status;
    private String blood_group;
    private String contactno;
    private String address;
    private String position_title;
    private String department;
    private Date date_of_joining;
    private BigDecimal salary;
    private int years_of_experience;
    private String emergency_contact_name;
    private String emergency_contact_number;
    private String national_id_number;
    private String bank_account_details;
    private String previous_employer;
    private String education_qualification;
    private String skills;
    private String employee_type;
    private String status;
    private String role;
    private String newpassword;
    private List<Registration> emplist;
    private List<Registration> emphrlist;

    private String recipientEmail;
    private String subject = "Regarding The Login";
    private String message = "Thank you for Loging into Employee Grevance Mangement System.. If this was not you, please contact HR immediately.\n" +
                             "Contact no: 888888888\n" +
                             "Email: hr@gmail.com\n" +
                             "If this was you, you can ignore this message.\n\n" +
                             "This is a system-generated message. Please do not reply to this.";


    // Getters and setters

    public String getRecipientEmail() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        Registration employee = (Registration) session.getAttribute("emps");
        if (employee != null) {
            recipientEmail = employee.getEmail();
        }
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendEmail(String recipientEmail) {
        final String username = "dhanunjayp4@gmail.com";
        final String password = "hpsw xuei esjd slla";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(username));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Registration> getEmplist() {
        return service.viewallemps();
    }

    public void setEmplist(List<Registration> emplist) {
        this.emplist = emplist;
    }
    
    
    public List<Registration> getEmphrlist() {
        return service.viewallhremps();
    }

    public void setEmphrlist(List<Registration> emphrlist) {
        this.emphrlist = emphrlist;
    }
    
    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition_title() {
        return position_title;
    }

    public void setPosition_title(String position_title) {
        this.position_title = position_title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(Date date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(int years_of_experience) {
        this.years_of_experience = years_of_experience;
    }

    public String getEmergency_contact_name() {
        return emergency_contact_name;
    }

    public void setEmergency_contact_name(String emergency_contact_name) {
        this.emergency_contact_name = emergency_contact_name;
    }

    public String getEmergency_contact_number() {
        return emergency_contact_number;
    }

    public void setEmergency_contact_number(String emergency_contact_number) {
        this.emergency_contact_number = emergency_contact_number;
    }

    public String getNational_id_number() {
        return national_id_number;
    }

    public void setNational_id_number(String national_id_number) {
        this.national_id_number = national_id_number;
    }

    public String getBank_account_details() {
        return bank_account_details;
    }

    public void setBank_account_details(String bank_account_details) {
        this.bank_account_details = bank_account_details;
    }

    public String getPrevious_employer() {
        return previous_employer;
    }

    public void setPrevious_employer(String previous_employer) {
        this.previous_employer = previous_employer;
    }

    public String getEducation_qualification() {
        return education_qualification;
    }

    public void setEducation_qualification(String education_qualification) {
        this.education_qualification = education_qualification;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String add() {
        Registration e = new Registration();

        int id = (int) (Math.random() * 9000) + 1000;
        e.setId(id);

        e.setFullname(fullname);
        e.setEmail(email);
        e.setDob(dob);

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String passwordWithoutSpaces = dateFormat.format(dob);

        e.setPassword(passwordWithoutSpaces);

        e.setGender(gender);
        e.setMarital_status(marital_status);
        e.setBlood_group(blood_group);
        e.setContactno(contactno);
        e.setAddress(address);
        e.setPosition_title(position_title);
        e.setDepartment(department);
        e.setDate_of_joining(date_of_joining);
        e.setSalary(salary);
        e.setYears_of_experience(years_of_experience);
        e.setEmergency_contact_name(emergency_contact_name);
        e.setEmergency_contact_number(emergency_contact_number);
        e.setNational_id_number(national_id_number);
        e.setBank_account_details(bank_account_details);
        e.setPrevious_employer(previous_employer);
        e.setEducation_qualification(education_qualification);
        e.setSkills(skills);
        e.setEmployee_type(employee_type);
        e.setStatus(status);
        e.setRole("employee");

        String res = service.addemployee(e);

        return "empreg.jsf?faces-redirect=true"; // Redirect to the employee registration page
    }

    public String deleteemployee(int id) {
        service.deleteemployee(id);
        return "viewallemps.jsf";
    }
    public String deletehremployee(int id) {
        service.deleteemployee(id);
        return "view_hr_emp.jsf";
    }

    public void validatelogin() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        Registration e = service.checkemplogin(email, password);

        if (e != null) {
            if ("Terminated".equalsIgnoreCase(e.getStatus())) {
                response.sendRedirect("contactSupport.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("emps", e);

               //String recipientEmail = e.getEmail();
               //sendEmail(recipientEmail);

                // Redirect based on role
                if ("employee".equalsIgnoreCase(e.getRole())) {
                    response.sendRedirect("emphome.jsf");
                } else if ("HR".equalsIgnoreCase(e.getRole())) {
                    response.sendRedirect("hrhome.jsf");
                } else if ("admin".equalsIgnoreCase(e.getRole())) {
                    response.sendRedirect("adminhome.jsf");
                }
            }
        }
    }

    public String update() {
        Registration e = service.viewempbyid(id);
        if (e != null) {
            Registration emp = new Registration();
            emp.setId(id);
            emp.setFullname(fullname);
            emp.setEmail(email);
            emp.setGender(gender);
            emp.setMarital_status(marital_status);
            emp.setContactno(contactno);
            emp.setSalary(salary);
            emp.setStatus(status);
            emp.setRole(role);

            service.updateemprole(emp);

            return "updatesuccess.jsf";
        } else {
            return "updatefail.jsf";
        }
    }

    public String updateemp() {
        Registration e = service.viewempbyid(id);
        if (e != null) {
            Registration emp = new Registration();
            emp.setId(id);
            emp.setFullname(fullname);
            emp.setEmail(email);
            emp.setGender(gender);
            emp.setMarital_status(marital_status);
            emp.setContactno(contactno);
            emp.setSalary(salary);
            emp.setStatus(status);

            service.updateemp(emp);

            return "updatesuccess.jsf";
        } else {
            return "updatefail.jsf";
        }
    }

    public String updatepwd(int id) {
        Registration e = service.viewempbyid(id);
        if (e != null) {
            e.setPassword(newpassword);
            service.updatepwd(e);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Password updated successfully."));

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID not found."));
            return "updatefail.jsf";
        }
    }
}
