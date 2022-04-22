package com.zensar.olxapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertiseDetails {
	private long id;
	private String title;
	private double price;
	private String category;
	private String description;
	private String username;
	private int createdDate;
	private int modifiedDate;
	private String status;
	private String postedBy;
}
