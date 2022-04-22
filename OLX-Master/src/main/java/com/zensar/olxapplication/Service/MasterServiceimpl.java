package com.zensar.olxapplication.Service;

import java.util.ArrayList;
import java.util.List;

import com.zensar.olxapplication.category;
import com.zensar.olxapplication.status;

public class MasterServiceimpl implements MasterService {

	static List<category> category = new ArrayList<>();
	static List<status> status = new ArrayList<>();
	static {
		category.add(new category(1, "Furniture"));
		category.add(new category(2, "Cars"));
		category.add(new category(3, "Mobile Phones"));
		category.add(new category(4, "Real Estate"));
		category.add(new category(5, "Sports"));
		status.add(new status(11, "Open"));
		status.add(new status(12, "Open"));
		status.add(new status(13, "Closed"));
		status.add(new status(14, "Open"));
		status.add(new status(15, "Closed"));
	}
	
	
	@Override
	public List<category> getAllCategories() {
		// TODO Auto-generated method stub
		return category;
	}

	@Override
	public List<status> getAllStatuses() {
		// TODO Auto-generated method stub
		return status;
	}

}
