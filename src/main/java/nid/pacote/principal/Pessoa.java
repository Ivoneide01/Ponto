package nid.pacote.principal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // informando que é uma entidade
public abstract class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id // chave primaria de id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // gerando chave primaria, quem irá gerar é o banco 
	protected Integer id;
	protected  String nome;
	
	@Column(unique = true)// essa coluna é unica ou seja nao vai existir os dados iguais
	protected String cpf;
	
	@Column(unique = true)// essa coluna é unica ou seja nao vai existir os dados iguais
	protected String email;
	
	protected String senha;
	
	@ElementCollection(fetch = FetchType.EAGER) //essa é uma coleção, que quando buscar ele irá vir, irá depender do perfil de usuario
	@CollectionTable(name = "PERFIS") // NO BANCO IRA TER UMA TABELA COM OS PERFILS
	protected Set<Integer> perfis = new HashSet<>(); //set nao permite que tenha dois perfil igual
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dateCriacao = LocalDate.now();
	
	public Pessoa() {
		super();
		addPerfil(Perfil.FUNCIONARIO);// TODO USUARIO ADICIONADO NO SISTEMA IRÁ TER O PERFIL DE FUNCIONARIO
	}

	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.FUNCIONARIO); // TODO USUARIO ADICIONADO NO SISTEMA IRÁ TER O PERFIL DE FUNCIONARIO
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet()); // retorna uma lista do tipo perfil, e mapeando o Perfil para converter para tipo set
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDateCriacao() {
		return dateCriacao;
	}

	public void setDateCriacao(LocalDate dateCriacao) {
		this.dateCriacao = dateCriacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	
}
