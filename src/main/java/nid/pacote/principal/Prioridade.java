package nid.pacote.principal;

public enum Prioridade {
	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA"); // COLOCANDO UM VALOR FIXO USANDO ENUM
	
	private Integer codigo;
	private String descricao;
	private Prioridade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static Prioridade toEnum(Integer cod) { // se o perfil for nullo retorne null
		if(cod == null) {
			return null;
		}
		for(Prioridade x : Prioridade.values()) {
			if (cod.equals(x.getCodigo())) {
				return x; // se o cod for valido com os valores dono ou funcionario retornar X
			}
		}
		throw new IllegalArgumentException("Prioridade invalido"); // exeção nao é o dono e nem o funcionario
		}
	}

