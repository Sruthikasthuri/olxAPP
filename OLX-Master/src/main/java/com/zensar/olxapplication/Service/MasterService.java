package com.zensar.olxapplication.Service;

import java.util.List;

import com.zensar.olxapplication.category;
import com.zensar.olxapplication.status;

public interface MasterService {
	public List<category> getAllCategories();
	public List<status> getAllStatuses();

}
