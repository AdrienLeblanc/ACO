package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.MoteurImpl;


public class SelectionnerCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;

	private int debut, fin;

	public SelectionnerCmd(MoteurImpl engine, EnregistreurImpl enregistreur, int debut, int fin) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.debut = debut;
		this.fin = fin;
	}

	@Override
	public void execute() {
		if (this.enregistreur.getAdemarre()) {
			MememtoSelectionner mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		this.engine.selectionner(this.debut, this.fin);
	}
	
	public MememtoSelectionner create() {
		return new MememtoSelectionner();
	}

	class MememtoSelectionner implements Mememto {

		private MoteurImpl engineMememto;
		
		private int debutMememto, finMememto;

		public MememtoSelectionner() { }

		@Override
		public void setMememto() {
			this.engineMememto = engine;
			this.debutMememto = debut;
			this.finMememto = fin;
		}

		public SelectionnerCmd getCommand() {
			SelectionnerCmd cmd = new SelectionnerCmd(this.engineMememto, enregistreur, this.debutMememto, this.finMememto);
			return cmd;
		}
	}

}