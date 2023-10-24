package crud;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Dstan;
import model.DstanPK;
import model.Dvlasnik;
import model.Dzgrada;

public class VlasnikCrud {

	public void insertVlasnik(Dvlasnik v) {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(v);
			em.flush();
			et.commit();
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
	}
	
	public void insertStan(Dvlasnik v, Dzgrada d, int br, double kv, int sp) {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			v = em.merge(v);
			d = em.merge(d);
			Dstan s = new Dstan();
			DstanPK spk = new DstanPK();
			s.setBrojstana(br);
			s.setDvlasnik(v);
			s.setDzgrada(d);
			s.setKvadratura(kv);
			s.setSprat(sp);
			s.setId(spk);
			em.persist(s);
			em.flush();
			et.commit();
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
	}
	
	public List<Dstan> stanoviVlasnika(Dvlasnik dv) {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		Query q = em.createQuery("Select s from Dstan s where s.vlasnik_idv=:x");
		q.setParameter("x", dv.getIdv());
		List<Dstan> rez = dv.getDstans();
		em.close();
		return rez;
	}
		
	public List<Dvlasnik> sviVlasnici() {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		List<Dvlasnik> rez = em.createQuery("Select v from Dvlasnik v").getResultList();
		em.close();
		return rez;
	}
	
	public List<Dzgrada> sveZgrade() {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		List<Dzgrada> rez = em.createQuery("Select z from Dzgrada z").getResultList();
		em.close();
		return rez;
	}

}
