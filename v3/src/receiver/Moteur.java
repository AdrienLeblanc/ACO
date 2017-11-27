package receiver;


/**
 * @(#) Moteur.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public interface Moteur {
	
	public void couper();
	
	public void copier();
	
	public void coller();
	
	public void inserer(String s);
	
	public void selectionner(int debut, int fin);


}
