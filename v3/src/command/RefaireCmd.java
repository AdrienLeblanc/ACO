package command;

import receiver.HistoriqueImpl;

public class RefaireCmd implements Command {

	private final HistoriqueImpl historique;

	public RefaireCmd (HistoriqueImpl historique) {
		this.historique = historique;
	}
	
	@Override
	public void execute() {
		historique.refaire();
	}

}
