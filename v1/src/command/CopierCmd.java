package command;

import receiver.MoteurImpl;

/**
 * @(#) CopierCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class CopierCmd implements Command {

	private final MoteurImpl engine;

	public CopierCmd(MoteurImpl engine) {
		this.engine = engine;
	}

	@Override
	public void execute() {
		engine.copier();
	}
	
}
