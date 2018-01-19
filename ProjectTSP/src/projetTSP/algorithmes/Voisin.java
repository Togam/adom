package projetTSP.algorithmes;

import java.util.ArrayList;
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

	/**
	 * Algo swap
	 * 
	 * @param villes
	 * @return la liste de villes ayant subi l'algo swap
	 */
	public List<List<Ville>> swap(List<Ville> villes) {
		List<List<Ville>> swaplist = new ArrayList<List<Ville>>();
		Ville vi = null;
		Ville vj = null;
		for (int i = 0; i < villes.size() - 1; i++) {
			List<Ville> list_dep = new ArrayList<Ville>(villes);
			for (int j = i + 1; j < villes.size(); j++) {
				vi = list_dep.get(i);
				vj = list_dep.get(j);
				list_dep.set(i, vj);
				list_dep.set(j, vi);
				swaplist.add(list_dep);
				String s = "";
				for (int k = 0; k < list_dep.size(); k++) {
					s += list_dep.get(k).getNum() + ", ";
				}
				System.out.println(s + " fin");
			}

		}
		return swaplist;
	}

	/**
	 * Inverse la liste passé en param
	 * 
	 * @param v1
	 * @param v2
	 * @param villes
	 * @return retourne la liste inversé
	 */
	public List<Ville> inverse(Ville v1, Ville v2, List<Ville> villes) {
		List<Ville> v = new ArrayList<Ville>(villes);
		int i1 = Math.min(villes.indexOf(v1), villes.indexOf(v2));
		int i2 = Math.max(villes.indexOf(v1), villes.indexOf(v2));
		Ville vi;
		Ville vj;
		for (int i = i1; i < i2; i++) {
			vi = villes.get(i);
			vj = villes.get(i2);
			v.set(i, vj);
			v.set(i2, vi);
			i2 = i2 - 1;
		}
		return v;
	}

	/**
	 * Algo two opt
	 * 
	 * @param villes
	 * @return la liste de villes ayant subi l'algo two opt
	 */
	public List<List<Ville>> twoopt(List<Ville> villes) {
		List<List<Ville>> twolist = new ArrayList<List<Ville>>();
		for (int i = 0; i < villes.size() - 1; i++) {
			for (int j = i + 1; j < villes.size(); j++) {
				twolist.add(i, inverse(villes.get(i), villes.get(j), villes));
				String s = "";
				for (int k = 0; k < inverse(villes.get(i), villes.get(j), villes).size(); k++) {
					s += inverse(villes.get(i), villes.get(j), villes).get(k).getNum() + ", ";
				}
				System.out.println(s + " fin");
			}
		}

		return twolist;
	}

}
