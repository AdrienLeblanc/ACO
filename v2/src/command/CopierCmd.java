package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.MoteurImpl;


public class CopierCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
		
	public CopierCmd(MoteurImpl engine, EnregistreurImpl enregistreur) {
		this.engine = engine;
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		if (this.enregistreur.getAdemarre()) {
			MememtoCopier mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
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
			CopierCmd cmd = new CopierCmd(this.engineMememto, enregistreur);
			return cmd;
		}
	}
}
