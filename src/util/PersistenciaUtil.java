package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenciaUtil {
	
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("pesquisa");
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
