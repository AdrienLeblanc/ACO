package fr.istic.m1.aco.tp2;

import static org.junit.Assert.*;
import org.junit.Test;

import client.Editeur;
import command.CollerCmd;
import command.CopierCmd;
import command.SelectionnerCmd;
import receiver.EnregistreurImpl;
import receiver.MoteurImpl;

/**
 * @(#) EnregistreurImplTest.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class EnregistreurImplTest {

	@Test
	public void testDemarrer() {
		EnregistreurImpl er = new EnregistreurImpl();
		er.demarrer();
		assertTrue(er.getAdemarre());
	}
	
	@Test
	public void testDemarrer2() {
		EnregistreurImpl er = new EnregistreurImpl();
		er.demarrer();
		er.demarrer();
		assertTrue(er.getAdemarre());
	}
	
	@Test
	public void testDemarrer3() {
		EnregistreurImpl er = new EnregistreurImpl();
		er.demarrer();
		er.demarrer();
		er.demarrer();
		assertTrue(er.getAdemarre());
	}

	@Test
	public void testStopper() {
		EnregistreurImpl er = new EnregistreurImpl();
		er.stopper();
		assertTrue(!er.getAdemarre());
	}
	
	@Test
	public void testStopper2() {
		EnregistreurImpl er = new EnregistreurImpl();
		er.stopper();
		er.stopper();
		assertTrue(!er.getAdemarre());
	}
	
	@Test
	public void testStopper3() {
		EnregistreurImpl er = new EnregistreurImpl();
		er.stopper();
		er.stopper();
		er.stopper();
		assertTrue(!er.getAdemarre());
	}

	@Test
	public void testRejouer() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		EnregistreurImpl er = new EnregistreurImpl();
		e.setEngine(m);
		
		m.setTexte(new StringBuffer("Ceci est un code de test"));
		
		er.setAdemarre(true); 	/* demarrer */
		SelectionnerCmd selectionner = new SelectionnerCmd(m, er, 0, 4);
		CopierCmd copier = new CopierCmd(m, er);
		SelectionnerCmd selectionner2 = new SelectionnerCmd(m, er, 0, 0);
		CollerCmd coller = new CollerCmd(m, er);
		selectionner.execute();
		// "Ceci est un code de test"
		copier.execute();
		selectionner2.execute();
		coller.execute();
		// "CeciCeci est un code de test"
		er.setAdemarre(false); 	/* stopper */
		er.rejouer(); 			/* rejouer */
		// "CeciCeciCeci est un code de test"
		assertTrue(m.getTexte().toString().equals("CeciCeciCeci est un code de test"));
	}

}
