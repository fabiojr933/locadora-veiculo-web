package service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.util.jpa.Transactional;

import dao.FabricanteDAO;
import modelo.Fabricante;

public class CadastroFabricante implements Serializable {
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	@Transactional
	public void salvar (Fabricante fabricante) throws NegocioException{		

		if(fabricante.getNome() == null && fabricante.getNome().trim().equals("")){
			throw new NegocioException("O nome do Fabricante é obrigadorio! ");
		}else {
		//SALVANDO O FABRICANTE		
		this.fabricanteDAO.salvar(fabricante);
		}
	}
}
