package projetTSP;

public class Calculator {

	public int distance(int xa, int ya, int xb, int yb) {
		return (int) Math.sqrt((xb - xa) * (xb - xa) + (yb - ya) * (yb - ya));
	}

}
