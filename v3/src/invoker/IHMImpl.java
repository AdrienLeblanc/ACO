package invoker;

import java.util.HashMap;
import java.util.Scanner;

import command.Command;
import command.SelectionnerCmd;

/**
 * IHMImpl.java
 * Classe Implementee de l'IHM, correspond au prompt utilise par l'utilisateur
 * @author LEBLANC Adrien
 * @author BUSSEREAU Keryann
 * @version 3.0 V3 du projet mini-editeur
 */
public class IHMImpl implements IHM {

	private HashMap<String, Command> map = new HashMap<String, Command>();

	public IHMImpl() { }

	/**
	 * Methode addCommand
	 * Permet d'ajouter les commandes que l'on veut pouvoir utiliser dans l'IHM
	 * */
	public void addCommand(String keyword, Command cmd) {
		map.put(keyword, cmd);
	}

	/**
	 * Methode getText
	 * Demande une chaine de caractere sur l'entree standard
	 * */
	public String getText() {
		System.out.print("Chaine de caracteres a inserer: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	/**
	 * Methode start
	 * Lance l'IHM, donc ce qui est dans le prompt 
	 * */
	public void start() {
		System.out.print("ACO-TP1-V3$: ");
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
