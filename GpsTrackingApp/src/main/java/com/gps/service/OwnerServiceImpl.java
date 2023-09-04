package com.gps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps.exception.OwnerException;
import com.gps.model.Owner;
import com.gps.repository.OwnerRepo;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepo oRepo;
	
	@Override
	public String addOwner(Owner owner) throws OwnerException {

		if(owner.getLicenseNumber() == null || owner.getPhoneNumber()==null) {

		 throw new OwnerException("Please check owner details");
		}
		
		oRepo.save(owner);
	
		return "Owner Created Successfully";
	}
	

}
