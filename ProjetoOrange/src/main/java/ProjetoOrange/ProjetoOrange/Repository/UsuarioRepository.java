package ProjetoOrange.ProjetoOrange.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetoOrange.ProjetoOrange.model.UsuarioCadastro;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioCadastro, Long> {
	
	Optional<UsuarioCadastro> findByCpf(String cpf);
	Optional<UsuarioCadastro> findByEmail(String email);
	Optional<UsuarioCadastro> findById(Long id);
	Optional<UsuarioCadastro> findAllByNome(String nome);
	
}