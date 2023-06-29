package nid.pacote.principal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity // informando que é uma entidade
public class Funcionario extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "funcionario") // 
	private List<Escola> escolas = new ArrayList<>();

	public Funcionario() {
		super();
		addPerfil(Perfil.FUNCIONARIO);
	}

	public Funcionario(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.FUNCIONARIO); // quando o funcionario for instanciado ele ja recebe o perfil de funcionario
	}

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}
	
	

}
