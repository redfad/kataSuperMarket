package repository;

import java.util.ArrayList;
import java.util.List;

import pricing.Offre;


public class OffreRepository {
	private static ArrayList<Offre> offres;

	private OffreRepository() {

	}

	public static List<Offre> getOffres() {
		if(offres == null) {
			offres = new ArrayList<Offre>();
		}
		return offres;
	}
}
