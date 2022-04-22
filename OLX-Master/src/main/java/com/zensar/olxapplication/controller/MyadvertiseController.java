package com.zensar.olxapplication.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.category;
import com.zensar.olxapplication.status;
import com.zensar.olxapplication.Service.MasterService;

@RestController
public class MyadvertiseController {

	@Autowired
	private MasterService masterService;
	
	
	// Returns all categories of advertisements
	//@GetMapping(value="/category",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<category> getAllCategories()
	{
		return masterService.getAllCategories();
	}
	//@GetMapping(value="/status",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<status> getAllStatuses()
	{
		return masterService.getAllStatuses();
	}
}