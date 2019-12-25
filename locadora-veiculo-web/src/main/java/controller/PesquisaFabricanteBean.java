package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import dao.FabricanteDAO;
import modelo.Fabricante;
@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1l;

	@Inject
	FabricanteDAO fabricanteDAO;

	private List<Fabricante> fabricantes = new ArrayList<>();
	private Fabricante fabricanteSelecionado;

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	// METEDO EXCLUIR
	public void excluir() {
		try {
			fabricanteDAO.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("FABRICANTE " + fabricanteSelecionado.getNome() + " excluido");
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Erro ao Excluir");
			e.printStackTrace();
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	@PostConstruct
	public void inicializar() {
		fabricantes = fabricanteDAO.buscarTodos();
	}
}
