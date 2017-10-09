package springweb.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import springweb.model.Customer;

//Basic Controller, vs Rest Controller for REST applications; difference: how response is generated
@Controller 
@RequestMapping("/customer.htm")
public class CustomerController { 

	@RequestMapping(method=RequestMethod.GET)
	public String initForm(ModelMap model) {
		Customer cust = new Customer();
		cust.setFavFramework(new String[]{"SpringMVC"});
		cust.setSex("Male");
		cust.setJavaSkills("Spring");
		cust.setSecretValue("Secret");
		model.addAttribute("customer", cust);
		return "CustomerForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("customer") Customer c, 
			BindingResult result, SessionStatus status) {
				return "CustomerSuccess";	
	}
	
	@ModelAttribute("webFrameworkList")
	public List<String> webFrameworkList() {
		List<String> webs = new ArrayList<String>();
		webs.add("SpringMVC");
		webs.add("Node");
		webs.add("React");
		return webs;
	}

	@ModelAttribute("numberList")
	public List<String> numList() {
		List<String> webs = new ArrayList<String>();
		webs.add("Number 1");
		webs.add("Number 2");
		webs.add("Number 3");
		return webs;
	}

	@ModelAttribute("javaSkillsList")
	public Map<String, String> skillsList() {
		Map<String, String> webs = new HashMap<String,String>();
		webs.put("Hibernate", "Hibernate");
		webs.put("Spring", "Spring 4");
		webs.put("Reflection", "Reflection");
		return webs;
	}

	@ModelAttribute("countryList")
	public Map<String, String> countryList() {
		Map<String, String> webs = new HashMap<String,String>();
		webs.put("US", "United States");
		webs.put("CHINA", "China");
		webs.put("SG", "Singapore");
		return webs;
	}

}
