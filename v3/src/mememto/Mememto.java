package mememto;

import command.Command;
import receiver.MoteurImpl;

/**
 * @(#) Memento.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public interface Mememto {
	
	public void setMememto();
	
	public MoteurImpl getEngine();
	
	public Command getCommand();
	
}
