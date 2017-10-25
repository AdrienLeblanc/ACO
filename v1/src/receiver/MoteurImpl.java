package receiver;

import client.Editeur;


public class MoteurImpl implements Moteur {

	private Editeur editeur;

	private StringBuffer texte;

	private int[] sel; //   /!\/!\/!\ IMPORTANT : [debut, fin[  /!\/!\/!\

	private String pp;

	public MoteurImpl(Editeur editeur, StringBuffer texte) {
		this.editeur = editeur;
		this.texte = texte;
		this.sel = new int[2];
		this.pp = "";
	}

	/**
	 * copie la selection dans le pp
	 * efface la selection du texte
	 */
	public void couper() {
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
	 * copie la selection dans le pp
	 */
	public void copier() {
		int borne_inf = sel[0];
		int borne_sup = sel[1];
		pp = "";
		for (int i = borne_inf; i < borne_sup; i++) {
			pp += texte.charAt(i);
		}
	}

	/**
	 * colle contenu de pp dans la selection
	 */
	public void coller() {
		inserer(pp);
	}

	/**
	 * colle le parametre a la place de la selection
	 */
	public void inserer(String s) {
		for (int i = 0; i < (sel[1] - sel[0]); i++){
			texte.deleteCharAt(sel[0]);
		}
		texte.insert(sel[0], s);
	}

	/**
	 * initialise les bornes inf et sup
	 */
	public void selectionner(int debut, int fin) {
		if (debut < 0) debut = 0;
		if (fin < 0) fin = 0;
		if (debut > texte.length()) debut = texte.length();
		if (fin > texte.length()) fin = texte.length();
		if (debut > fin) {
			int tmp = fin;
			fin = debut;
			debut = tmp;
		}
		sel[0] = debut;
		sel[1] = fin;
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
}
