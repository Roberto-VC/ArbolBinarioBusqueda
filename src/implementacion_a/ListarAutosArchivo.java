/**
 * 
 */
package implementacion_a;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import estructura.IVisitar;
import estructura.NodoArbol;

/**
 * @author moise
 *
 */
public class ListarAutosArchivo<K, T> implements IVisitar<K, T> {

	File archivo;
	String listadoElementos;
	
	public ListarAutosArchivo(String path) {
		archivo = new File(path);
		listadoElementos = "";
	}

	@Override
	public void VisitarNodo(NodoArbol<K, T> arbol) {
		Automovil actual = (Automovil)arbol._value;
		//ListadoElementos = ListadoElementos + "";
		listadoElementos += "Placa: " + actual.placa + " Marca: " + actual.marca + " Modelo: " + actual.modelo + " Serie: " + actual.serie + "\r\n"; 
		try {
			FileWriter fw = new FileWriter(archivo, false);
			fw.write(listadoElementos );
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
