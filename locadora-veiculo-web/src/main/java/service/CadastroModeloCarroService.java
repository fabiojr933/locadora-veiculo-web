package service;

import java.io.Serializable;
import javax.inject.Inject;
import com.algaworks.curso.jpa2.util.jpa.Transactional;
import dao.ModeloCarroDAO;
import modelo.ModeloCarro;

public class CadastroModeloCarroService implements Serializable {

	@Inject
	private ModeloCarroDAO modeloCarroDAO;

	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException {
		if (modeloCarro.getDescricao() == null || modeloCarro.getDescricao().trim().equals("")) {
			throw new NegocioException("O nome do modelo é obrigatório.");
		}

		if (modeloCarro.getFabricante() == null) {
			throw new NegocioException("O fabricante e obrigatório");
		}

		this.modeloCarroDAO.salvar(modeloCarro);
	}
}
