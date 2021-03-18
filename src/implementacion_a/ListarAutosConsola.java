/**
 * 
 */
package implementacion_a;

import estructura.IVisitar;
import estructura.NodoArbol;
import implementacion_u.Estudiante;

/**
 * @author moise
 *
 */
public class ListarAutosConsola<K, T> implements IVisitar<K, T> {
	public void VisitarNodo(NodoArbol<K, T> arbol) {
		String listado = "";
		Automovil actual = (Automovil)arbol._value;
		listado = "Placa: " + actual.placa + " Marca: " + actual.marca + " Modelo: " + actual.modelo + " Serie: " + actual.serie; 
		System.out.println(listado);
	}
}
