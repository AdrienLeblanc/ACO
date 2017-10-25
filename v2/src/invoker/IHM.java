package invoker;

import command.Command;

/**
 * @(#) IHM.java
 */

public interface IHM {
	
	public void addCommand(String keyword, Command cmd);
	public String getText();
	
}
