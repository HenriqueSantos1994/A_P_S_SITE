package Model;

import Model.Industria;

public class Industria {
    private int idIndustria;
    private String nomeIndustria;
    private int localizacao;

    public int getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(int localizacao) {
		this.localizacao = localizacao;
	}

	public int getIdIndustria() {
        return idIndustria;
    }

    public void setIdIndustria(int idIndustria) {
        this.idIndustria = idIndustria;
    }

    public String getNomeIndustria() {
        return nomeIndustria;
    }

    public void setNomeIndustria(String nomeIndustria) {
        this.nomeIndustria = nomeIndustria;
    }
}
