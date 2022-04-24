package com.CRUD.demo.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.demo.DTO.LivreDTO;
import com.CRUD.demo.entity.Livre;
import com.CRUD.demo.repository.LivreRepository;
	@Service
public class LivreService {
	@Autowired
    LivreRepository repo;
	
	public List<LivreDTO> getAllLivres(){
		//return repo.findByOrderByTitreAsc();	
		return repo.findByOrderByTitreAsc()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
	}
	
	public Livre getLivre(Integer id){	
		return repo.findById(id).orElse(null);
        
	}
	
	public void createLivre(Livre livre) {
		repo.save(livre);
	}
	
	 private LivreDTO convertEntityToDto(Livre livre){
		 LivreDTO livreDto = new LivreDTO();
		 livreDto.setId(livre.getId());
		 livreDto.setTitre(livre.getNbrpages());
		 livreDto.setNbrpages(livre.getNbrpages());
		 livreDto.setDsortie(livre.getDsortie());
		 livreDto.setDisponible(livre.getDisponible());
		 return livreDto;
	 }
		 
	public void updateLivre( Livre livre , Integer id) {
		Livre livreExistant = repo.findById(id).orElseThrow();
		
		livreExistant.setAuteur(livre.getAuteur()!=null ?livre.getAuteur() : livreExistant.getAuteur());
		livreExistant.setDisponible(livre.getDisponible()!= null ?livre.getDisponible() : livreExistant.getDisponible());
		livreExistant.setNbrpages(livre.getNbrpages()!=null ?livre.getNbrpages() : livreExistant.getNbrpages());
		livreExistant.setTitre(livre.getTitre()!=null ?livre.getTitre() : livreExistant.getTitre());
		livreExistant.setDconsultation(new Date());
		livreExistant.setDsortie(livre.getDsortie()!=null ? livre.getDsortie(): livreExistant.getDsortie());
		repo.save(livreExistant);
	}
	
	public void deleteLivre(Integer id) {
		repo.deleteById(id);
	}
}
