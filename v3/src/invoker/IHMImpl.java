package invoker;

import java.util.HashMap;
import java.util.Scanner;

import command.Command;
import command.SelectionnerCmd;

/**
 * @(#) IHMImpl.java
 * Classe Impl�ment� de l'IHM, correspond au prompt utilis� par l'utilisateur
 * @author LEBLANC Adrien && BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class IHMImpl implements IHM {

	private HashMap<String, Command> map = new HashMap<String, Command>();

	public IHMImpl() { }

	/**
	 * M�thode addCommand
	 * Permet d'ajouter les commandes que l'on veut pouvoir utiliser dans l'IHM
	 * */
	public void addCommand(String keyword, Command cmd) {
		map.put(keyword, cmd);
	}

	/**
	 * M�thode getText
	 * Demande une chaine de caract�re sur l'entr�e standard
	 * */
	public String getText() {
		System.out.print("Chaine de caracteres a inserer: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	/**
	 * M�thode start
	 * Lance l'IHM, donc ce qui est dans le prompt 
	 * */
	public void start() {
		System.out.print("ACO-TP1-V1$: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		while(!str.equals("exit")) {
			if (map.containsKey(str)) {
				if (str.equals("selectionner")) {
					// On demande le debut et la fin de la selection
					SelectionnerCmd cmd = (SelectionnerCmd) map.get(str);
					System.out.print("debut: ");
					int debut = sc.nextInt();
					cmd.setDebut(debut);
					System.out.print("fin: ");
					int fin = sc.nextInt();
					cmd.setFin(fin);
					cmd.execute();
				} else {
					Command cmd = map.get(str);
					cmd.execute();
				}
			}
			if (!str.equals("")) System.out.print("ACO-TP1-V1$: ");
			str = sc.nextLine();
		}
		sc.close();
	}
}
