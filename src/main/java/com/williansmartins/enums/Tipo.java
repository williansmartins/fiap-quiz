package com.williansmartins.enums;

public enum Tipo {
	APARTAMENTO("Apartamento"), CASA("Casa"), QUALQUER("Qualquer"), SALA_COMERCIAL("Sala comercial"), TERRENO("Terreno");
	
	private String label;
	
	private Tipo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
	
	@Override
    public String toString() {
        return this.getLabel();
    }
}
