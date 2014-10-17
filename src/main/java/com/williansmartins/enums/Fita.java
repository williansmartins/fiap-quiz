package com.williansmartins.enums;

public enum Fita {
	PRE("Pré-lançamento"), PRONTO("Pronto"), LANCAMENTO("Lançamento"), OBRAS("Obras");
	
	private String label;
	
	private Fita(String label){
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
