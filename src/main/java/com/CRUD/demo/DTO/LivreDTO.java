package com.CRUD.demo.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LivreDTO {
	private int id ;
	private String titre;
	private Date dsortie;
	private String nbrpages;
	private Boolean disponible ;
	

}
