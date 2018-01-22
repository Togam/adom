package projetTSP.algorithmes;

import java.util.List;
import java.util.TreeMap;

import projetTSP.Parseur;
import projetTSP.model.Ville;

public class Permutation {

	private Parseur parseur;
	
	public int calculPermutation(List<Ville> villes) {
		parseur = new Parseur();
		TreeMap<String, Integer> tmap = parseur.getDistances(villes);
		int permutation = 0;
		// la première ville est en position 0 de la liste
		int i = 0;
		for (Ville ville : villes) {
			i++;
			if (i < villes.size()) {
				int numcourant = ville.getNum();
				int numsuivant = villes.get(i).getNum();
				if (tmap.get("dist(" + numcourant + "," + numsuivant + ")") != null) {
					permutation += tmap.get("dist(" + numcourant + "," + numsuivant + ")");
				}
			}
		}
		i -= 1;
		// il faut retourner à la ville de départ une fois que l'intégralité de la liste
		// a été parcourue. Le i correspond à la position de la dernière ville de la
		// liste.
		if (tmap.get("dist(" + villes.get(i).getNum() + "," + villes.get(0).getNum() + ")") != null) {
			permutation += tmap.get("dist(" + villes.get(i).getNum() + "," + villes.get(0).getNum() + ")");
		} else {
			permutation += tmap.get("dist(" + villes.get(0).getNum() + "," + villes.get(i).getNum() + ")");

		}
//		System.out.println(tmap);
		return permutation;
	}
	
}
