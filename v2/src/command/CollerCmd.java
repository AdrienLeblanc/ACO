package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.MoteurImpl;


public class CollerCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	public CollerCmd(MoteurImpl engine, EnregistreurImpl enregistreur) {
		this.engine = engine;
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		if (this.enregistreur.getAdemarre()) {
			MememtoColler mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
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
			CollerCmd cmd = new CollerCmd(this.engineMememto, enregistreur);
			return cmd;
		}
	}

}
