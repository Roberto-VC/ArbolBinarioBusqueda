/**
 * 
 */
package implementacion_a;

import estructura.IKeyCalculator;

/**
 * @author moise
 *
 */
public class GetKeyPlaca<K, T> implements IKeyCalculator<K, T> {

	@Override
	public K GetKey(T value) {
		Automovil autoActual = (Automovil)value;
		return (K)autoActual.placa;
	}

}
