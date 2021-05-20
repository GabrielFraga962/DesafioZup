package ProjetoOrange.ProjetoOrange.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoOrange.ProjetoOrange.Repository.EnderecoRepository;
import ProjetoOrange.ProjetoOrange.model.EnderecoCadastro;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin("*")
public class EnderecosController {
	
	@Autowired
	private EnderecoRepository repository;
	
	
	
	@GetMapping
	public ResponseEntity<List<EnderecoCadastro>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
//	@GetMapping("/usuario/{nome}")
//	public ResponseEntity<Optional<UsuarioCadastro>> getByName(@PathVariable String nome){
//		return ResponseEntity.ok(repositorio.findAllByNome(nome));
//	}


	@PostMapping
	public ResponseEntity<EnderecoCadastro> post (@RequestBody EnderecoCadastro endcadastro) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(endcadastro));
	}
	
	
}
