package command;

import receiver.EnregistreurImpl;

public class RejouerEgt implements Command {
	
private final EnregistreurImpl enregistreur;
	
	public RejouerEgt(EnregistreurImpl enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.rejouer();
	}

}
