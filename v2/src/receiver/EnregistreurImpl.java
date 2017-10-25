package receiver;

import java.util.ArrayList;

import command.Command;
import mememto.Mememto;


public class EnregistreurImpl implements Enregistreur {
	
	ArrayList<Mememto> list = new ArrayList<Mememto>();
	
	private boolean ademarre = false;
		
	public EnregistreurImpl() { }

	@Override
	public void demarrer() {
		setAdemarre(true);
	}

	@Override
	public void stopper() {
		setAdemarre(false);
	}

	@Override
	public void rejouer() {
		for (Mememto m : this.list) {
			Command cmd = m.getCommand();
			cmd.execute();
		}
	}
	
	public void addMememto(Mememto m) {
		list.add(m);
	}
	
	public boolean getAdemarre() {
		return ademarre;
	}

	public void setAdemarre(boolean ademarre) {
		this.ademarre = ademarre;
	}
	
}
