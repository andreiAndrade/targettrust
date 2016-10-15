package br.com.tt.dao;

import java.util.List;

public interface IDao<T> {

	void save(T t);
	
	void save(List<T> t);
	
	T buscar(Long id);
	
	T buscar(T t);
	
	void remover(Long id);
	
	void remover(T t);
	
	List<T> consultar(T t);
	
	List<T> list();
}
