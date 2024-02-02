package service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	static EntityManagerFactory emf=null;
	public static EntityManagerFactory getEntityManagerFactory() {
		System.out.println("emf");
		return emf=Persistence.createEntityManagerFactory("BookManagementSpring_JPA");
	}
	
}
