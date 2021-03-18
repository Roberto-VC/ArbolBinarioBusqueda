/**
 * 
 */
package implementacion_a;

import estructura.IComparator;

/**
 * @author moise
 *
 */
public class ComparadorAutosXPlaca<K, T> implements IComparator<K, T> {

	@Override
	public int Compare(K abb1, K abb2) {
		String placa1 = (String)abb1;
		String placa2 = (String)abb2;
		return placa1.compareTo(placa2);
	}

}
