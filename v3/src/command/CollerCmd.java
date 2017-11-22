package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * @(#) CollerCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class CollerCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	private final HistoriqueImpl historique;
	
	public CollerCmd(MoteurImpl engine, EnregistreurImpl enregistreur, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
	}

	@Override
	public void execute() {
		if (this.enregistreur.getAdemarre()) {
			MememtoColler mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		historique.addExecution(this.create());
		historique.addEtatsMoteur(this.engine);
		this.engine.coller();
	}
	
	public MememtoColler create() {
		return new MememtoColler();
	}

	class MememtoColler implements Mememto {

		private MoteurImpl engineMememto;

		public MememtoColler() { }

		@Override
		public void setMememto() {
			this.engineMememto = engine;
		}

		public CollerCmd getCommand() {
			CollerCmd cmd = new CollerCmd(this.engineMememto, enregistreur, historique);
			return cmd;
		}
	}

}
