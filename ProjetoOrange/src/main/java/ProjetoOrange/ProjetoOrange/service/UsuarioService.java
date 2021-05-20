package ProjetoOrange.ProjetoOrange.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetoOrange.ProjetoOrange.Repository.EnderecoRepository;
import ProjetoOrange.ProjetoOrange.Repository.UsuarioRepository;
import ProjetoOrange.ProjetoOrange.model.EnderecoCadastro;
import ProjetoOrange.ProjetoOrange.model.UsuarioCadastro;

@Service
public class UsuarioService {
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
		
	@Autowired
	EnderecoRepository enderecoRepository;
		
	public UsuarioCadastro cadastrar(UsuarioCadastro cadastro) {
		Optional<UsuarioCadastro> cpfExistente = usuarioRepository.findByCpf(cadastro.getCpf());
		Optional<UsuarioCadastro> emailExistente = usuarioRepository.findByEmail(cadastro.getEmail());
			
		if(cpfExistente.isPresent() || emailExistente.isPresent()) {
				return null;
		}
			
		return usuarioRepository.save(cadastro);
	}
		
	public EnderecoCadastro cadastrarEndereco(EnderecoCadastro novoEndereco, Long idUsuario) {
		EnderecoCadastro enderecoExistente = enderecoRepository.save(novoEndereco);
		Optional<UsuarioCadastro> usuarioExistente = usuarioRepository.findById(idUsuario);
			
		if(usuarioExistente.isPresent()) {
			enderecoExistente.setUsuarioCadastro(usuarioExistente.get());
			return enderecoRepository.save(enderecoExistente);
		}
			
		return null;
	}
}
