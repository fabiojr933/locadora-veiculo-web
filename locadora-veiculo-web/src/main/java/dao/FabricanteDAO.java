package dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.jpa.Transactional;

import modelo.Fabricante;
import service.NegocioException;

public class FabricanteDAO implements Serializable {
	
	@Inject
	EntityManager em;
	
	public void salvar(Fabricante fabricante) {
			em.merge(fabricante);		
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		
		return em.createQuery("from Fabricante").getResultList();
	}
	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException{
		try {
			Fabricante fabricanteTemp = em.find(Fabricante.class, fabricante.getCodigo());
			em.remove(fabricanteTemp);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return em.find(Fabricante.class, codigo);
		
	}
}
