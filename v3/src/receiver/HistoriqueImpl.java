package receiver;

import java.util.Stack;

import command.Command;
import mememto.Mememto;
import receiver.MoteurImpl.MememtoMoteur;

/**
 * @(#) MoteurImpl.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class HistoriqueImpl implements Historique {
	
	private MoteurImpl engine;
	private Stack<Mememto> execution 	= new Stack<Mememto>();
	private Stack<MememtoMoteur> states = new Stack<MememtoMoteur>();
	private Stack<Mememto> cancelled 	= new Stack<Mememto>();
	
	public HistoriqueImpl(MoteurImpl engine) {
		this.setEngine(engine);
	}
	
	@Override
	public void defaire() {
		if (!this.execution.empty()) {
			Mememto m = this.execution.pop();
			this.cancelled.add(m);
			MememtoMoteur memMoteur = (MememtoMoteur) this.states.pop();
			this.engine = memMoteur.getEngine();
		} else {
			System.out.println("Rien a defaire");
		}
	}

	@Override
	public void refaire() {
		if (!this.cancelled.empty()) {
			Mememto m = this.cancelled.pop();
			this.addExecution(m);
			Command cmd = m.getCommand();
			cmd.execute();
		} else {
			System.out.println("Rien a refaire");
		}
	}
	
	public void addExecution(Mememto m) {
		this.execution.add(m);
		MoteurImpl engine = m.getEngine();
		MememtoMoteur memMoteur = engine.create();
		this.states.add(memMoteur);
	}
	
	public void addState(MememtoMoteur state) {
		this.states.add(state);
	}
	
	public void addCancelled(Mememto mememto) {
		this.cancelled.add(mememto);
	}

	public MoteurImpl getEngine() {
		return this.engine;
	}

	public void setEngine(MoteurImpl engine) {
		this.engine = engine;
	}
	
}
