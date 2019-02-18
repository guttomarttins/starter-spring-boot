package br.com.guttomarttins.ssb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guttomarttins.ssb.domain.Usuario;
import br.com.guttomarttins.ssb.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(Long id) {
		return usuarioRepository.getOne(id);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
