package com.beingjavaguys.controller;

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

import com.beingjavaguys.model.ConsumerGroup;
import com.beingjavaguys.services.DataServices;

@Controller
@RequestMapping("/ConsumerGroup")
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
	public @ResponseBody Status addConsumerGroup(@RequestBody ConsumerGroup consumergroup) {
		// System.out.println(consumergroup.getFirstName());
		try {
			Integer createdId = dataServices.addEntity(consumergroup);
			return new Status(1, "ConsumerGroup added Successfully ! Newly Generated Consumer Group ID " +createdId);
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status updateConsumerGroup(@RequestBody ConsumerGroup consumergroup) {
		// System.out.println(consumergroup.getFirstName());
		try {

			boolean isUpdated = dataServices.updateEntity(consumergroup);
			if (isUpdated)
				return new Status(1, "ConsumerGroup Updated Successfully !");
			else {
				return new Status(0, "ConsumerGroup Updation Failed ! NO id exist for Update");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0,"ConsumerGroup Updation Failed !"+ e.getMessage());
		}

	}

	/* Getting List of objects in Json format in Spring Restful Services */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<ConsumerGroup> getConsumerGroup() {

		List<ConsumerGroup> consumergroupList = null;

		try {
			consumergroupList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return consumergroupList;
	}

	
	/* Ger a single objct in Json form in Spring Rest Services */  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ConsumerGroup getConsumerGroup(@PathVariable("id") int id) {

		ConsumerGroup consumergroup = null;

		try {
			consumergroup = dataServices.getEntityById(id);

		
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ConsumerGroup();
		}
		return consumergroup;
	}
	
	
	// Delete an object from DB in Spring Restful Services
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteConsumerGroup(@PathVariable("id") int id) {

		try {

			dataServices.deleteEntity(id);
			return new Status(1, "ConsumerGroup deleted Successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, "ConsumerGroup Deletion Failed  Reason: " + e.getMessage());

		}

	}
}
