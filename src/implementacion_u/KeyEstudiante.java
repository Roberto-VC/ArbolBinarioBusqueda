/**
 * 
 */
package implementacion_u;

import estructura.IKeyCalculator;

/**
 * @author moise
 *
 */
public class KeyEstudiante<K, T> implements IKeyCalculator<K, T> {

	@Override
	public K GetKey(T value) {
		Estudiante actual = (Estudiante)value;
		return (K)actual.ID;
	}

}
