package com.williansmartins.entity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Data {

    public Tipo[] getTipos() {
        return Tipo.values();
    }

}