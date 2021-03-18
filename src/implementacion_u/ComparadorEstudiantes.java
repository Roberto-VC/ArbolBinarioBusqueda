/**
 * 
 */
package implementacion_u;

import estructura.IComparator;

/**
 * @author moise
 *
 */
public class ComparadorEstudiantes<K, T> implements IComparator<K, T> {

	@Override
	public int Compare(K abb1, K abb2) {
		String ID_estudiante1 = (String)abb1;
		String ID_estudiante2 = (String)abb2;
		return ID_estudiante1.compareTo(ID_estudiante2);
	}
	
}
