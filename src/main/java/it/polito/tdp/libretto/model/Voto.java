package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto {
	
	private String  nomecorso;
	private int votoEsame;
	private LocalDate Data;
	
	public Voto(String nomecorso, int votoEsame, LocalDate data) {
		
		this.nomecorso = nomecorso;
		this.votoEsame = votoEsame;
		Data = data;
	}

	public String getNomecorso() {
		return nomecorso;
	}

	public void setNomecorso(String nomecorso) {
		this.nomecorso = nomecorso;
	}

	public int getVotoEsame() {
		return votoEsame;
	}

	public void setVotoEsame(int votoEsame) {
		this.votoEsame = votoEsame;
	}

	public LocalDate getData() {
		return Data;
	}

	public void setData(LocalDate data) {
		Data = data;
	}
	
	
	

}
