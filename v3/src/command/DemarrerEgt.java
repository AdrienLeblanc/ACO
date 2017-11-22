package command;

import receiver.EnregistreurImpl;
<<<<<<< HEAD:v3/src/command/DemarrerEgt.java
import receiver.HistoriqueImpl;
/**
 * @(#) DemarrerEgt.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
=======
/**
 * @(#) DemarrerEgt.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
>>>>>>> dc37de6ae232b2a29cae71d4512d1042f4381bab:v2/src/command/DemarrerEgt.java
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
