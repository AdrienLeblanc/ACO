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

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	@Override
	public void execute() {
		engine.selectionner(debut, fin);
	}
	
}
