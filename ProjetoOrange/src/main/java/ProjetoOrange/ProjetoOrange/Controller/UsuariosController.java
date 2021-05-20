package ProjetoOrange.ProjetoOrange.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoOrange.ProjetoOrange.Repository.UsuarioRepository;
import ProjetoOrange.ProjetoOrange.model.EnderecoCadastro;
import ProjetoOrange.ProjetoOrange.model.UsuarioCadastro;
import ProjetoOrange.ProjetoOrange.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/endereco/novo/{id_Usuario}")
	public ResponseEntity<?> novoEndereco (@PathVariable(value = "id_Usuario") Long idUsuario, @Valid @RequestBody EnderecoCadastro novoEndereco) {
			EnderecoCadastro cadastro = usuarioService.cadastrarEndereco(novoEndereco, idUsuario);
			if(cadastro == null) {
				return new ResponseEntity<String>("Não foi possível conclúir o cadastro, tente novamente.", HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<EnderecoCadastro>(cadastro, HttpStatus.CREATED);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioCadastro> post(@RequestBody @Valid UsuarioCadastro usuario) {
		UsuarioCadastro user = usuarioService.cadastrar(usuario);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioCadastro>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioCadastro> getById (@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping 
	public ResponseEntity<UsuarioCadastro> put (@RequestBody UsuarioCadastro usuario) {
		return ResponseEntity.ok(repository.save(usuario));
	}
	
	@DeleteMapping("{id}")
	public void delete (@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
