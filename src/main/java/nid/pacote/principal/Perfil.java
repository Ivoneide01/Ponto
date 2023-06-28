package nid.pacote.principal;

public enum Perfil { // ENUM FAZ OS OBJETOS FUNCIONARIO E DONO SEREM INT
	FUNCIONARIO(0, "ROLE_FUNCIONARIO"), DONO(1, "ROLE_DONO"); // COLOCANDO UM VALOR FIXO USANDO ENUM
	private Integer codigo;
	private String descricao;
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}  
	
	public static Perfil toEnum(Integer cod) { // se o perfil for nullo retorne null
		if(cod == null) {
			return null;
		}
		for(Perfil x : Perfil.values()) {
			if (cod.equals(x.getCodigo())) {
				return x; // se o cod for valido com os valores dono ou funcionario retornar X
			}
		}
		throw new IllegalArgumentException("Perfil invalido"); // exeção nao é o dono e nem o funcionario
		}
	}

