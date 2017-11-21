package command;

import mememto.Mememto;
import invoker.IHM;
import receiver.EnregistreurImpl;
import receiver.MoteurImpl;

/**
 * @(#) InsererCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public class InsererCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;

	private final IHM ihm;
	
	private String input;
	
	private boolean getTextBool = false;

	public InsererCmd(MoteurImpl engine, EnregistreurImpl enregistreur, IHM ihm, String input) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.ihm = ihm;
		this.input = input;
		this.getTextBool = (this.input == null) ;
	}

	public void execute() {
		if (getTextBool) this.input = this.ihm.getText();
		if (this.enregistreur.getAdemarre()) {
			MememtoInserer mem = this.create();
			mem.setMememto();
			this.enregistreur.addMememto(mem);
		}
		//System.out.println(this.input);
		this.engine.inserer(this.input);
	}
	
	public MememtoInserer create() {
		return new MememtoInserer();
	}

	class MememtoInserer implements Mememto {

		private MoteurImpl engineMememto;
		
		private IHM ihmMememto;
		
		private String inputMememto;

		public MememtoInserer() { }

		@Override
		public void setMememto() {
			this.engineMememto = engine;
			this.ihmMememto = ihm;
			this.inputMememto = input;
		}

		public InsererCmd getCommand() {
			InsererCmd cmd = new InsererCmd(this.engineMememto, enregistreur, this.ihmMememto, this.inputMememto);
			return cmd;
		}

	}

}