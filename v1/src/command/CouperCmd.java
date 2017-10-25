package command;

import receiver.MoteurImpl;


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
