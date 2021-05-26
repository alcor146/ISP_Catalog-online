package tema1reloaded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Profesor_Notare_Test {

	@Test
	void testVerificareNota() {
		Profesor p = new Profesor("Ioana","1099123456",723456l, false,"",Materie.Chimie);
		
		assertTrue(p.verificareNota(1));
		assertTrue(p.verificareNota(10));
		assertTrue(p.verificareNota(6));
		
		assertFalse(p.verificareNota(0));
		assertFalse(p.verificareNota(12));
		assertFalse(p.verificareNota(-2));
		assertFalse(p.verificareNota(13));
			
	}

	@Test
	void testSePoateMotivaAbsenta() {
		Profesor p = new Profesor("Ioana","1099123456",723456l, false,"",Materie.Chimie);
		Grupa g1 = new Grupa("clasa_1");
		Parinte Ion = new Parinte("Ion","568768776", 12342132);

		Elev e1 = new Elev("Orel", "505050",123456789, g1, Ion );
		Elev e2 = new Elev("Gonzo", "505051",123456989, g1, Ion );
		Elev e3 = new Elev("Urelul", "505052",123476789, g1, Ion );
		g1.adaugareElev(e1);
		g1.adaugareElev(e2);
		g1.adaugareElev(e3);
		
		g1.adaugareAbsenta(e1, 0);
		g1.adaugareAbsenta(e2, 1);
		g1.adaugareAbsenta(e3, 23);
		
		assertTrue(p.sePoateMotivaAbsenta(g1, e3));
		assertTrue(p.sePoateMotivaAbsenta(g1, e2));
		
		assertFalse(p.sePoateMotivaAbsenta(g1, e1));
	}

	@Test
	void testIsDiriginte() {
	Grupa g1 = new Grupa("clasa_1");
	Grupa g2 = new Grupa("clasa_2");
	Grupa g3 = new Grupa("clasa_3");
	Profesor p = new Profesor("Ioana","1099123456",723456l, true,"clasa_2",Materie.Chimie);

	assertTrue(p.isDiriginte(g2));
	
	assertFalse(p.isDiriginte(g1));
	assertFalse(p.isDiriginte(g3));
	}

	@Test
	void testExistaElevInGrupa() {
		Grupa g1 = new Grupa("clasa_1");
		Grupa g2 = new Grupa("clasa_2");
		Grupa g3 = new Grupa("clasa_3");
		Parinte Ion = new Parinte("Ion","568768776", 12342132);

		Profesor p = new Profesor("Ioana","1099123456",723456l, true,"clasa_1",Materie.Istorie);
		
		Elev e1 = new Elev("Orel", "505050",123456789, g1, Ion );
		Elev e2 = new Elev("Gonzo", "505051",123456989, g2, Ion );
		Elev e3 = new Elev("Urelul", "505052",123476789, g2, Ion );
		
		g1.adaugareElev(e1);
		g2.adaugareElev(e2);
		g2.adaugareElev(e3);
		
		assertTrue(p.existaElevInGrupa(e1,g1));
		assertTrue(p.existaElevInGrupa(e2,g2));
		assertTrue(p.existaElevInGrupa(e3,g2));
		
		assertFalse(p.existaElevInGrupa(e1,g2));
		assertFalse(p.existaElevInGrupa(e1,g3));
		assertFalse(p.existaElevInGrupa(e2,g1));
		assertFalse(p.existaElevInGrupa(e3,g1));
		
		assertFalse(p.existaElevInGrupa(e1,g3));
		assertFalse(p.existaElevInGrupa(e2,g3));
		assertFalse(p.existaElevInGrupa(e3,g3));

	}

	@Test
	void testPredaLaGrupa() {
		Grupa g1 = new Grupa("clasa_1");
		Grupa g2 = new Grupa("clasa_2");
		Grupa g3 = new Grupa("clasa_3");
		Grupa g4 = new Grupa("clasa_4");
		Grupa g5 = new Grupa("clasa_5");
		
		Profesor p = new Profesor("Ioana","1099123456",723456l, false,"",Materie.Chimie);
		p.adaugaGrupaLaCarePreda(g1);
		p.adaugaGrupaLaCarePreda(g2);
		p.adaugaGrupaLaCarePreda(g3);
		
		assertFalse(p.predaLaGrupa(g5));
		assertFalse(p.predaLaGrupa(g4));
		
		assertTrue(p.predaLaGrupa(g1));
		assertTrue(p.predaLaGrupa(g2));
		assertTrue(p.predaLaGrupa(g3));

	}

}
