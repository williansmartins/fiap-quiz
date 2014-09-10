package com.williansmartins.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="foto")
public class FotoEntity implements Serializable {
	
	private static final long serialVersionUID = 83908783713350043L;
	
	@Id @GeneratedValue
	Integer id;
	
	String grande;
	String thumb;
	
	public FotoEntity() {
		super();
	}

	public FotoEntity(String grande, String thumb) {
		super();
		this.grande = grande;
		this.thumb = thumb;
	}
	
	
}
