package it.polito.tdp.libretto.model;

import java.util.*;

public class Libretto {
	//classe che contiene una lista di voti
	
	private List<Voto> voti;
	private List<Voto> listaVotiPariA25 = new ArrayList<Voto>();
	
	public Libretto() {
		
		this.voti = new  LinkedList<Voto>();
	}
	
  public void add(Voto v) {
	this.voti.add(v);
   }
   public List<Voto> ListaVoti(){
	   return voti;
   }
   
   public List<Voto> punteggioDi25(int punteggio){
	   
	   for (Voto vi: voti) {
		   if(vi.getVotoEsame()==punteggio) {
			   listaVotiPariA25.add(vi);
		   }
	   }  
	   return listaVotiPariA25;
   }
   //ora faccio lo stesso algoritmo ma ritornando un oggetto di tipo libretto
   
 public Libretto VotiUguagli(int punteggio) {
	 Libretto risultato = new Libretto();
	 for (Voto vi: voti) {
		   if(vi.getVotoEsame()==punteggio) {
			   risultato.add(vi);
		     }
	      }
	 return risultato;
 }
 /*  public List<Voto> getList(){
	   return listaVotiPariA25;
   }*/
   
@Override
public String toString() {
	String ss = "";
	for(Voto v: voti) {
		ss+= v.toString();
	}
	ss= "libretto: \n"+ ss;
	return  ss;
}
}
