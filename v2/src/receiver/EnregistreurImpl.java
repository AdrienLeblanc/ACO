package receiver;

import java.util.ArrayList;

import command.Command;
import mememto.Mememto;

/**
 * @(#) EnregistreurImpl.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class EnregistreurImpl implements Enregistreur {
	
	ArrayList<Mememto> list = new ArrayList<Mememto>();
	
	private boolean ademarre = false;
		
	public EnregistreurImpl() { }

	/**
	 * Methode demarrer
	 * Signale le demarrage de l'enregistrement.
	 */
	@Override
	public void demarrer() {
		setAdemarre(true);
	}

	/**
	 * Methode stopper
	 * Signale l'arret de l'enregistrement.
	 */
	@Override
	public void stopper() {
		setAdemarre(false);
	}

	/**
	 * Methode rejouer
	 * Execute dans l'ordre chaque commande enregistree
	 */
	@Override
	public void rejouer() {
		for (Mememto m : this.list) {
			Command cmd = m.getCommand();
			cmd.execute();
		}
	}
	
	/**
	 * Methode addMememto
	 * Ajoute un Mememto a l'enregistrement.
	 * @param m : Mememto
	 */
	public void addMememto(Mememto m) {
		list.add(m);
	}
	
	public boolean getAdemarre() {
		return ademarre;
	}

	public void setAdemarre(boolean ademarre) {
		this.ademarre = ademarre;
	}
	
}
