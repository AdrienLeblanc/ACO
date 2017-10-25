package command;

import receiver.EnregistreurImpl;

public class StopperEgt implements Command {
	
private final EnregistreurImpl enregistreur;
	
	public StopperEgt(EnregistreurImpl enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.stopper();
	}

}