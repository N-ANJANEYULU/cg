package com.acc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.model.UserRegister;
import com.acc.services.DataServices;

@Controller
@RequestMapping("/UserRegister")
public class RestController {
	
	@Autowired
	DataServices dataServices;

	public DataServices getDataServices() {
		return dataServices;
	}
	public void setDataServices(DataServices dataServices) {
		this.dataServices = dataServices;
	}

	static final Logger logger = Logger.getLogger(RestController.class);
	
	/* Submit form in Spring Restful Services */
	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addUserRegister(@RequestBody UserRegister userregister) {
		// System.out.println(userregister.getFirstName());
		try {
			Integer userId = dataServices.addEntity(userregister);
			return new Status(1, "UserRegister added Successfully ! Newly Generated User ID " + userId);
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status updateUserRegister(@RequestBody UserRegister userregister) {
		// System.out.println(userregister.getFirstName());
		try {

			boolean isUpdated = dataServices.updateEntity(userregister);
			if (isUpdated)
				return new Status(1, "UserRegister Updated Successfully !");
			else {
				return new Status(0, "UserRegister Updation Failed ! NO id exist for Update");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0,"UserRegister Updation Failed !"+ e.getMessage());
		}

	}

	/* Getting List of objects in Json format in Spring Restful Services */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<UserRegister> getUserRegister() {

		List<UserRegister> userregisterList = null;

		try {
			userregisterList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userregisterList;
	}

	
	/* Ger a single objct in Json form in Spring Rest Services */  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody UserRegister getUserRegister(@PathVariable("id") int id) {

		UserRegister userregister = null;

		try {
			userregister = dataServices.getEntityById(id);

		
		} catch (Exception e) {
			
			e.printStackTrace();
			return new UserRegister();
		}
		return userregister;
	}
	
	
	// Delete an object from DB in Spring Restful Services
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteUserRegister(@PathVariable("id") int id) {

		try {

			dataServices.deleteEntity(id);
			return new Status(1, "UserRegister deleted Successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, "UserRegister Deletion Failed  Reason: " + e.getMessage());

		}

	}
}

	


