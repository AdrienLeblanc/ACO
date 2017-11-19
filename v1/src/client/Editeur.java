package client;

import command.AfficherCmd;
import command.CollerCmd;
import command.CopierCmd;
import command.CouperCmd;
import command.InsererCmd;
import command.SelectionnerCmd;
import invoker.IHM;
import invoker.IHMImpl;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * @(#) Editeur.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */

public class Editeur {
	
	private Moteur engine;

	private IHM ihm;

	public static void main(String[] args) {
		
		/* Initialisations */
		IHMImpl ihm = new IHMImpl();
		MoteurImpl engine = new MoteurImpl(null, new StringBuffer(""));
		Editeur editeur = new Editeur(engine, ihm);
		engine.setEditeur(editeur);
		
		InsererCmd inserer = new InsererCmd(engine, ihm);
		SelectionnerCmd selectionner = new SelectionnerCmd(engine, 0, 0);
		CopierCmd copier = new CopierCmd(engine);
		CollerCmd coller = new CollerCmd(engine);
		CouperCmd couper = new CouperCmd(engine);
		AfficherCmd afficher = new AfficherCmd(engine);
		
		ihm.addCommand("inserer", inserer);
		ihm.addCommand("selectionner", selectionner);
		ihm.addCommand("copier", copier);
		ihm.addCommand("couper", couper);
		ihm.addCommand("coller", coller);
		ihm.addCommand("afficher", afficher);
		ihm.start();
	}

	public Editeur(Moteur engine, IHM ihm) {
		this.setEngine(engine);
		this.setIhm(ihm);
	}

	public IHM getIhm() {
		return ihm;
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

	public Moteur getEngine() {
		return engine;
	}

	public void setEngine(Moteur engine) {
		this.engine = engine;
	}

}
