package bookmanagement.persistant.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import bookmanagement.persistant.dto.BookDTO;

@Service
public interface bookDAO {
	
	public int insert(BookDTO dto);
	public int update(BookDTO dto);
	public int delete(BookDTO dto);
	public List<BookDTO> selectOne(BookDTO dto);
	public List<BookDTO> selectAll();
	
	

}