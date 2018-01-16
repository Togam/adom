package projetTSP.algorithmes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import projetTSP.Parseur;
import projetTSP.model.Ville;

public class Voisin {

	private Parseur parseur;

	/**
	 * @param depart
	 * @param villes
	 * @return le numéro de la ville la plus proche de la ville passée en param
	 */
	public int trouverVoisinProche(Ville depart, List<Ville> villes) {
		parseur = new Parseur();
		TreeMap<String, Integer> tmap = parseur.getDistances(villes);
		Map<Integer, Integer> voisins = new HashMap<Integer, Integer>();

		for (Ville ville : villes) {
			if (tmap.get("dist(" + depart.getNum() + "," + ville.getNum() + ")") != null) {
				voisins.put(ville.getNum(), tmap.get("dist(" + depart.getNum() + "," + ville.getNum() + ")"));
			} else if (tmap.get("dist(" + ville.getNum() + "," + depart.getNum() + ")") != null) {
				voisins.put(ville.getNum(), tmap.get("dist(" + ville.getNum() + "," + depart.getNum() + ")"));
			}
		}

		// on récupére la première valeur de la map pour la comparer avec les suivantes
		Set<Integer> cles = voisins.keySet();
		Iterator<Integer> it = cles.iterator();
		int cle = it.next();

		int dist = voisins.get(cle);
		int numVillePlusProche = cle;
		for (Entry<Integer, Integer> entry : voisins.entrySet()) {
			if (entry.getValue() < dist) {
				dist = entry.getValue();
				numVillePlusProche = entry.getKey();
			}
		}
		return numVillePlusProche;
	}
}
