package com.ms.cse.api.controller;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cse.api.exception.CustomAllException;
import com.ms.cse.api.service.ApiService;

@RestController
public class ApiTypeDefs {

	
	private static final Logger LOG = LoggerFactory.getLogger(ApiTypeDefs.class);
	
	
	@Autowired
	ApiService apiService;
	

	
	
	@GetMapping("/api/typedefs")
	public String typedefsGet(@RequestBody String ipJSON) throws IOException, Exception {
		try {
			return apiService.callApi("GET", ipJSON, "v2/types/typedefs");
		}	catch (CustomAllException e) {
			e.printStackTrace();
			 throw new CustomAllException(e.getLocalizedMessage());

		}
		
	}
	
	@DeleteMapping("/api/typedefs")
	public String typedefsDelete(@RequestBody String ipJSON) throws IOException, Exception {
		try {
			return apiService.callApi("DELETE", ipJSON, "v2/types/typedefs");
		}	catch (CustomAllException e) {
			e.printStackTrace();
			 throw new CustomAllException(e.getLocalizedMessage());

		}
		
	}
	
	@PostMapping("/api/typedefs")
	public String typedefsPost(@RequestBody String ipJSON) throws IOException, Exception {
		try {
			return apiService.callApi("POST", ipJSON, "v2/types/typedefs");
			
		}	catch (CustomAllException e) {
			e.printStackTrace();
			 throw new CustomAllException(e.getLocalizedMessage());

		}
		
	}
	
	@PutMapping("/api/typedefs")
	public String typedefsPut(@RequestBody String ipJSON) throws IOException, Exception {
		try {
			return apiService.callApi("PUT", ipJSON, "v2/types/typedefs");
		}	catch (CustomAllException e) {
			e.printStackTrace();
			 throw new CustomAllException(e.getLocalizedMessage());

		}
		
	}
	
	
	
	
}