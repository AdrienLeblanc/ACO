package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * @(#) SelectionnerCmd.java
 * Commande permettant de selectionner une zone
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class SelectionnerCmd implements Command {

	private MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	private final HistoriqueImpl historique;

	private int debut, fin;

	public SelectionnerCmd(MoteurImpl engine, EnregistreurImpl enregistreur, int debut, int fin, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
		this.debut = debut;
		this.fin = fin;
	}

	@Override
	public void execute() {
		this.engine = historique.getEngine();
		if (this.enregistreur.getAdemarre()) {
			MememtoSelectionner mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		this.historique.addExecution(this.create());
		this.engine.selectionner(this.debut, this.fin);
	}
	
	public MememtoSelectionner create() {
		return new MememtoSelectionner();
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

	class MememtoSelectionner implements Mememto {

		
		private int debutMememto, finMememto;

		public MememtoSelectionner() { }

		@Override
		public void setMememto() {
			this.debutMememto = debut;
			this.finMememto = fin;
		}
		
		public MoteurImpl getEngine() {
			return engine;
		}

		public SelectionnerCmd getCommand() {
			SelectionnerCmd cmd = new SelectionnerCmd(historique.getEngine(), enregistreur, this.debutMememto, this.finMememto, historique);
			return cmd;
		}
	}

}