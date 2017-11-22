package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * @(#) CopierCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class CopierCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	private final HistoriqueImpl historique;
		
	public CopierCmd(MoteurImpl engine, EnregistreurImpl enregistreur, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
	}

	@Override
	public void execute() {
		if (this.enregistreur.getAdemarre()) {
			MememtoCopier mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		historique.addExecution(this.create());
		historique.addEtatsMoteur(this.engine);
		this.engine.copier();
	}
	
	public MememtoCopier create() {
		return new MememtoCopier();
	}

	class MememtoCopier implements Mememto {
		
		private MoteurImpl engineMememto;
		
		public MememtoCopier() { }
		
		@Override
		public void setMememto() {
			this.engineMememto = engine;
		}
		
		public CopierCmd getCommand() {
			CopierCmd cmd = new CopierCmd(this.engineMememto, enregistreur, historique);
			return cmd;
		}
	}
}
