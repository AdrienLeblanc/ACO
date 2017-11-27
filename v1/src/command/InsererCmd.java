package command;

import invoker.IHMImpl;
import receiver.MoteurImpl;


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
