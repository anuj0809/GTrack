package com.gps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gps.exception.OwnerException;
import com.gps.model.Owner;
import com.gps.service.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	
	@Autowired
	private OwnerService oService;
	
	/**
	 * API to create owner 
	 **/
	@PostMapping("/create")
	public ResponseEntity<String> CreateOwner(@RequestBody Owner owner) throws OwnerException{
		
		       String message =  oService.addOwner(owner);        
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
}
