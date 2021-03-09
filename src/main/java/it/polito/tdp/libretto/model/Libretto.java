package it.polito.tdp.libretto.model;

import java.util.*;

public class Libretto {
	//classe che contiene una lista di voti
	
	private List<Voto> voti;

	public Libretto() {
		
		this.voti = new  LinkedList<Voto>();
	}
	
public void add(Voto v) {
	this.voti.add(v);
   }
}
