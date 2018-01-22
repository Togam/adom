package projetTSP;
import java.util.ArrayList;
import java.util.List;

import projetTSP.algorithmes.Permutation;
import projetTSP.algorithmes.Voisin;
import projetTSP.model.Ville;

public class Main {

	public static void main(String[] args) {

		Parseur p = new Parseur();
		Permutation permutation = new Permutation();
		Voisin voisin = new Voisin();
//		System.out.println(p.getDistances(p.construireListeVille("kroA100.tsp")));
//		System.out.println(p.getDistances(p.construireListeVille("kroA100.tsp")).size());

		List<Ville> villes = new ArrayList<Ville>();
		Ville v1 = new Ville(1, 2, 3);
		Ville v2 = new Ville(2, 5, 4);
		Ville v3 = new Ville(3, 3, 3);
		Ville v4 = new Ville(4, 5, 7);
		Ville v5 = new Ville(5, 10, 7);
		Ville v6 = new Ville(6, 5, 10);
		Ville v7 = new Ville(7, 8, 8);
		villes.add(v1);
		villes.add(v2);
		villes.add(v3);
		villes.add(v4);
		villes.add(v5);
		villes.add(v6);
		villes.add(v7);
//		voisin.swap(villes);
//		voisin.twoopt(villes);
		
//		System.out.println(p.getDistances(villes));
//		System.out.println(permutation.calculPermutation(villes)+"\n");
//		
//		villes.clear();
//		villes.add(v3);
//		villes.add(v2);
//		villes.add(v4);
//		villes.add(v1);
//		
//		System.out.println(p.getDistances(villes));
//		System.out.println(permutation.calculPermutation(villes)+"\n");
////		System.out.println("voisin le plus proche : "+voisin.trouverVoisinProche(v3, villes));
//		
////		System.out.println(permutation.calculPermutation((p.melangerVilles(p.construireListeVille("kroA100.tsp")))));
//	
//		System.out.println(voisin.calculAlgoHeuristique(villes));
//		
////		System.out.println(villes);
//	
		System.out.println("distance la plus petite : "+voisin.calculSwapPremierVoisinAméliorant(villes));
		
	}

}
