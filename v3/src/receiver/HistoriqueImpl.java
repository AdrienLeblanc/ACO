package receiver;

import java.util.Stack;

import command.Command;
import mememto.Mememto;

/**
 * @(#) MoteurImpl.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class HistoriqueImpl implements Historique {

	Stack<Mememto> execution 		= new Stack<Mememto>();
	Stack<MoteurImpl> etatsMoteur 	= new Stack<MoteurImpl>();
	Stack<Mememto> cancelled 		= new Stack<Mememto>();
	
	public HistoriqueImpl() { }
	
	@Override
	public void defaire() {
		Mememto m = execution.pop();
		cancelled.add(m);
		
	}

	@Override
	public void refaire() {
		Mememto m = cancelled.pop();
		Command cmd = m.getCommand();
		cmd.execute();
	}
	
	public void addExecution(Mememto mememto) {
		this.execution.add(mememto);
	}
	
	public void addEtatsMoteur(MoteurImpl mememto) {
		this.etatsMoteur.add(mememto);
	}
	
	public void addCancelled(Mememto mememto) {
		this.cancelled.add(mememto);
	}
	
}
