package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Dstan;
import model.Dvlasnik;
import model.Dzgrada;

public class ZgradaCrud {

	public boolean deleteZgrada (Dzgrada dz) {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		boolean rez = false;
		try {
			et = em.getTransaction();
			et.begin();
			dz = em.merge(dz);
			List<Dstan> dstanovi = dz.getDstans();
			for (Dstan d : dstanovi) {
				Dvlasnik dv = d.getDvlasnik();
				dv.getDstans().remove(d);
				em.remove(d);
			}
			em.remove(dz);
			em.flush();
			et.commit();
			rez = true;
		} catch (Exception e) {
			e.printStackTrace();
			if (et != null) {
				et.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return rez;
	}
}
