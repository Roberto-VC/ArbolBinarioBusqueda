/**
 * 
 */
package implementacion_u;

import estructura.IVisitar;
import estructura.NodoArbol;

/**
 * @author moise
 *
 */
public class ListarEstudiante<K, T> implements IVisitar<K, T> {

	@Override
	public void VisitarNodo(NodoArbol<K, T> arbol) {
		String listado = "";
		Estudiante actual = (Estudiante)arbol._value;
		listado = "Carnet: " + actual.ID + " Nombre: " + actual.Nombre + " Edad: " + actual.Edad; 
		
		System.out.println(listado);
	}
	
}
