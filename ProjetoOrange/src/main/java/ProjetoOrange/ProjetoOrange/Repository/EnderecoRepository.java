package ProjetoOrange.ProjetoOrange.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetoOrange.ProjetoOrange.model.EnderecoCadastro;

@Repository
public interface EnderecoRepository extends JpaRepository <EnderecoCadastro, Long> {

}