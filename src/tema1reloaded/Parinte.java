// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package tema1reloaded;

import java.util.ArrayList;

/************************************************************/
/**
 * 
 */
public class Parinte extends Persoana {
	/**
	 * 
	 */
	private ArrayList<Elev> copiiElevi;
	
	

	public Parinte(String nume, String CNP, long telefon) {
		super(nume, CNP, telefon);
		this.copiiElevi = new ArrayList<Elev>();
	}


	public void adaugareCopil(Elev copil) {
		copiiElevi.add(copil);
	}

	public void stergereCopil(Elev copil) {
		if(copiiElevi.contains(copil))
			copiiElevi.remove(copil);
		else
			System.out.println("Nu e al tau femeie!");
	}

	public void verificareNote() {
		for(Elev elev : copiiElevi) {
			System.out.println(elev.nume + ":");
			for (Materie materie : Materie.values()) {
				elev.getNoteElev(materie);
			}
			System.out.println("");
		}
	}
	
	public void verificareAbsente() {
		for(Elev elev : copiiElevi) {
			System.out.println(elev.nume + ": " + elev.getAbsente());
		}
	}

};
