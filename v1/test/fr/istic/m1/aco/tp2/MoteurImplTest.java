package fr.istic.m1.aco.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import client.Editeur;
import receiver.MoteurImpl;

/**
 * @(#) MoteurImplTest.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class MoteurImplTest {

	@Test
	public void testCouper() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		m.setTexte(new StringBuffer("Ceci est un code de test"));
		m.setSelection(new int[]{3,8});
		m.couper();

		assertTrue(m.getTexte().toString().equals("Cec un code de test"));
		assertTrue(m.getPp().equals("i est"));
	}
	
	@Test
	public void testCouper2() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		m.setTexte(new StringBuffer("Ceci est un code de test"));
		m.setSelection(new int[]{0,24});
		m.couper();
		
		assertTrue(m.getTexte().toString().equals(""));
		assertTrue(m.getPp().equals("Ceci est un code de test"));
	}

	@Test
	public void testCopier() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		m.setTexte(new StringBuffer("Ceci est un code de test"));
		m.setSelection(new int[]{3,8});
		m.copier();

		assertTrue(m.getPp().equals("i est"));
	}

	@Test
	public void testColler() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		m.setTexte(new StringBuffer("Ceci est un code de test"));
		m.setPp("azertyuiop");
		m.setSelection(new int[]{3,8});
		m.coller();

		assertTrue(m.getTexte().toString().equals("Cecazertyuiop un code de test"));
	}

	@Test
	public void testInserer() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		m.inserer("Ceci est un code de test");
		m.setSelection(new int[]{3,8});
		m.inserer("azertyuiop");
		
		assertTrue(m.getTexte().toString().equals("Cecazertyuiop un code de test"));
	}

	@Test
	public void testSelectionner() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		m.setTexte(new StringBuffer("Ceci est un code de test"));
		m.selectionner(-8,5);
		assertTrue(m.getDebut() == 0 && m.getFin() == 5);
		
		m.selectionner(-8,-5);
		assertTrue(m.getDebut() == 0 && m.getFin() == 0);
		
		m.selectionner(100,500);
		assertTrue(m.getDebut() == 24 && m.getFin() == 24);
		
		m.selectionner(500,-8);
		assertTrue(m.getDebut() == 0 && m.getFin() == 24);
		
		m.selectionner(2,1);
		assertTrue(m.getDebut() == 1 && m.getFin() == 2);
	}
}
