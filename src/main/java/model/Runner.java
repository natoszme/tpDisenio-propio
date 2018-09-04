package model;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import fixture.Fixture;

public class Runner {	
	
	private static EntityManager em = PerThreadEntityManagers.getEntityManager();
	
	public static void main(String[] args) {
		
		new Fixture().run();
		// VACIO LA CACHE
		// em.clear();
	}
}