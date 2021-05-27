// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package tema1reloaded;

import java.util.ArrayList;

/************************************************************/
/**
 * 
 */
public class Elev extends Persoana {

	private Grupa grupa;
	private Parinte parinte;
	
	public Elev(String nume, String CNP, long telefon, Grupa grupa, Parinte parinte) {
		super(nume, CNP, telefon);
		this.grupa = grupa;
		this.parinte = parinte;
	}
	
	
	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

	public void setParinte(Parinte parinte) {
		this.parinte = parinte;
	}
	
	public void getNoteElev(Materie materie) {
		grupa.getNote(this, materie);
	}
	
	
	public long getMedieElev(Materie materie) {
		if(!areNoteLaMaterie(materie))
			return -1;
		
		ArrayList<Integer> note = grupa.getCatalog().get(this.nume).get(materie);
		int suma = 0;
		for(Integer i : note)
			suma += i;
		
		double medie = suma/note.size();
		if(medie - Math.floor(medie) == 0.5)
			medie += 1;
		return Math.round(medie);
	}

	public void afisareElev() {
		super.afisare();
	}

	public int getAbsente() {
		return grupa.getAbsente(this);
	}

	public Parinte getParinte() {
		return this.parinte;
	}
	
	//vezi orel
	boolean areNoteLaMaterie(Materie m) {
		if(grupa.getCatalog().get(this.nume).get(m).size() > 0)
			return true;
		return false;
	}
	
};
