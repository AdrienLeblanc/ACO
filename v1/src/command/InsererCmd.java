package command;

import invoker.IHMImpl;
import receiver.MoteurImpl;

/**
 * @(#) InsererCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class InsererCmd implements Command {

	private final MoteurImpl engine;

	private final IHMImpl ihm;

	private String input;

	public InsererCmd(MoteurImpl engine, IHMImpl ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}

	public void execute() {
		this.input = this.ihm.getText();
		engine.inserer(this.input);
	}

}
