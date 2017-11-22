package client;

import command.AfficherCmd;
import command.CollerCmd;
import command.CopierCmd;
import command.CouperCmd;
import command.DemarrerEgt;
import command.InsererCmd;
import command.RejouerEgt;
import command.SelectionnerCmd;
import command.StopperEgt;
import invoker.IHM;
import invoker.IHMImpl;
import receiver.EnregistreurImpl;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * @(#) Editeur.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 du projet mini-editeur
 */

public class Editeur {
	
	private Moteur engine;

	private IHM ihm;

	public Editeur(Moteur engine, IHM ihm) {
		this.setEngine(engine);
		this.setIhm(ihm);
	}

	public static void main(String[] args) {

		/* Initialisations */
		IHMImpl ihm = new IHMImpl();
		MoteurImpl engine = new MoteurImpl(null, new StringBuffer(""));
		Editeur editeur = new Editeur(engine, ihm);
		engine.setEditeur(editeur);
		EnregistreurImpl enregistreur = new EnregistreurImpl();
		
		InsererCmd inserer = new InsererCmd(engine, enregistreur, ihm, null);
		SelectionnerCmd selectionner = new SelectionnerCmd(engine, enregistreur, 0, 0);
		CopierCmd copier = new CopierCmd(engine, enregistreur);
		CollerCmd coller = new CollerCmd(engine, enregistreur);
		CouperCmd couper = new CouperCmd(engine, enregistreur);
		AfficherCmd afficher = new AfficherCmd(engine);
		DemarrerEgt demarrer = new DemarrerEgt(enregistreur);
		StopperEgt stopper = new StopperEgt(enregistreur);
		RejouerEgt rejouer = new RejouerEgt(enregistreur);
		
		ihm.addCommand("inserer", inserer);
		ihm.addCommand("selectionner", selectionner);
		ihm.addCommand("copier", copier);
		ihm.addCommand("couper", couper);
		ihm.addCommand("coller", coller);
		ihm.addCommand("afficher", afficher);
		ihm.addCommand("demarrer", demarrer);
		ihm.addCommand("stopper", stopper);
		ihm.addCommand("rejouer", rejouer);
		ihm.start();
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
