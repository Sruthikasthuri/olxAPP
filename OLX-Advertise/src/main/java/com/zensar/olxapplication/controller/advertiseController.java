package com.zensar.olxapplication.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.Advertise;
import com.zensar.olxapplication.AdvertiseDetails;

@RestController
public class advertiseController {
	static List<Advertise> advertises = new ArrayList<Advertise>();
	static {
		advertises.add(new Advertise(1L, "laptop sale", 5400, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"10/031998", "21/052022", "OPEN", "Anand Kulkarni"));
	}

	@GetMapping("/advertises")
	public List<Advertise> getAllUsers(@RequestHeader("userName") String userName,

			@RequestHeader("password") String password) {

		if (userName.equals("anand") && password.equals("anand123")) {
			return advertises;
		}

		return null;

	}

	@GetMapping
	@RequestMapping(value = "/user/advertise", method = RequestMethod.GET)
	public List<Advertise> getAllCategories(@RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			return advertises;
		}
		return null;
	}

	// @GetMapping("/user/advertise/{Id}")
	// Getting Specific Advertisement
	@RequestMapping(value = "/user/advertise/{Id}", method = RequestMethod.GET)
	public Advertise getSpecificAdvertisement(@PathVariable("Id") long id, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {

			for (Advertise advertise : advertises) {

				if (advertise.getId() == id) {
					return advertise;
				}
			}
		}
		return null;
	}

	// Deleting specific Advertise
	@DeleteMapping("/user/advertise/{Id}")
	public boolean deleteSpecificAdvertise(@PathVariable("Id") long id, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {

		if (username.equals("anand") && password.equals("anand123")) {
			for (Advertise advertise : advertises) {
				if (advertise.getId() == id) {
					advertises.remove(advertise);

					return true;
				}

			}

		}
		return false;

	}

	@PostMapping("/advertise")
	public ResponseEntity<Advertise> addAdvertise(@RequestBody Advertise ads,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			advertises.add(ads);
			ads.setCategory("Electronic goods");
			ads.setUsername("anand");
			ads.setCreatedDate("4/21/22");
			ads.setModifiedDate("4/21/22");
			ads.setStatus("OPEN");
			return new ResponseEntity<Advertise>(ads, HttpStatus.CREATED);
		}

		return null;

	}

}

/*
 * @PostMapping("/advertise") public Advertise addAdvertise(@RequestBody
 * Advertise advertise1, @RequestHeader("auth-token") String token) { if
 * (token.equals("sk66631")) { Advertise advertise = new Advertise(2,
 * "Sofa available for sale", 30000, "Furniture",
 * "Sofa 5 years old available for sale in pune", "anand", 1998, 2022, "OPEN");
 * advertise.setId(advertise1.getId());
 * advertise.setTitle(advertise1.getTitle());
 * advertise.setPrice(advertise1.getPrice());
 * advertise.setDescription(advertise1.getDescription()); List<Advertise>
 * advertiseList = null; advertiseList.add(advertise); return advertise; } else
 * return null; }
 * 
 * @PutMapping("/advertise/{id}") public Advertise updateAdvertise(@PathVariable
 * int id, @RequestBody Advertise advertise2,
 * 
 * @RequestHeader("auth-token") String token2) { if (token2.equals("sk66631")) {
 * Collection<Advertise> advertiseList = null; Optional<Advertise> findAny =
 * advertiseList.stream().filter(advertise -> advertise.getId() ==
 * id).findAny(); if (findAny.isPresent()) { Advertise adv = findAny.get();
 * adv.setTitle(advertise2.getTitle()); } } return advertise2; }
 * 
 * }
 * 
 * /* static { advertises.add(new Advertise(1L, "laptop sale", 5400,
 * "Electronic goods", "intel core 3 Sony Vaio", "anand", 1998, 2022, "OPEN"));
 * }
 * 
 * @GetMapping("/advertises") public List<Advertise>
 * getAllUsers(@RequestHeader("userName") String userName,
 * 
 * @RequestHeader("password") String password) {
 * 
 * if (userName.equals("anand") && password.equals("anand123")) { return
 * advertises; }
 * 
 * return null;
 * 
 * }
 * 
 * @GetMapping("/user/advertise") public List<Advertise>
 * getAllAdvertise(@RequestHeader("userName") String username,
 * 
 * @RequestHeader("password") String password) { if (username.equals("anand") &&
 * password.equals("anand123")) { return advertises; }
 * 
 * return null; }
 * 
 * @GetMapping("/advertise/search") public List<Advertise> searchAdvertise() {
 * 
 * return advertises;
 * 
 * }
 * 
 * //@GetMapping("/advertise/{postId}") static List<AdvertiseDetails>
 * advertiseDetails = new ArrayList<AdvertiseDetails>();
 * 
 * public List<AdvertiseDetails> advertiseDetails(@PathVariable("postId") long
 * id,
 * 
 * @RequestHeader("userName") String username, @RequestHeader("password") String
 * password) { if (username.equals("anand") && password.equals("anand123")) {
 * for (AdvertiseDetails ads : advertiseDetails) { if (ads.getId() == id) {
 * 
 * return advertiseDetails; } } } return null;
 * 
 * }
 * 
 * /*
 * 
 * @PutMapping("/advertises/{id}")
 * 
 * @GetMapping
 * 
 * @RequestMapping(value="/{id}",method=RequestMethod.POST) public Advertise
 * updateadvertise(@PathVariable int id,@RequestBody Advertise advertise) {
 * Advertise availableadvertise=getAdvertise(id); availableadvertise.getId();
 * availableadvertise.getTitle(); availableadvertise.getPrice();
 * availableadvertise.getCategory(); availableadvertise.getDescription();
 * availableadvertise.getUsername(); availableadvertise.getCreatedDate();
 * availableadvertise.getModifiedDate(); availableadvertise.getStatus(); return
 * availableadvertise; }
 * 
 * private Advertise getAdvertise(int id) { // TODO Auto-generated method stub
 * return null; }
 */
