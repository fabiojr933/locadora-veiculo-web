package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import dao.FabricanteDAO;
import modelo.Categoria;
import modelo.Fabricante;
import modelo.ModeloCarro;
import service.CadastroModeloCarroService;
@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable{
	
	private static final Long serialVersionUID = 1l;
	private ModeloCarro modeloCarro;
	private List<Categoria> categorias;
	private List<Fabricante>fabricantes;
	
	
	@Inject
	private CadastroModeloCarroService cadastroModeloCarroService;
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	public void salvar() {
		try {
			this.cadastroModeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo de carro salvo com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("erro ao salvar" + e.getMessage());
		}
		this.limpar();
	}
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.fabricantes = fabricanteDAO.buscarTodos();
		
	}
	public void limpar() {
		this.modeloCarro = new ModeloCarro();
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	
	
}
