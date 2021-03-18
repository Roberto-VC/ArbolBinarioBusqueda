/**
 * 
 */
package implementacion_a;

import estructura.ArbolBinarioBusqueda;
import estructura.IVisitar;
import estructura.NodoArbol;

/**
 * @author moise
 *
 */
public class ListarAutosArbol<K, T> implements IVisitar<K, T> {

	public ArbolBinarioBusqueda<Integer, Automovil> arbolAutos;
	
	public ListarAutosArbol(ArbolBinarioBusqueda<Integer, Automovil> _arbol) {
		arbolAutos = _arbol;
	}
	
	@Override
	public void VisitarNodo(NodoArbol<K, T> arbol) {
		GetKeySerie<Integer, Automovil> getSerie = new GetKeySerie<Integer, Automovil>();
		arbolAutos.Insert(getSerie.GetKey((Automovil)arbol._value), (Automovil)arbol._value);
	}
}
