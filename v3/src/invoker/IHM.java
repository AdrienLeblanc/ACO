package invoker;

import command.Command;

/**
 * IHM.java
 * @author LEBLANC Adrien
 * @author BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public interface IHM {
	
	public void addCommand(String keyword, Command cmd);
	public String getText();
	
}
