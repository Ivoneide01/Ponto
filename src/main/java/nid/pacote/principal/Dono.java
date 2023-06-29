package nid.pacote.principal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity // informando que é uma entidade
public class Dono extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "dono") // um dono para muitas escolas
	private List<Escola> escolas = new ArrayList<>();

	public Dono() {
		super();
		addPerfil(Perfil.FUNCIONARIO);
	}

	public Dono(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.FUNCIONARIO);
	}

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	
}
