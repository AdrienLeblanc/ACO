package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.MoteurImpl;

/**
 * @(#) CouperCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class CouperCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	public CouperCmd(MoteurImpl engine, EnregistreurImpl enregistreur) {
		this.engine = engine;
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		if (this.enregistreur.getAdemarre()) {
			MememtoCouper mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
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
			CouperCmd cmd = new CouperCmd(this.engineMememto, enregistreur);
			return cmd;
		}
	}

}
