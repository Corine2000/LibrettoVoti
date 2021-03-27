package it.polito.tdp.libretto.model;

import java.security.InvalidParameterException;
import java.util.*;

public class Libretto {
	//classe che contiene una lista di voti
	
	private List<Voto> voti;
	private List<Voto> LibrettoMigliorato;
	private Map<String, Voto> mappaLibretto;
	
	private List<Voto> listaVotiPariA25 = new ArrayList<Voto>();
	//si potrebbe usare anche in parallelo alla lista una mappa, cosi la ricerva sarebbe piu veloce
	
	public Libretto() {
		
		this.voti = new  LinkedList<Voto>();
		LibrettoMigliorato = new  ArrayList<Voto>(); 
		mappaLibretto = new HashMap<String, Voto>();
		
	}
	/* modifichiamo questo metodo in modo tale da evitare di inserire lo stesso oggetto Voto.
	 * secondo me conviene una mappa  oppure usare i due metodi implementati sotto
	 */
	
  public void add(Voto v) { 
	  
	  if(esisteDupplicato(v) || esisteConflitto(v)) {
		  throw new InvalidParameterException("Non puoi creare un Voto con lo stesso nomeEsame");
	  } else {
		       this.voti.add(v);
		       
		       if(v.getVotoEsame()>= 18 && v.getVotoEsame()<24) {
		    	  v.setVotoEsame(v.getVotoEsame()+1);
		    	  LibrettoMigliorato.add(v);
		         }
		       if(v.getVotoEsame()>=24 && v.getVotoEsame()<29) {
		    	   v.setVotoEsame(v.getVotoEsame()+2);
			    	  LibrettoMigliorato.add(v);

		       }
	  }
		   
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
 
 public Voto ricercaVoto(String nomeCorso) {
	 Voto Trovato =null ;
	 
	 for(Voto v: voti) {
		 if(v.getNomecorso().equals(nomeCorso)) {
			 Trovato= v;
		     break;
		 }
	 }
	 return Trovato;
 }
 
 /**
  * questo metodo verifica se esista un nuovo oggetto voto con lo stesso nome et stesso punteggio
  * @param v
  * @return
  */
 public boolean esisteDupplicato (Voto v) {
	 boolean trovato = false;
	 
	 for( Voto vi: voti) {
		 if(vi.getNomecorso().equals(v.getNomecorso()) && vi.getVotoEsame() == v.getVotoEsame()) {
			 trovato = true;
		 }
	 }
	 return trovato;
 }
   
 /**
  * questo metodo verifica se esista un nuovo oggetto voto con lo stesso nome e punteggio diverso
  * @param v
  * @return
  */
 public boolean esisteConflitto(Voto v) {
	 boolean trovato = false;
	 
	 for( Voto vi: voti) {
		 if(vi.getNomecorso().equals(v.getNomecorso()) && vi.getVotoEsame() != v.getVotoEsame()) {
			 trovato = true;
		 }
	 }
	 return trovato;
 }
	@Override
	public String toString() {
		String ss = "";
		for(Voto v: voti) {
			ss+= v.toString();
		}
		ss= "libretto: \n"+ ss;
		return  ss;
	  }
	
  /* public String descrivitiLibrettoMigliorato() {
	   String s = "";
		for(Voto v: LibrettoMigliorato) {
			s+= v.toString();
		}
		s= "librettoMigliorato: \n"+ s;
		return  s;
   }*/
}
