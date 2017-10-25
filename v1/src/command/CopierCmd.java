package command;

import receiver.MoteurImpl;


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
