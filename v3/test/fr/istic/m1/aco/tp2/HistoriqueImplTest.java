package fr.istic.m1.aco.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import client.Editeur;
import command.CouperCmd;
import command.DefaireCmd;
import command.InsererCmd;
import command.SelectionnerCmd;
import invoker.IHMImpl;
import receiver.EnregistreurImpl;
import receiver.HistoriqueImpl;
import receiver.MoteurImpl;

public class HistoriqueImplTest {

	@Test
	public void testDefaire() {
		Editeur e = new Editeur(null, null);
		StringBuffer s = new StringBuffer();
		MoteurImpl m = new MoteurImpl(e, s);
		EnregistreurImpl er = new EnregistreurImpl();
		e.setEngine(m);
		
		HistoriqueImpl historique = new HistoriqueImpl(m);
		
		InsererCmd ins = new InsererCmd(historique.getEngine(), er, null, "bonjour", historique);
		ins.execute();
		SelectionnerCmd sel = new SelectionnerCmd(m, er, 0, 4, historique);
		sel.execute();
		CouperCmd cp = new CouperCmd(historique.getEngine(), er, historique);
		cp.execute();
		
		DefaireCmd def = new DefaireCmd(historique);
		def.execute();
		
		System.out.println(historique.getEngine());
		assertTrue(m.getTexte().toString().equals("bonjour"));
	}
}
