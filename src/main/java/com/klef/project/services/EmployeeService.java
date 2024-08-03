package com.klef.project.services;

import java.util.List;

import com.klef.project.models.Registration;

public interface EmployeeService
{
 public String addemployee(Registration employee);//Registartion

 public Registration checkemplogin(String email,String password);
 
 public String deleteemployee(int id);
 
 public Registration viewempbyid(int id);
 public String updateemprole(Registration employee);


public String updatepwd(Registration employee);
 
 public List<Registration> viewallemps();

public List<Registration> viewallhremps();

public String updateemp(Registration employee);




}
