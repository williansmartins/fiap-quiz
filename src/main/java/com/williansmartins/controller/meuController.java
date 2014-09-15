package com.williansmartins.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="bean")
@ViewScoped
public class meuController implements Serializable{

	private static final long serialVersionUID = 1L;

	public meuController(){
		System.out.println("construtor");
	}
	
	public void metodo(){
		System.out.println(123);
	}
}

