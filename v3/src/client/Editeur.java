package client;

import command.AfficherCmd;
import command.CollerCmd;
import command.CopierCmd;
import command.CouperCmd;
import command.DefaireCmd;
import command.DemarrerEgt;
import command.InsererCmd;
import command.RefaireCmd;
import command.RejouerEgt;
import command.SelectionnerCmd;
import command.StopperEgt;
import invoker.IHM;
import invoker.IHMImpl;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * @(#) Editeur.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
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
		HistoriqueImpl historique = new HistoriqueImpl(engine);
		InsererCmd inserer = new InsererCmd(historique.getEngine(), enregistreur, ihm, null, historique);
		SelectionnerCmd selectionner = new SelectionnerCmd(historique.getEngine(), enregistreur, 0, 0, historique);
		CopierCmd copier = new CopierCmd(historique.getEngine(), enregistreur, historique);
		CollerCmd coller = new CollerCmd(historique.getEngine(), enregistreur, historique);
		CouperCmd couper = new CouperCmd(historique.getEngine(), enregistreur, historique);
		AfficherCmd afficher = new AfficherCmd(historique);
		DemarrerEgt demarrer = new DemarrerEgt(enregistreur);
		StopperEgt stopper = new StopperEgt(enregistreur);
		RejouerEgt rejouer = new RejouerEgt(enregistreur);
		DefaireCmd defaire = new DefaireCmd(historique);
		RefaireCmd refaire = new RefaireCmd(historique);
		
		ihm.addCommand("inserer", inserer);
		ihm.addCommand("selectionner", selectionner);
		ihm.addCommand("copier", copier);
		ihm.addCommand("couper", couper);
		ihm.addCommand("coller", coller);
		ihm.addCommand("afficher", afficher);
		ihm.addCommand("demarrer", demarrer);
		ihm.addCommand("stopper", stopper);
		ihm.addCommand("rejouer", rejouer);
		ihm.addCommand("defaire", defaire);
		ihm.addCommand("refaire", refaire);
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
