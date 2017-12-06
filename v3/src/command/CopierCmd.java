package command;

import mememto.Mememto;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

/**
 * CopierCmd.java
 * Commande permettant de copier le texte qui a ete selectionne
 * @author LEBLANC Adrien
 * @author BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class CopierCmd implements Command {

	private MoteurImpl engine;
	
	private final EnregistreurImpl enregistreur;
	
	private final HistoriqueImpl historique;
	
	/**
	 * Constructeur
	 * @param engine : MoteurImpl
	 * @param enregistreur : EnregistreurImpl
	 * @param historique : HistoriqueImpl
	 * */
	public CopierCmd(MoteurImpl engine, EnregistreurImpl enregistreur, HistoriqueImpl historique) {
		this.engine = engine;
		this.enregistreur = enregistreur;
		this.historique = historique;
	}

	/**
	 * Methode execute
	 * Permet d'executer la commande sur laquelle elle est appelee
	 */
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

	/**
	 * Classe MementoCopier
	 * Permet d'enregistrer l'etat de copier a un instant t
	 * */
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
