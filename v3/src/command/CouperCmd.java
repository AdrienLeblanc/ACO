package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * CouperCmd.java
 * Commande permettant de couper une portion de texte selectionnee auparavant
 * @author LEBLANC Adrien
 * @author BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class CouperCmd implements Command {

	private MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	private final HistoriqueImpl historique;
	
	public CouperCmd(MoteurImpl engine, EnregistreurImpl enregistreur, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
	}

	@Override
	public void execute() {
		this.engine = historique.getEngine();
		if (this.enregistreur.getAdemarre()) {
			MememtoCouper mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		this.historique.addExecution(this.create());
		this.engine.couper();
	}
	
	public MememtoCouper create() {
		return new MememtoCouper();
	}
	
	class MememtoCouper implements Mememto {

		
		public MememtoCouper() { }
		
		@Override
		public void setMememto() {
		}
		
		public MoteurImpl getEngine() {
			return engine;
		}
		
		public CouperCmd getCommand() {
			CouperCmd cmd = new CouperCmd(historique.getEngine(), enregistreur, historique);
			return cmd;
		}
	}

}
