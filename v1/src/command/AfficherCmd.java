package command;

import receiver.MoteurImpl;

/**
 * @(#) AfficherCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
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
