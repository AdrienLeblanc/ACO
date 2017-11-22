package command;

import receiver.EnregistreurImpl;

/**
 * @(#) RejouerEgt.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
<<<<<<< HEAD:v3/src/command/RejouerEgt.java
 * @version 3.0 V3 du projet mini-editeur
=======
 * @version 1.0 V1 du projet mini-editeur
>>>>>>> dc37de6ae232b2a29cae71d4512d1042f4381bab:v2/src/command/RejouerEgt.java
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
