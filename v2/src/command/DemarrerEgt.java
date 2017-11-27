package command;

import receiver.EnregistreurImpl;

public class DemarrerEgt implements Command {

	private final EnregistreurImpl enregistreur;
	
	public DemarrerEgt(EnregistreurImpl enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.demarrer();
	}

}
