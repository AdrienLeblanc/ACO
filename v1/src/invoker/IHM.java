package invoker;

import command.Command;


/**
 * @(#) IHM.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 1.0 V1 du projet mini-editeur
 */
public interface IHM {
	
	public void addCommand(String keyword, Command cmd);
	public String getText();
	
}
