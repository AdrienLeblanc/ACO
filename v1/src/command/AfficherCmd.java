package command;

import receiver.MoteurImpl;


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
