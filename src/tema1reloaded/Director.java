// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package tema1reloaded;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;




/************************************************************/
/**
 * 
 */
public class Director extends Persoana {
	/**
	 * 
	 */
	private ArrayList<Grupa> grupe;

	public Director(String nume, String CNP, long telefon) {
		super(nume, CNP, telefon);
		grupe = new ArrayList<Grupa>();
	}
	
	public ArrayList<Grupa> getGrupe() {
		return grupe;
	}
	
	public void adaugaGrupa(Grupa grupa) {
		if(!grupe.contains(grupa))
			grupe.add(grupa);
		else
			System.out.println("Grupa exista deja");
	}
	
	public Grupa getGrupa(String numeGrupa) {
		if(existaGrupa(numeGrupa)) {
			for(Grupa grupa : grupe)
				if(grupa.getNumeGrupa().equals(numeGrupa)) {
					return grupa;
				}
		}
		
		return null;
	}
	
	
	public void topAbsente(String numeGrupa) {
		Grupa grupa = null;
		int MAX = 0; int absente = 0;
		Elev chiulangiul = null;
		for(Grupa g : grupe)
			if(g.getNumeGrupa().equals(numeGrupa)) {
				grupa = g;
				break;
			}
		if(!sePoateFaceTopAbsente(grupa)) {
			return;
		}
		
		for(Elev elev : grupa.getEleviInscrisi()) {
			
			absente = elev.getAbsente();
			
			if(absente > MAX) { 
				MAX = absente;
				chiulangiul = elev;
			}			
		}
		
		System.out.println("Elevul cu cele mai multe absente: "+ chiulangiul.nume +" : " + MAX);
	}
	
	
	public void topEleviNote(String numeGrupa) {
		Grupa g1 = this.getGrupa(numeGrupa);
		if(!sePoateFaceTopEleviNote(g1))
			return ;
		
		if(g1 != null) {
			
			Map<String, Double> unsortedMap = new HashMap<>();
			
			for(Elev elev : g1.getEleviInscrisi()) {
				int suma = 0;
				for (Materie materie : Materie.values()) { 
					suma += elev.getMedieElev(materie);
				}
				double medie = suma/Materie.values().length;
				medie = Math.round(medie * 100.0) / 100.0;
				unsortedMap.put(elev.nume, medie);
				
			}
			
			Collection<Double> values = unsortedMap.values();   
	        ArrayList<Double> listOfValues = new ArrayList<>(values);
	        
	        Collections.sort(listOfValues, Collections.reverseOrder());
	        Set<Double> resultSet = new LinkedHashSet<>(listOfValues);


	        ArrayList<Double> noteBursa = new ArrayList<>();

	        for(Double i : resultSet){
	            noteBursa.add(i);
	            if(noteBursa.size() == 6)
	                break;
	        }

	        ArrayList<String> premiul1 = new ArrayList<>();
	        ArrayList<String> premiul2 = new ArrayList<>();
	        ArrayList<String> premiul3 = new ArrayList<>();
	        ArrayList<String> mentiune1 = new ArrayList<>();
	        ArrayList<String> mentiune2 = new ArrayList<>();
	        ArrayList<String> mentiune3 = new ArrayList<>();
	        
	        double c0 = noteBursa.get(0);
	        double c1 = noteBursa.get(1);
	        double c2 = noteBursa.get(2);
	        double c3 = noteBursa.get(3);
	        double c4 = noteBursa.get(4);
	        double c5 = noteBursa.get(5);

	        for(String s : unsortedMap.keySet()) {
	            if(unsortedMap.get(s) == c0)
	                premiul1.add(s);
	            if(unsortedMap.get(s) == c1)
	                premiul2.add(s);
	            if(unsortedMap.get(s) == c2)
	                premiul3.add(s);
	            if(unsortedMap.get(s) == c3)
	            	mentiune1.add(s);
	            if(unsortedMap.get(s) == c4)
	            	mentiune2.add(s);
	            if(unsortedMap.get(s) == c5)
	            	mentiune3.add(s);
	        }
	        
	        System.out.print("premiul 1: ");
	        for(String s : premiul1)
	            System.out.print(s + " ");
	        System.out.println();
	        
	        System.out.print("premiul 2: ");
	        for(String s : premiul2)
	            System.out.print(s + " ");
	        System.out.println();
	        
	        System.out.print("premiul 3: ");
	        for(String s : premiul3)
	            System.out.print(s + " ");
	        System.out.println();
	        
	        System.out.print("mentiune 1: ");
	        for(String s : mentiune1)
	            System.out.print(s + " ");
	        System.out.println();
	        
	        System.out.print("mentiune 2: ");
	        for(String s : mentiune2)
	            System.out.print(s + " ");
	        System.out.println();
	        
	        System.out.print("mentiune 3: ");
	        for(String s : mentiune3)
	            System.out.print(s + " ");
	        System.out.println();
		}


	}
	
	public boolean sePoateFaceTopEleviNote(Grupa g){
		int elevBun = 0;
		
		for(Elev elev : g.getEleviInscrisi()) {
			int suma = 0;
			for (Materie materie : Materie.values()) { 
				suma += elev.getMedieElev(materie);
			}
			double medie = suma/Materie.values().length;
			medie = Math.round(medie * 100.0) / 100.0;
			
			//elev cu media >= 6 se adauga la numaratoare
			if(medie > 5.99) {
				elevBun ++;
			}
			
			if(elevBun > 5)
				return true;
		}
		
		return false;
	}
	
	public boolean sePoateFaceTopAbsente(Grupa g) {
		return g.getEleviInscrisi().size() > 2;
		
	}
	
	public boolean existaGrupa(String numeGrupa) {
		for(Grupa grupa : grupe)
			if(grupa.getNumeGrupa().equals(numeGrupa)) {
				return true;
			}
		return false;

	}
	
}
