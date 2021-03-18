/**
 * 
 */
package implementacion_a;

import java.util.Hashtable;

import estructura.IVisitar;
import estructura.NodoArbol;

/**
 * @author moise
 *
 */
public class ListarAutosHashTable<K, T> implements IVisitar<K, T> {

	public Hashtable<String, Automovil> Autos;
	
	public ListarAutosHashTable() {
		Autos = new Hashtable<String, Automovil>();
	}
	
	@Override
	public void VisitarNodo(NodoArbol<K, T> arbol) {
		Autos.put((String)arbol._key, (Automovil)arbol._value);
		
	}

}
