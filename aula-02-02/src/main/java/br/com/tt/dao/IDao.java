package br.com.tt.dao;

import java.io.Serializable;
import java.util.List;

import br.com.tt.Versao;

public interface IDao<T> extends Serializable, Versao {

	void salvar(T t) throws Exception;

	T buscar(Long id);

	T buscar(T t);

	List<T> consultar();

	List<T> consultar(T t);

	List<T> consultar(List<T> t);

	void remover(Long id);

	void remover(T t) throws Exception;

	void remover(List<T> t) throws Exception;
}
