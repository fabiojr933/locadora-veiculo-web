package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

import dao.FabricanteDAO;
import modelo.Fabricante;

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {
	private FabricanteDAO fabricanteDAO;
	
	public FabricanteConverter() {
		this.fabricanteDAO = CDIServiceLocator.getBean(FabricanteDAO.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante retorno = null;

		if (value != null) {
			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Fabricante) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}
}
