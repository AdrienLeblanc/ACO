package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * @(#) CouperCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class CouperCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	private final HistoriqueImpl historique;
	
	public CouperCmd(MoteurImpl engine, EnregistreurImpl enregistreur, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
	}

	@Override
	public void execute() {
		if (this.enregistreur.getAdemarre()) {
			MememtoCouper mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		historique.addExecution(this.create());
		historique.addEtatsMoteur(this.engine);
		this.engine.couper();
	}
	
	public MememtoCouper create() {
		return new MememtoCouper();
	}
	
	class MememtoCouper implements Mememto {

		private MoteurImpl engineMememto;
		
		public MememtoCouper() { }
		
		@Override
		public void setMememto() {
			this.engineMememto = engine;
		}
		
		public CouperCmd getCommand() {
			CouperCmd cmd = new CouperCmd(this.engineMememto, enregistreur, historique);
			return cmd;
		}
	}

}
