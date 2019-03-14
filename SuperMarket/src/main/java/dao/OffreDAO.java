package dao;

import java.util.List;
import java.util.logging.Logger;

import pricing.Offre;
import repository.OffreRepository;

public class OffreDAO {

	private final Logger log = Logger.getLogger("OffreDAO");
	private final List<Offre> offres = OffreRepository.getOffres();

	/**
	 * Save an offre
	 * 
	 * @param offre
	 * @return
	 */
	public Offre save(Offre offre) {
		log.info("Request to save Offre : " + offre);
		offres.add(offre);
		return offre;
	}

	/**
	 * Delete an offre
	 * 
	 * @param offre
	 */
	public void delete(Offre offre) {
		log.info("Request to delete Offre : " + offre);
		offres.removeIf(val -> val.getOffreId().equals(offre.getOffreId()));
	}

	/**
	 * Search for an offre by its id
	 * 
	 * @param id
	 */
	public Offre findOne(Integer id) {
		log.info("Request to finde Offre : " + id);
		return offres.stream().filter(offre -> offre.getOffreId().equals(id)).findFirst().get();
	}

	/**
	 * find all offres
	 */
	public List<Offre> findAll() {
		log.info("Request to find all offres : ");
		return offres;
	}
}
