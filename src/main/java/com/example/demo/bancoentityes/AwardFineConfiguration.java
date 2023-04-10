package com.example.demo.bancoentityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="awards_fines_configurations")
public class AwardFineConfiguration {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private double current;
	private String description;
	
	

}
