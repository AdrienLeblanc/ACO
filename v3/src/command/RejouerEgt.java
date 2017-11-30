package command;

import receiver.EnregistreurImpl;

/**
 * @(#) RejouerEgt.java
 * Permet de rejouer un moment qui a été enregistré
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
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
