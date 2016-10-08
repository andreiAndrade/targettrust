package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the livro database table.
 * 
 */
@Entity
@NamedQuery(name="Livro.findAll", query="SELECT l FROM Livro l")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LIVRO_ID_GENERATOR", sequenceName="LIVRO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LIVRO_ID_GENERATOR")
	private Long id;

	private String autor;

	private String description;

	private String isbn;

	private String titulo;

	public Livro() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}