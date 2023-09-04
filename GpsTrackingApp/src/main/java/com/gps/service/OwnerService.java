package com.gps.service;

import com.gps.exception.OwnerException;
import com.gps.model.Owner;

public interface OwnerService {

	public String addOwner(Owner owner) throws OwnerException;

}
