package command;

import receiver.HistoriqueImpl;
/**
 * DefaireCmd.java
 * Commande permettant d'annuler une action
 * @author LEBLANC Adrien
 * @author BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class DefaireCmd implements Command {

	private final HistoriqueImpl historique;
	
	public DefaireCmd (HistoriqueImpl historique) {
		this.historique = historique;
	}
	
	@Override
	public void execute() {
		historique.defaire();
	}

}
