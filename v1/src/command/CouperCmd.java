package command;

import receiver.MoteurImpl;

/**
 * @(#) CouperCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class CouperCmd implements Command {

	private final MoteurImpl engine;

	public CouperCmd(MoteurImpl engine) {
		this.engine = engine;
	}

	@Override
	public void execute() {
		engine.couper();
	}
	
}
