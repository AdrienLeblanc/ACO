package command;

import receiver.HistoriqueImpl;

/**
 * AfficherCmd.java
 * Commande permettant d'afficher le texte de notre editeur (buffer string)
 * @author LEBLANC Adrien
 * @author BUSSEREAU Keryann
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
