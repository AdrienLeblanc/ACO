package fr.istic.m1.aco.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import client.Editeur;
import command.InsererCmd;
import invoker.IHMImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

public class HistoriqueImplTest {

	@Test
	public void testDefaire() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		HistoriqueImpl historique = new HistoriqueImpl(m);
		m.inserer("bonjour");
		m.selectionner(0,5);
		m.couper();
		historique.defaire();
		
		assertTrue(m.getTexte().toString().equals("bonjour"));
	}
}
