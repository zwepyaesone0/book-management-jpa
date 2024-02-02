package bookmanagement.persistant.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import bookmanagement.persistant.dto.BookDTO;
import service.JPAUtil;


public class BookDaoImp implements bookDAO {

	@Override
	public int insert(BookDTO dto) {
		int valid=0;
		EntityManager em=null;
		try {
		
		em =JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
		valid=1;
		}
		finally {
			em.close();
		}
		return valid;
	}

	@Override
	public int update(BookDTO dto) {
		int valid=0;
		EntityManager em=null;
		try {
			em=JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(dto);
			em.getTransaction().commit();
			valid=1;
		}finally {
			em.close();
		}
		
		return valid;
	}

	@Override
	public int delete(BookDTO dto) {
		int valid=0;
		EntityManager em=null;
		try {
			em=JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			BookDTO out=em.find(BookDTO.class, dto.getBookCode());
			//System.out.println(" >>> "+out);
			em.remove(out);
			em.getTransaction().commit();
			valid=1;
		}
		finally {
			em.close();
		}
		return valid;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookDTO> selectOne(BookDTO dto) {
		EntityManager em=null;
		List<BookDTO> list=new ArrayList<BookDTO>();
		try {
			em=JPAUtil.getEntityManagerFactory().createEntityManager();
			list= em.createQuery("select b from BookDTO b where b.bookCode=:code").setParameter("code", dto.getBookCode()).getResultList();
		}
		finally {
			em.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookDTO> selectAll() {
		List<BookDTO> list=new ArrayList<BookDTO>();
		EntityManager em=null;
		try {
			System.out.println("EM::::");
			em=JPAUtil.getEntityManagerFactory().createEntityManager();
			
			list=em.createQuery("select b from BookDTO b").getResultList();
		}
		finally {
			em.close();
		
		}
		return list;
	}
	

}
