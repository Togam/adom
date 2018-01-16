package projetTSP;
import java.util.ArrayList;
import java.util.List;

import projetTSP.algorithmes.Permutation;

public class Main {

	public static void main(String[] args) {

		Parseur p = new Parseur();
		Permutation permutation = new Permutation();
//		System.out.println(p.getDistances(p.construireListeVille("kroA100.tsp")));
		System.out.println(p.getDistances(p.construireListeVille("kroA100.tsp")).size());

		List<Ville> villes = new ArrayList<Ville>();
		Ville v1 = new Ville(1, 2, 3);
		Ville v2 = new Ville(2, 5, 4);
		Ville v3 = new Ville(3, 3, 3);
		Ville v4 = new Ville(4, 5, 7);
		villes.add(v1);
		villes.add(v2);
		villes.add(v3);
		villes.add(v4);
		
		System.out.println(p.getDistances(villes));
		System.out.println(permutation.permutation(villes)+"\n");
		
		villes.clear();
		villes.add(v3);
		villes.add(v2);
		villes.add(v4);
		villes.add(v1);
		
		System.out.println(p.getDistances(villes));
		System.out.println(permutation.permutation(villes)+"\n");
		
		System.out.println(permutation.permutation((p.melangerVilles(p.construireListeVille("kroA100.tsp")))));
	}

}
