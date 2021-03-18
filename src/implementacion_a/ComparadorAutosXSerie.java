/**
 * 
 */
package implementacion_a;

import estructura.IComparator;

/**
 * @author moise
 *
 */
public class ComparadorAutosXSerie<K, T> implements IComparator<K, T> {

	@Override
	public int Compare(K abb1, K abb2) {
		int serie1 = (int)abb1;
		int serie2 = (int)abb2;
		int resultado = 0;
		
		if (serie1 > serie2) {
			resultado = 1;
		} else if (serie1 < serie2) {
			resultado = -1;
		}
		
		return resultado;
	}

}
