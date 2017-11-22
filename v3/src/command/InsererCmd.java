package command;

import mememto.Mememto;
import invoker.IHM;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * @(#) InsererCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
<<<<<<< HEAD:v3/src/command/InsererCmd.java
 * @version 3.0 V3 du projet mini-editeur
=======
 * @version 1.0 V1 du projet mini-editeur
>>>>>>> dc37de6ae232b2a29cae71d4512d1042f4381bab:v2/src/command/InsererCmd.java
 */
public class InsererCmd implements Command {

	private final MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;

	private final HistoriqueImpl historique;
	
	private final IHM ihm;
	
	private String input;
	
	private boolean getTextBool = false;

	public InsererCmd(MoteurImpl engine, EnregistreurImpl enregistreur, IHM ihm, String input, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
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
		historique.addExecution(this.create());
		historique.addEtatsMoteur(this.engine);
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
			InsererCmd cmd = new InsererCmd(this.engineMememto, enregistreur, this.ihmMememto, this.inputMememto, historique);
			return cmd;
		}

	}

}