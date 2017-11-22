package command;

import receiver.HistoriqueImpl;

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
