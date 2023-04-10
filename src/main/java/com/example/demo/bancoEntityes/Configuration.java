package com.example.demo.bancoEntityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="configurations")
public class Configuration {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@Column (name="Live_Time")
	private int liveTime;
	
}
