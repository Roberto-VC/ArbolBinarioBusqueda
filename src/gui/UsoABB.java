/**
 * 
 */
package gui;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;

import estructura.ArbolBinarioBusqueda;
import estructura.IKeyCalculator;
import implementacion_a.Automovil;
import implementacion_a.ComparadorAutosXPlaca;
import implementacion_a.ComparadorAutosXSerie;
import implementacion_a.GetKeyPlaca;
import implementacion_a.GetKeySerie;
import implementacion_a.ListarAutosArbol;
import implementacion_a.ListarAutosArchivo;
import implementacion_a.ListarAutosConsola;
import implementacion_a.ListarAutosHashTable;
import implementacion_u.ComparadorEstudiantes;
import implementacion_u.Estudiante;
import implementacion_u.KeyEstudiante;
import implementacion_u.ListarEstudiante;

/**
 * @author moise
 *
 */
public class UsoABB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArbolBinarioBusqueda<String, Estudiante> arbolEstudiantes;
		arbolEstudiantes = new ArbolBinarioBusqueda<String, Estudiante>(
				new ComparadorEstudiantes<String, Estudiante>()
				, new KeyEstudiante<String, Estudiante>()
				);
		
		
		Estudiante miEstudiante2 = new Estudiante("cbc123456", "Antonio Gonzalez", 31);
		Estudiante miEstudiante1 = new Estudiante("alo171164", "Moises Alonso", 30);
		Estudiante miEstudiante3 = new Estudiante("mlo171164", "Fake estudiante", 20);
		Estudiante miEstudiante4 = new Estudiante("zlo171164", "Fake1 estudiante1", 20);
		
		arbolEstudiantes.Insert(miEstudiante2.ID, miEstudiante2);
		arbolEstudiantes.Insert(miEstudiante1.ID, miEstudiante1);
		arbolEstudiantes.Insert(miEstudiante3.ID, miEstudiante3);
		arbolEstudiantes.Insert(miEstudiante4.ID, miEstudiante4);

		arbolEstudiantes.InOrder(new ListarEstudiante<String, Estudiante>(), arbolEstudiantes._raiz);
		
		arbolEstudiantes.PostOrder(new ListarEstudiante<String, Estudiante>(), arbolEstudiantes._raiz);
		
		/** Arbol utilizando la placa **/
		ArbolBinarioBusqueda<String, Automovil> arbolAutomovil;
		
		arbolAutomovil = new ArbolBinarioBusqueda<String, Automovil>(
				new ComparadorAutosXPlaca()
				, new GetKeyPlaca()
				);
		
		try {
			File miArchivo = new File("C:\\Calif\\Auto.csv");
			Scanner myReader = new Scanner(miArchivo);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] values = line.split(",");
				arbolAutomovil.Insert(values[0], new Automovil(
						values[0]
						, values[1]
						, Integer.parseInt(values[2])
						, Integer.parseInt(values[3])
					)
				);
			}
		}catch(IOException e) {
			System.out.print("Error" + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(" *** LISTADO DE AUTOS EN CONSOLA (IN ORDER)*** ");
		arbolAutomovil.InOrder(new ListarAutosConsola(), arbolAutomovil._raiz);
		
		System.out.println(" *** LISTADO DE AUTOS EN ARCHIVO (IN ORDER)*** ");
		arbolAutomovil.InOrder(new ListarAutosArchivo("Ejemplo.txt"), arbolAutomovil._raiz);
		
		ListarAutosHashTable autosHash = new ListarAutosHashTable();
		arbolAutomovil.InOrder(autosHash, arbolAutomovil._raiz);
		
		System.out.println(" *** LISTADO DE AUTOS A TRAVÉS DE HASH*** ");
		Enumeration keys = autosHash.Autos.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			System.out.println("Llave (Placa) :" + key 
					+ " Marca: " + ((Automovil)autosHash.Autos.get(key)).marca
					+ " Modelo: " + ((Automovil)autosHash.Autos.get(key)).modelo
					+ " Serie: " + ((Automovil)autosHash.Autos.get(key)).serie
					);
		}
		
		/*Arbol utilizando la serie*/
		ArbolBinarioBusqueda<Integer, Automovil> arbolAutomovil2;
		
		arbolAutomovil2 = new ArbolBinarioBusqueda<Integer, Automovil>(
				new ComparadorAutosXSerie()
				, new GetKeySerie()
				);
		
		ListarAutosArbol autosArbol = new ListarAutosArbol(arbolAutomovil2);
		
		arbolAutomovil.InOrder(autosArbol, arbolAutomovil._raiz);
		
		System.out.println(" *** LISTADO DE AUTOS EN CONSOLA X SERIE (IN ORDER)*** ");
		
		arbolAutomovil2.InOrder(new ListarAutosConsola(), arbolAutomovil2._raiz);
		
	}

}
