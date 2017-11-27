package receiver;


/**
 * @(#) Moteur.java
 */
public interface Moteur {
	
	public void couper();
	
	public void copier();
	
	public void coller();
	
	public void inserer(String s);
	
	public void selectionner(int debut, int fin);


}
