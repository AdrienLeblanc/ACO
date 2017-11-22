package command;

import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
/**
 * @(#) DemarrerEgt.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
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
