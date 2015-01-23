package com.robson.motors.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.robson.motors.model.Automovel;
import com.robson.motors.util.JpaUtil;

@ManagedBean
@ViewScoped
public class AutomovelBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Automovel automovel = new Automovel();
	private List<Automovel> automoveis;
	
	public void salvar() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		em.persist(automovel);
		tr.commit();
		
		em.close();
		
		automovel = new Automovel();
	}
	
	public void excluir(Automovel automovel) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		automovel = em.merge(automovel);
		em.remove(automovel);
		tr.commit();
		
		em.close();
		
		consultaAutomoveis();
	}
	
	public void consultaAutomoveis() {
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Automovel> qr = em.createQuery("select a from Automovel a", Automovel.class);
		automoveis = qr.getResultList();
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

}
