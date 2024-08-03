package com.klef.project.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.project.models.Registration;

@Remote
public interface AdminService 
{
	  public long empcount();
   public long hrcount();
   public long emcount();
   public long acount();
}
