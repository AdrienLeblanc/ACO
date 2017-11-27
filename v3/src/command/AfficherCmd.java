package command;

import receiver.HistoriqueImpl;

/**
 * @(#) AfficherCmd.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class AfficherCmd implements Command {

	private final HistoriqueImpl historique;
	
	public AfficherCmd(HistoriqueImpl historique) {
		this.historique = historique;
	}

	@Override
	public void execute() {
		this.historique.getEngine().afficher();
	}
	
}
