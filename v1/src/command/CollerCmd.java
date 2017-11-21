package command;

import receiver.MoteurImpl;

/**
 * @(#) CollerCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class CollerCmd implements Command {

	private final MoteurImpl engine;

	public CollerCmd(MoteurImpl engine) {
		this.engine = engine;
	}

	@Override
	public void execute() {
		engine.coller();
	}
	
}
