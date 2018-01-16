package projetTSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import projetTSP.model.Ville;

/**
 * Classe qui parse un fichier ou traite des liste
 * 
 * @author six
 *
 */
public class Parseur {
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private Pattern pattern;
	private Matcher matcher;

	public List<Ville> construireListeVille(String nomFile) {
		this.file = new File(nomFile);
		List<Ville> villes = new ArrayList<Ville>();
		pattern = Pattern.compile("^[0-9]+.\\w");
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine();

			while (line != null) {
				matcher = pattern.matcher(line);
				if (matcher.lookingAt()) {
					String[] decompose = line.split(" ");
					Ville ville = new Ville(Integer.parseInt(decompose[0]), Integer.parseInt(decompose[1]),
							Integer.parseInt(decompose[2]));
					villes.add(ville);
				}
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return villes;
	}

	public TreeMap<String, Integer> getDistances(List<Ville> villes) {
		TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();
		Calculator c = new Calculator();
		for (Ville v1 : villes) {
			for (int i = villes.indexOf(v1) + 1; i < villes.size(); i++) {
				Ville v = villes.get(i);
				String nomDist = "dist(" + v1.getNum() + "," + v.getNum() + ")";
				tmap.put(nomDist, c.distance(v1.getX(), v1.getY(), v.getX(), v.getY()));
			}
		}
		// TODO : mettre le result dans un fichier externe
		return tmap;
	}

	public List<Ville> melangerVilles(List<Ville> villes) {
		List<Ville> alea = new ArrayList<Ville>();

		while (!villes.isEmpty()) {
			Random r = new Random();
			// chiffre aléatoire >=0 et < taille de la liste (la liste commence à 0)
			int n = r.nextInt(villes.size());

			alea.add(villes.get(n));
			villes.remove(n);
		}
		return alea;
	}

}
