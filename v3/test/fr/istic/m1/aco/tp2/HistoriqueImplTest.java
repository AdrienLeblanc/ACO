package fr.istic.m1.aco.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import client.Editeur;
import command.CollerCmd;
import command.CouperCmd;
import command.DefaireCmd;
import command.InsererCmd;
import command.RefaireCmd;
import command.SelectionnerCmd;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

public class HistoriqueImplTest {

	@Test
	public void testDefaire() {
		Editeur editeur = new Editeur(null, null);
		StringBuffer texte = new StringBuffer();
		MoteurImpl engine = new MoteurImpl(editeur, texte);
		EnregistreurImpl enregistreur = new EnregistreurImpl();
		editeur.setEngine(engine);
		HistoriqueImpl historique = new HistoriqueImpl(engine);
		
		InsererCmd inserer = new InsererCmd(historique.getEngine(), enregistreur, null, "bonjour", historique);
		inserer.execute();
		SelectionnerCmd selectionner = new SelectionnerCmd(engine, enregistreur, 0, 4, historique);
		selectionner.execute();
		CouperCmd couper = new CouperCmd(historique.getEngine(), enregistreur, historique);
		couper.execute();
		
		DefaireCmd defaire = new DefaireCmd(historique);
		defaire.execute();
		
		assertTrue(historique.getEngine().getTexte().toString().equals("bonjour"));
	}

	@Test
	public void testDefaire2() {
		Editeur editeur = new Editeur(null, null);
	 	StringBuffer texte = new StringBuffer();
	 	MoteurImpl engine = new MoteurImpl(editeur, texte);
	 	EnregistreurImpl enregistreur = new EnregistreurImpl();
	 	editeur.setEngine(engine);
	 	HistoriqueImpl historique = new HistoriqueImpl(engine);
	 	
	 	InsererCmd inserer = new InsererCmd(historique.getEngine(), enregistreur, null, "bonjour", historique);
	 	inserer.execute();
	 	SelectionnerCmd selectionner = new SelectionnerCmd(engine, enregistreur, 0, 4, historique);
	 	selectionner.execute();
	 	CouperCmd couper = new CouperCmd(historique.getEngine(), enregistreur, historique);
	 	couper.execute();
	 	SelectionnerCmd selectionner2 = new SelectionnerCmd(engine, enregistreur, 0, 0, historique);
	 	selectionner2.execute();
	 	CollerCmd coller = new CollerCmd(historique.getEngine(), enregistreur, historique);
	 	coller.execute();
	 	
	 	DefaireCmd defaire = new DefaireCmd(historique);
	 	defaire.execute();
	 	defaire.execute();
	 	defaire.execute();
	 	
	 	assertTrue(historique.getEngine().getTexte().toString().equals("bonjour"));
	 }
	 
	 @Test
	 public void testRefaire() {
	 	Editeur editeur = new Editeur(null, null);
	 	StringBuffer texte = new StringBuffer();
	 	MoteurImpl engine = new MoteurImpl(editeur, texte);
	 	EnregistreurImpl enregistreur = new EnregistreurImpl();
	 	editeur.setEngine(engine);
	 	HistoriqueImpl historique = new HistoriqueImpl(engine);
	 	
	 	InsererCmd inserer = new InsererCmd(historique.getEngine(), enregistreur, null, "bonjour", historique);
	 	inserer.execute();
	 	SelectionnerCmd selectionner = new SelectionnerCmd(engine, enregistreur, 0, 4, historique);
	 	selectionner.execute();
	 	CouperCmd couper = new CouperCmd(historique.getEngine(), enregistreur, historique);
	 	couper.execute();
	 	
	 	DefaireCmd defaire = new DefaireCmd(historique);
	 	defaire.execute();
	 	
	 	RefaireCmd refaire = new RefaireCmd(historique);
	 	refaire.execute();
	 	
	 	assertTrue(historique.getEngine().getTexte().toString().equals("our"));
	 }
	 
	 @Test
	 public void testRefaire2() {
	 	Editeur editeur = new Editeur(null, null);
	 	StringBuffer texte = new StringBuffer();
	 	MoteurImpl engine = new MoteurImpl(editeur, texte);
	 	EnregistreurImpl enregistreur = new EnregistreurImpl();
	 	editeur.setEngine(engine);
	 	HistoriqueImpl historique = new HistoriqueImpl(engine);
	 	
	 	InsererCmd inserer = new InsererCmd(historique.getEngine(), enregistreur, null, "bonjour", historique);
	 	inserer.execute();
	 	SelectionnerCmd selectionner = new SelectionnerCmd(engine, enregistreur, 0, 4, historique);
	 	selectionner.execute();
	 	CouperCmd couper = new CouperCmd(historique.getEngine(), enregistreur, historique);
	 	couper.execute();
	 	
	 	RefaireCmd refaire = new RefaireCmd(historique);
	 	refaire.execute();
	 	
	 	assertTrue(historique.getEngine().getTexte().toString().equals("our"));
	 }
}

