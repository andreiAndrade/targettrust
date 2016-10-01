package br.com.tt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.tt.model.Pet;
import br.com.tt.util.JpaUtil;

public class PetDAO implements IDao<Pet> {

	private static final long serialVersionUID = 1L;

	public String getVersao() {
		return "1.0";
	}

	public void salvar(Pet pet) {
		EntityManager em = JpaUtil.getEm();
		EntityTransaction trans = JpaUtil.getTrans();

		try {
			trans.begin();
			em.merge(pet);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
		}
	}

	public Pet buscar(Long id) {
		return JpaUtil.getEm().find(Pet.class, id);
	}

	public Pet buscar(Pet pet) {
		return consultar(pet).isEmpty() ? null : consultar(pet).get(0);
	}

	public List<Pet> consultar() {
		return null;
	}

	//alt + shift + a = seleciona na vertical
	public List<Pet> consultar(Pet pet) {
		EntityManager em = JpaUtil.getEm();
		String sql = " SELECT p FROM Pet p ";
		sql += " WHERE 1=1 ";
		if (!Objects.isNull(pet) && !Objects.isNull(pet.getNome())) {
			sql += " AND p.nome = :nome ";
		}
		TypedQuery<Pet> query = em.createQuery(sql, Pet.class);
		query.setParameter("nome", pet.getNome());
		return query.getResultList();
	}

	public List<Pet> consultar(List<Pet> t) {
		EntityManager em = JpaUtil.getEm();
		String sql = "SELECT * FROM Pet";
		TypedQuery<Pet> query = em.createQuery(sql, Pet.class);
		return query.getResultList();
	}

	public void remover(Long id) {
		remover(buscar(id));
		;

	}

	public void remover(Pet pet) {
		EntityManager em = JpaUtil.getEm();
		try {
			em.getTransaction().begin();
			em.remove(pet);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void remover(List<Pet> pets) {
		for (Pet pet : pets) {
			remover(pet);
		}
	}
}
