package tema1reloaded;

public class Aplicatie {

	public static void main(String[] args) {
		
		Grupa g1 = new Grupa("clasa_1");
		
		Parinte Ion = new Parinte("Ion","568768776", 12342132);
		
		Elev e1 = new Elev("Orel", "505050",123456789, g1, Ion );
		Elev e2 = new Elev("Gonzo", "505051",123456989, g1, Ion );
		Elev e3 = new Elev("Urelul", "505052",123476789, g1, Ion );
		Elev e4 = new Elev("Gonzo the Boy", "505053",133456789, g1, Ion );
		g1.adaugareElev(e1);
		g1.adaugareElev(e2);
		g1.adaugareElev(e3);
		g1.adaugareElev(e4);
		g1.adaugareNota(e1, Materie.Biologie, 5);
		
		System.out.println(e1.areNoteLaMaterie(Materie.Biologie));
		System.out.println(e1.areNoteLaMaterie(Materie.Istorie));

		for(int i =0; i<5;i++) {
			g1.adaugareAbsenta(e1, i);
			g1.adaugareAbsenta(e2, i+3);
			g1.adaugareAbsenta(e3, i+1);
			g1.adaugareAbsenta(e4, i+2);
		}
		
		Director boss = new Director("Alexandrovici Petrovici Sthatovsky Dimiti Cuza Voda Verde Imparat Lord Taric","6669996669",22222);
		boss.adaugaGrupa(g1);
		
		boss.topAbsente("clasa_1");
	}

}
