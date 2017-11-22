package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * @(#) SelectionnerCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
<<<<<<< HEAD:v3/src/command/SelectionnerCmd.java
 * @version 3.0 V3 du projet mini-editeur
=======
 * @version 1.0 V1 du projet mini-editeur
>>>>>>> dc37de6ae232b2a29cae71d4512d1042f4381bab:v2/src/command/SelectionnerCmd.java
 */
public class SelectionnerCmd implements Command {

	private final MoteurImpl engine;
	
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
		if (this.enregistreur.getAdemarre()) {
			MememtoSelectionner mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		historique.addExecution(this.create());
		historique.addEtatsMoteur(this.engine);
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
			SelectionnerCmd cmd = new SelectionnerCmd(this.engineMememto, enregistreur, this.debutMememto, this.finMememto, historique);
			return cmd;
		}
	}

}