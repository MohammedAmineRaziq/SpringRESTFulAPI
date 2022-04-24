package com.CRUD.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.demo.DTO.LivreDTO;
import com.CRUD.demo.entity.Livre;
import com.CRUD.demo.service.LivreService;

@RestController
@RequestMapping("/emsi_api/livres")
public class LivreController {
    @Autowired
    LivreService Service;
	
	@GetMapping
	public List<LivreDTO> getAllLivres(){
		return Service.getAllLivres();	
	}
	
	@GetMapping("{id}")
	public Livre getLivre(@PathVariable("id") Integer id){
		return Service.getLivre(id);		
	}
	
	@PostMapping("/create")
	public void createLivre(@RequestBody Livre livre) {
		
		Service.createLivre(livre);
	}
	@PutMapping("/update/{id}")
	public void updateLivre(@RequestBody Livre livre ,@PathVariable("id") Integer id) {

		livre.setDconsultation(new Date());
		Service.updateLivre(livre , id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteLivre(@PathVariable("id") Integer id) {
		Service.deleteLivre(id);
	}


}
