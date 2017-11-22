package receiver;

/**
 * @(#) Moteur.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
<<<<<<< HEAD:v3/src/receiver/Moteur.java
 * @version 3.0 V3 du projet mini-editeur
=======
 * @version 1.0 V1 du projet mini-editeur
>>>>>>> dc37de6ae232b2a29cae71d4512d1042f4381bab:v1/src/receiver/Moteur.java
 */
public interface Moteur {
	
	public void couper();
	
	public void copier();
	
	public void coller();
	
	public void inserer(String s);
	
	public void selectionner(int debut, int fin);


}
