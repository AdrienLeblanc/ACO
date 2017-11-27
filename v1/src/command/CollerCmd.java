package command;

import receiver.MoteurImpl;


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
