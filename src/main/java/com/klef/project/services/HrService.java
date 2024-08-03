package com.klef.project.services;

import java.util.List;

import com.klef.project.models.Empgrevance;
import com.klef.project.models.Registration;

public interface HrService 
{
	 public String addGrievance(Empgrevance gre);

	public List<Empgrevance> viewallgre();

	public List<Empgrevance> mygre();

	public long grecount();

	public long gresolcount();

	public long grepencount();
	
	 public Empgrevance viewgrebyid(int ticket_id);


	 public String deletegre(int ticket_id);

	public String updategrestatus(Empgrevance gre);
	

}
