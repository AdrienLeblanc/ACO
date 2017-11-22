package command;

import receiver.MoteurImpl;

/**
 * @(#) AfficherCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
<<<<<<< HEAD:v3/src/command/AfficherCmd.java
 * @version 3.0 V3 du projet mini-editeur
=======
 * @version 1.0 V1 du projet mini-editeur
>>>>>>> dc37de6ae232b2a29cae71d4512d1042f4381bab:v2/src/command/AfficherCmd.java
 */
public class AfficherCmd implements Command {

	private final MoteurImpl engine;

	public AfficherCmd(MoteurImpl engine) {
		this.engine = engine;
	}

	@Override
	public void execute() {
		this.engine.afficher();
	}
	
}
