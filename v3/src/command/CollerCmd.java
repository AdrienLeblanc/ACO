package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * @(#) CollerCmd.java
 * Commande permettant de coller ce qui est dans le presse papier à un endroit donné
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class CollerCmd implements Command {

	private MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	private final HistoriqueImpl historique;
	
	public CollerCmd(MoteurImpl engine, EnregistreurImpl enregistreur, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
	}

	@Override
	public void execute() {
		this.engine = historique.getEngine();
		if (this.enregistreur.getAdemarre()) {
			MememtoColler mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		this.historique.addExecution(this.create());
		this.engine.coller();
	}
	
	public MememtoColler create() {
		return new MememtoColler();
	}

	class MememtoColler implements Mememto {


		public MememtoColler() { }

		@Override
		public void setMememto() {
		}
		
		public MoteurImpl getEngine() {
			return engine;
		}

		public CollerCmd getCommand() {
			CollerCmd cmd = new CollerCmd(historique.getEngine(), enregistreur, historique);
			return cmd;
		}
	}

}
