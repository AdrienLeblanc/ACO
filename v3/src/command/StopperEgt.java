package command;

import receiver.EnregistreurImpl;

public class StopperEgt implements Command {

/**
 * StopperEgt.java
 * Commande permettant de stopper un enregistrement
 * @author LEBLANC Adrien
 * @author BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
private final EnregistreurImpl enregistreur;
	
	public StopperEgt(EnregistreurImpl enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.stopper();
	}

}