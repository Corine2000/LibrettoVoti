package it.polito.tdp.libretto.model;

import java.time.LocalDate;
import java.util.*;

public class TestLibretto {

	public static void main(String[] args) {
		/*
		 * questa classe non deve sapere come la classe libretto grestisce i voti
		 * quindi devo evitare di mettere dei getter nella  classe libretto
		 */
		
		Libretto libretto = new Libretto();
		
		//ora creo 10 oggeti della classe libretto
													//anno,mese,giorno
		Voto v1 = new Voto("chimica", 28, LocalDate.of(2019, 05, 18));
		Voto v2 = new Voto("Matematica per L'ingegneria", 26, LocalDate.of(2016, 12, 10));
		Voto v3 = new Voto("chimica Sperimentale per l'ingegneria", 22, LocalDate.of(2021, 01, 25));
		Voto v4 = new Voto("scienze applicate", 20, LocalDate.of(2018, 05, 18));
		Voto v5 = new Voto("Informatica", 29, LocalDate.of(2005, 05, 18));
		Voto v6 = new Voto("Analisi I", 18, LocalDate.of(2001, 01, 29));
		Voto v7 = new Voto("Fisaca II", 24, LocalDate.of(2020, 07, 11));
		Voto v8 = new Voto("Sistemi di produzione", 25, LocalDate.of(2019, 06, 8));
		Voto v9 = new Voto("Reattori chimici", 23, LocalDate.of(2021, 02, 18));
		Voto v10= new Voto("droni", 25, LocalDate.of(2012, 9, 4));
		
		libretto.add(v1);
		libretto.add(v2);
		libretto.add(v3);
		libretto.add(v4);
		libretto.add(v5);
		libretto.add(v6);
		libretto.add(v7);
		libretto.add(v8);
		libretto.add(v9);
		libretto.add(v10);
		
		System.out.println(libretto.toString());
		//stampa tutti i corsi in cui il voto è pari a 25
		List<Voto> listaVotiPariA25 = new ArrayList<Voto>();
		listaVotiPariA25 = libretto.punteggioDi25(25);
		
		for(Voto v: listaVotiPariA25)  //stampo solo i nomi del cosro
		System.out.println(v.getNomecorso()); // il print ln mi garantisce che alla linea dopo ogni elemento
		
		Libretto librettoDei25 = libretto.VotiUguagli(25);
		System.out.println(librettoDei25);
		
	}

}
