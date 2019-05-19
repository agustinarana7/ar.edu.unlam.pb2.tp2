/*
 * Desarrolladores:
 *  Julian M. Antonuccio
 *  Agustin Arana
*/

package ar.edu.unlam.pb2.tp2;

public class CuentaSueldo {

	//CONSTRUCTORES
	public CuentaSueldo() {
		this.saldo = 0.0;
		this.costoAdicional = 0.0;
	}
	
	public CuentaSueldo(Double pSaldo) {
		this.saldo = pSaldo;
		this.costoAdicional = 0.0;
	}
	
	//ATRIBUTOS
	protected Double saldo; 

	public Double obtenerSaldo() {
		return saldo;
	}

	public void establecerSaldo(Double pSaldo) {
		this.saldo = pSaldo;
	}
	
	protected Double costoAdicional;
	
	public Double obtenerCostoAdicional() {
		return costoAdicional;
	}
	
	public void establecerCostoAdicional(Double pCostoAdicional) {
		this.costoAdicional = pCostoAdicional;
	}
	
	//FUNCIONES	
	public void depositar(Double pSaldo){
		saldo += pSaldo;
	}
	
	public void extraer(Double pMonto){
		if(saldo >= pMonto)
		{
			saldo -= pMonto;
		}
		else
		{
			 throw new RuntimeException("Saldo insufuciente para realizar esta operación.");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaSueldo other = (CuentaSueldo) obj;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}

}
