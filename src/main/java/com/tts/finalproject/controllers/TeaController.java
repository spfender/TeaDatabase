package com.tts.finalproject.controllers;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.finalproject.models.MyFormObject;
import com.tts.finalproject.models.Tea;
import com.tts.finalproject.services.TeaService;

@Controller
public class TeaController 
{
	@Autowired
	TeaService teaService;
	
	@GetMapping ("/")
	public String teaForm(Model model)
	{
	model.addAttribute("tea", new Tea());
	return "index";
	}
	
	@PostMapping("/")
	public String teaSubmit(@ModelAttribute Tea tea, Model model)
	{
		teaService.save(tea);
		model.addAttribute("tea", tea);
		return "result";
	}
	
	@GetMapping("/tea")
	public String getList(@RequestParam(value="sort", required = false) String sort, Model model)
	{
	List<Tea> allTeas;
	    allTeas = teaService.findAll();
	    if (sort == null)
	    {
	    	sort = "";
	    }
	    if (sort.equals("name"))
	    {
	    	Collections.sort(allTeas, Comparator.comparing(Tea::getName));
	    }
	    if (sort.equals("year"))
	    {
	    	Collections.sort(allTeas, Comparator.comparing(Tea::getYear));
	    }
	    if (sort.equals("type"))
	    {
	    	Collections.sort(allTeas, Comparator.comparing(Tea::getType));
	    }
	    model.addAttribute("teaList", allTeas);
	    System.out.println(allTeas.size());
	    System.out.println("hello world");
		return "tea";
	}
	
	@DeleteMapping("/tea/{id}")
	public String deleteById(@PathVariable Long id) {
		teaService.deleteById(id);
	    return "redirect:/tea";
	}
	
	@GetMapping("/tea/name")
	public String findByName(Model model, @ModelAttribute("myFormObject") MyFormObject myFormObject, BindingResult result)
	{
		List<Tea> teas = this.teaService.findByName(myFormObject.getTName());
		model.addAttribute("teas", teas);
		return "redirect:/tea";
	}
    
  
    
//    @RequestMapping("/teaUpdate/{id}")
//    public String teaUpdate(@PathVariable Long id)
//    {
//    	teaService.updateEntry
//    }
//    

}
