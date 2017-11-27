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

	private MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	private final HistoriqueImpl historique;
		
	public CopierCmd(MoteurImpl engine, EnregistreurImpl enregistreur, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
	}

	@Override
	public void execute() {
		this.engine = historique.getEngine();
		if (this.enregistreur.getAdemarre()) {
			MememtoCopier mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		this.historique.addExecution(this.create());
		this.engine.copier();
	}
	
	public MememtoCopier create() {
		return new MememtoCopier();
	}

	class MememtoCopier implements Mememto {
				
		public MememtoCopier() { }
		
		@Override
		public void setMememto() {
		}
		
		public MoteurImpl getEngine() {
			return engine;
		}
		
		public CopierCmd getCommand() {
			CopierCmd cmd = new CopierCmd(historique.getEngine(), enregistreur, historique);
			return cmd;
		}
	}
	
}
