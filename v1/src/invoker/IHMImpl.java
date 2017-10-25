package invoker;

import java.util.HashMap;
import java.util.Scanner;

import command.Command;


public class IHMImpl implements IHM {

	private HashMap<String, Command> map = new HashMap<String, Command>();

	public IHMImpl() { }

	public void addCommand(String keyword, Command cmd) {
		map.put(keyword, cmd);
	}

	public String getText() {
		// Demande saisie utilisateur
		System.out.print("Chaine de caracteres a inserer: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	public void terminal() {
		// Demande saisie utilisateur
		System.out.print("ACO-TP1-V1$: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		while(!str.equals("exit")) {
			if (map.containsKey(str)) {
				Command cmd = map.get(str);
				cmd.execute();
			} else {
				System.out.println("Commande non reconnue: " + str);
			}
			// Redemande saisie utilisateur
			System.out.print("ACO-TP1-V1$: ");
			str = sc.nextLine();
		}
		System.out.println("EXIT");
		sc.close();
	}
}
