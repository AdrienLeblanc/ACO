package client;

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
		MoteurImpl engine = new MoteurImpl(null, new StringBuffer());
		Editeur editeur = new Editeur(engine, ihm);
		engine.setEditeur(editeur);
		EnregistreurImpl enregistreur = new EnregistreurImpl();
		
		/* _________________________ */
		/* __________TESTS__________ */
		/* _________________________ */
		
		/* BUT de la macro : Réécrire le mot en ayant dupliqué au debut de la chaine de caractere la toute premiere lettre */
		
		/* On démarre la macro */
		DemarrerEgt demarrer = new DemarrerEgt(enregistreur);
		demarrer.execute();
		
		/* Une commande inserer */
		InsererCmd inserer = new InsererCmd(engine, enregistreur, ihm, null);
		inserer.execute();
		
		/* Une commande selectionner */
		SelectionnerCmd selectionner = new SelectionnerCmd(engine, enregistreur, 0, 1);
		selectionner.execute();
		
		/* Une commande copier */
		CopierCmd copier = new CopierCmd(engine, enregistreur);
		copier.execute();
		
		/* Une commande selectionner */
		SelectionnerCmd selectionner2 = new SelectionnerCmd(engine, enregistreur, 0, 0);
		selectionner2.execute();
		
		/* Une commande coller */
		CollerCmd coller = new CollerCmd(engine, enregistreur);
		coller.execute();
		
		System.out.println(engine.getTexte());
				
		/* On stoppe la macro */
		StopperEgt stopper = new StopperEgt(enregistreur);
		stopper.execute();
		
		/* On rejoue la macro */
		RejouerEgt rejouer = new RejouerEgt(enregistreur);
		rejouer.execute();
		rejouer.execute();
		rejouer.execute();
		
		System.out.println(engine.getTexte());
		
		/* Une commande couper */
		CouperCmd couper = new CouperCmd(engine, enregistreur);
		couper.execute();

		/* _________________________ */
		/* ______FIN_DES_TESTS______ */
		/* _________________________ */
		
		ihm.addCommand("inserer", inserer);
		ihm.addCommand("selectionner", selectionner);
		ihm.addCommand("copier", copier);
		ihm.addCommand("couper", couper);
		ihm.addCommand("selectionner2", selectionner2);
		ihm.addCommand("coller", coller);
		
		/* Reinitialisation engine */
		engine.setTexte(new StringBuffer(""));
		engine.setPp("");
		engine.setSelection(new int[]{0,0});
		
		/* Terminal */
		ihm.terminal();
		
		/* Resultat de ce qu'on a fait avec le terminal */
		System.out.println(engine.getTexte());
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
