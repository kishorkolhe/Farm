package com.impace.farmERP.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.impace.farmERP.helper.RestResponse;
import com.impace.farmERP.model.FarmRegistration;
import com.impace.farmERP.repository.FarmRegistrationRepository;

@Controller
//@RequestMapping("/farm")
public class FarmRegisterationController {

	public FarmRegisterationController(){
		System.out.println("Hiiiiii");
	}
	/*
	 * @RequestMapping("/welcome") public String firstPage() { return "welcome"; }
	 */

	@Autowired
	private FarmRegistrationRepository farmRegistrationRepository;

	@RequestMapping(value = "/saveFarm", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String insertFarm(@RequestBody FarmRegistration farmRegisteration) {
		farmRegistrationRepository.save(farmRegisteration);
		return "Save successfully";
	}

	@RequestMapping(value = "/getFarmList", method = RequestMethod.GET)
	public @ResponseBody Model getAllFarmList(Model model) {
		model.addAttribute("list", farmRegistrationRepository.findAll());
		return model;
	}

	@RequestMapping(value = "/deleteFarm/{id}", method = RequestMethod.GET)
	public String getAllFarmList(@PathVariable int id) {
		farmRegistrationRepository.deleteById(id);
		// return new ModelAndView("redirect:/posts")
		return "Deleted Successfully";
	}

	
	 /* @RequestMapping(value="/updateFarm/{id}", method=RequestMethod.GET) 
	  public String updateFarmList(@RequestParam("id") int id,@RequestParam("farmName")String farmName) { 
		  Optional<FarmRegistration> farmRegisteration =  farmRegistrationRepository.findById(id);
		  farmRegistrationRepository.save(farmRegisteration);
		  //return new ModelAndView("redirect:/posts") 
		  return "Deleted Successfully"; }*/
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEditData(@PathVariable int id,Model model) {
		model.addAttribute("data", farmRegistrationRepository.findById(id));
		return "post/edit";
	}
	
	
	@RequestMapping(value="/saveFarmDetails",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	 @ResponseBody RestResponse  saveData(@RequestBody String farmRegisteration, HttpServletRequest request){
		RestResponse reponse = new RestResponse();
		System.out.println("in m");
		JSONParser parser = new JSONParser();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("In saveData");
		RestResponse response = new RestResponse();
		try {
			JSONObject json = (JSONObject) parser.parse(farmRegisteration) ;

			FarmRegistration  regs = new FarmRegistration();
			regs = mapper.readValue(json.toString(),FarmRegistration.class);
			farmRegistrationRepository.save(regs);
			reponse.setMessage("Saved");
			reponse.setSuccess(true);
		
		}catch (Exception e) {
			reponse.setMessage(e.toString());
			reponse.setSuccess(false);
		}
		return reponse;
		
			
		}
	
	 
}
