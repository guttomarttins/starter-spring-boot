package br.com.guttomarttins.ssb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guttomarttins.ssb.domain.Usuario;
import br.com.guttomarttins.ssb.repository.UsuarioRepository;
import br.com.guttomarttins.ssb.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario findById(Long id) {
		return usuarioRepository.getOne(id);
	}
	
	public Usuario findByEmail(String email) {
		Optional<Usuario> obj = usuarioRepository.findByEmail(email);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
