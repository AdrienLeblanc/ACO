package client;

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
		MoteurImpl engine = new MoteurImpl(null, new StringBuffer());
		Editeur editeur = new Editeur(engine, ihm);
		engine.setEditeur(editeur);
		
		/* _________________________ */
		/* __________TESTS__________ */
		/* _________________________ */
		
		/* BUT de la série de commandes : Dupliquer au debut de la chaine de caractere la toute premiere lettre */

		/* Une commande inserer */
		InsererCmd inserer = new InsererCmd(engine, ihm);
		inserer.execute();

		/* Une commande selectionner */
		SelectionnerCmd selectionner = new SelectionnerCmd(engine, 0, 1);
		selectionner.execute();

		/* Une commande copier */
		CopierCmd copier = new CopierCmd(engine);
		copier.execute();

		/* Une commande selectionner */
		SelectionnerCmd selectionner2 = new SelectionnerCmd(engine, 0, 0);
		selectionner2.execute();

		/* Une commande coller */
		CollerCmd coller = new CollerCmd(engine);
		coller.execute();

		System.out.println(engine.getTexte());
		
		/* Une commande couper */
		CouperCmd couper = new CouperCmd(engine);
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
