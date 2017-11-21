package command;

import receiver.EnregistreurImpl;

/**
 * @(#) RejouerEgt.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class RejouerEgt implements Command {
	
	private final EnregistreurImpl enregistreur;
	
	public RejouerEgt(EnregistreurImpl enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.rejouer();
	}

}
