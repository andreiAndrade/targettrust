package br.com.tt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tt.model.Livro;
import br.com.tt.repository.LivroRepository;

@Controller
@RequestMapping("/")
public class LivroController {

	private LivroRepository livroRepository;

	@Autowired
	public LivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@RequestMapping(value = "/livro/{autor}", method = RequestMethod.GET)
	public String listaLivros(@PathVariable("autor") String autor, Model model) {
		List<Livro> listaLivros = livroRepository.findByAutor(autor);
		if (listaLivros != null) {
			model.addAttribute("livros", listaLivros);
		}
		return "listaLivros";
	}

	@RequestMapping(value = "/livro/{autor}", method = RequestMethod.POST)
	public String adicionaLivroAutor(@PathVariable("autor") String autor, Livro livro) {
		livro.setAutor(autor);
		livroRepository.save(livro);
		return "redirect:/livro/{autor}";
	}
}