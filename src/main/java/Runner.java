import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class Runner implements WithGlobalEntityManager {
	private EntityManager em = entityManager();
	
	public static void main(String[] args) {		
		// VACIO LA CACHE
		// em.clear();
	}
}
