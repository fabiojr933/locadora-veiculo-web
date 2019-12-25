package dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.algaworks.curso.jpa2.util.jpa.Transactional;
import modelo.ModeloCarro;
import service.NegocioException;

public class ModeloCarroDAO implements Serializable {

	@Inject
	private EntityManager em;

	public ModeloCarro buscarPeloCodigo(Long codigo) { // buscao pelo ID
		return em.find(ModeloCarro.class, codigo);
	}

	public void salvar(ModeloCarro modeloCarro) { // SALVAR
		em.merge(modeloCarro);
	}

	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() { // BUSCAR TODOS (LISTA)
		return em.createQuery("from ModeloCarro").getResultList();
	}

	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException { // EXCLUIR
		modeloCarro = buscarPeloCodigo(modeloCarro.getCodigo());
		try {
			em.remove(modeloCarro);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException("Este modelo nao pode se excluido");
		}
	}
}
