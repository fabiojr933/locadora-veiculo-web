package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import modelo.Fabricante;
import service.CadastroFabricante;

// esse pega os formularios da tela do cliente

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {
	
	@Inject
	private CadastroFabricante cadastroFabricante;	
	private Fabricante fabricante;
	
	
	//Metedo Salvar
	public void salvar(){
		try {
			this.cadastroFabricante.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo com sucesso");
			this.limpar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Metedo para limpar a tela
	@PostConstruct
	public void init() {
		this.limpar();
	}
	public void limpar() {
		this.fabricante = new Fabricante();
	}	
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
}
