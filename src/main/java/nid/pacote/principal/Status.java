package nid.pacote.principal;

public enum Status {
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO"); // COLOCANDO UM VALOR FIXO USANDO ENUM
	
	private Integer codigo;
	private String descricao;
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) { // se o perfil for nullo retorne null
		if(cod == null) {
			return null;
		}
		for(Status x : Status.values()) {
			if (cod.equals(x.getCodigo())) {
				return x; // se o cod for valido com os valores dono ou funcionario retornar X
			}
		}
		throw new IllegalArgumentException("Status invalido"); // exeção nao é o dono e nem o funcionario
		}
	}

