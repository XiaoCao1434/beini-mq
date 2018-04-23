package com.beini.mq.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class TestTemp implements Serializable{
	public TestTemp(String name) {
		this.name = name;
	}
	private static final long serialVersionUID = 4491521626102693770L;
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
}
