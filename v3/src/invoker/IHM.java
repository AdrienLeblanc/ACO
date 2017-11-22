package invoker;

import command.Command;

/**
 * @(#) IHM.java
 * @author LEBLANC Adrien && BUSSEREAU Keryann
<<<<<<< HEAD:v3/src/invoker/IHM.java
 * @version 3.0 V3 du projet mini-editeur
=======
 * @version 1.0 V1 du projet mini-editeur
>>>>>>> dc37de6ae232b2a29cae71d4512d1042f4381bab:v1/src/invoker/IHM.java
 */
public interface IHM {
	
	public void addCommand(String keyword, Command cmd);
	public String getText();
	
}
