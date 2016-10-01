package br.com.tt.util;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManager em;
	
	private static EntityTransaction trans;
	
	private static String pu;
	
	public static EntityManager getEm() {
		if (Objects.isNull(em) || !em.isOpen()) {
			em = Persistence.createEntityManagerFactory(pu).createEntityManager();
			trans = em.getTransaction();
		}
		return em;
	}

	public static String getPu() {
		return pu;
	}

	public static void setPu(String pu) {
		JpaUtil.pu = pu;
	}

	public static EntityTransaction getTrans() {
		return trans;
	}
}
