package projetTSP.algorithmes;

import java.util.List;
import java.util.TreeMap;

import projetTSP.Parseur;
import projetTSP.model.Ville;

/**
 * Classe réunissant les différents algorithmes liés aux voisins
 * 
 * @author six
 *
 */
public class Voisin {

	private Parseur parseur;

	/**
	 * Algorithme heuristique utilisant la méthode des voisins les plus proches
	 * 
	 * @param villes
	 * @return la distance totale du chemin de l'algo des voisins les plus proches
	 */
	public int calculAlgoHeuristique(List<Ville> villes) {
		Ville premierdepart = villes.get(0);
		Ville depart = villes.get(0);
		Ville next = null;
		parseur = new Parseur();
		TreeMap<String, Integer> tmap = parseur.getDistances(villes);
		// la distance dans les fichier est toujours un nombre qui a maximum 4 chiffres
		int dist = 9999;
		int disttotale = 0;
		// int index =0;

		while (villes.size() > 1) {
			int i = -1;
			int index = 0;
			for (Ville ville : villes) {
				i++;
				if (tmap.get("dist(" + depart.getNum() + "," + ville.getNum() + ")") != null
						&& tmap.get("dist(" + depart.getNum() + "," + ville.getNum() + ")") < dist) {
					dist = tmap.get("dist(" + depart.getNum() + "," + ville.getNum() + ")");
					index = i;
				} else if (tmap.get("dist(" + ville.getNum() + "," + depart.getNum() + ")") != null
						&& tmap.get("dist(" + ville.getNum() + "," + depart.getNum() + ")") < dist) {
					dist = tmap.get("dist(" + ville.getNum() + "," + depart.getNum() + ")");
				}
			}
			disttotale += dist;
			next = villes.get(index);
			System.out.println("Ville courante : " + depart.getNum() + " - Ville la plus proche : " + next.getNum()
					+ " - distance : " + dist);
			villes.remove(depart);
			depart = next;
			dist = 9999;
		}
		// retour à la ville de départ
		dist = tmap.get("dist(" + premierdepart.getNum() + "," + next.getNum() + ")");
		disttotale += dist;
		System.out.println("Ville courante : " + next.getNum() + " - retour à la ville de départ : "
				+ premierdepart.getNum() + " - distance : " + dist);
		return disttotale;
	}

}
