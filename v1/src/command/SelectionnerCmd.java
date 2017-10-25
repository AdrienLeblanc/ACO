package command;

import receiver.MoteurImpl;


public class SelectionnerCmd implements Command {

	private final MoteurImpl engine;

	private int debut, fin;

	public SelectionnerCmd(MoteurImpl engine, int debut, int fin) {
		this.engine = engine;
		this.debut = debut;
		this.fin = fin;
	}

	@Override
	public void execute() {
		engine.selectionner(debut, fin);
	}
	
}
