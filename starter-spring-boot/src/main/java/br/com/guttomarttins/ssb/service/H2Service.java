package br.com.guttomarttins.ssb.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guttomarttins.ssb.domain.Usuario;
import br.com.guttomarttins.ssb.repository.UsuarioRepository;

@Service
public class H2Service {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instantiateH2DataBase()throws ParseException {
		
		Usuario u1 = new Usuario(null, "Carlos Martins", "guttomarttins@gmail.com", "1234");
		usuarioRepository.save(u1);
		Usuario u2 = new Usuario(null, "Maria", "maria@gmail.com", "3210");
		usuarioRepository.save(u2);
		Usuario u3 = new Usuario(null, "José", "jose@gmail.com", "0099");
		usuarioRepository.save(u3);
	}

	 
}
