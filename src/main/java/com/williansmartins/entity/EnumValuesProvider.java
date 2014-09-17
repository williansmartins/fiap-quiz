package com.williansmartins.entity;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;

@ViewScoped // or @RequestScoped
public class EnumValuesProvider implements Serializable
{
    public Tipo[] getTipos()
    {
        return Tipo.values();
    }
}