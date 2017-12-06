package receiver;

import client.Editeur;
import command.Command;
import mememto.Mememto;

/**
 * MoteurImpl.java
 * Classe permettant de faire des actions importantes telles que couper, copier, coller...
 * @author LEBLANC Adrien
 * @author BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class MoteurImpl implements Moteur {

	private Editeur editeur;

	private StringBuffer texte;

	private int[] sel; //   /!\/!\/!\ IMPORTANT : [debut, fin[  /!\/!\/!\

	private String pp;

	public MoteurImpl(Editeur editeur, StringBuffer texte) {
		this.editeur = editeur;
		this.texte = texte;
		this.sel = new int[]{0,0};
		this.pp = "";
	}

	/**
	 * Methode Couper
	 * Copie la selection dans le presse-papier, puis efface du texte la selection.
	 */
	public void couper() {
		fixSelection(sel[0], sel[1]);
		int borne_inf = sel[0];
		int borne_sup = sel[1];
		pp = "";
		for (int i = borne_inf; i < borne_sup; i++) {
			pp += texte.charAt(i);
		}
		for (int i = 0; i<(borne_sup-borne_inf);i++){
			texte.deleteCharAt(borne_inf);
		}
	}

	/**
	 * Methode Copier
	 * Copie la selection dans le presse-papier.
	 */
	public void copier() {
		fixSelection(sel[0], sel[1]);
		int borne_inf = sel[0];
		int borne_sup = sel[1];
		pp = "";
		for (int i = borne_inf; i < borne_sup; i++) {
			pp += texte.charAt(i);
		}
	}

	/**
	 * Methode Coller
	 * Colle le presse-papier dans le texte a la place de la selection.
	 */
	public void coller() {
		fixSelection(sel[0], sel[1]);
		inserer(pp);
	}

	/**
	 * Methode inserer
	 * Insere la chaine de cractere passee en parametre a la place de la selection.
	 * @param s : String, chaine de caractere a inserer
	 */
	public void inserer(String s) {
		fixSelection(sel[0], sel[1]);
		for (int i = 0; i < (sel[1] - sel[0]); i++){
			texte.deleteCharAt(sel[0]);
		}
		texte.insert(sel[0], s);
	}

	/**
	 * Methode selectionner
	 * Definit les deux bornes inferieures et superieures prevues pour selectionner du texte.
	 * @param debut : int, borne inferieure
	 * @param fin : int, borne superieure
	 */
	public void selectionner(int debut, int fin) {
		fixSelection(debut, fin);
	}
	
	/**
	 * Methode privee fixSelection
	 * Adapte correctement les deux bornes inferieures et superieures prevues pour selectionner du texte afin d'eviter des erreurs.
	 * @param debut : int, borne inferieure
	 * @param fin : int, borne superieure
	 */
	private void fixSelection(int debut, int fin) {
		if (debut < 0) debut = 0;
		if (fin < 0) fin = 0;
		if (debut > texte.length()) debut = texte.length();
		if (fin > texte.length()) fin = texte.length();
		if (debut > fin) {
			int tmp = fin;
			fin = debut;
			debut = tmp;
		}
		this.sel[0] = debut;
		this.sel[1] = fin;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public StringBuffer getTexte() {
		return texte;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public int[] getSelection() {
		return this.sel;
	}

	public void setSelection(int[] sel) {
		this.sel = sel;
	}

	public void setTexte(StringBuffer texte) {
		this.texte = texte;
	}

	public int getDebut() {
		return sel[0];
	}

	public int getFin() {
		return sel[1];
	}

	public void afficher() {
		System.out.println(texte);
	}
	
	public MememtoMoteur create() {
		return new MememtoMoteur();
	}

	/**
	 * MementoMoteur
	 * Memento permettant d'enregistrer l'etat du moteur a un instant t
	 * */
	class MememtoMoteur implements Mememto {
		
		private MoteurImpl engineMememto;

		public MememtoMoteur() {
			this.setEngine();
		}

		@Override
		public void setMememto() { }

		public void setEngine() {
			this.engineMememto = new MoteurImpl(editeur, new StringBuffer(texte.toString()));
			this.engineMememto.setPp(pp);
			this.engineMememto.setSelection(sel);
		}
		
		public MoteurImpl getEngine() {
			return this.engineMememto;
		}

		@Override
		public Command getCommand() { return null; }
	}
}
