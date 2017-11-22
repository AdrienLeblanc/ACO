package command;

import receiver.EnregistreurImpl;
/**
 * @(#) DemarrerEgt.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class DemarrerEgt implements Command {

	private final EnregistreurImpl enregistreur;
	
	public DemarrerEgt(EnregistreurImpl enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.demarrer();
	}

}
