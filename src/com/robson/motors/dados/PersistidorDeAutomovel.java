package com.robson.motors.dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistidorDeAutomovel {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MotorsPU");
		
		EntityManager em = emf.createEntityManager();
		
		
	}

}
