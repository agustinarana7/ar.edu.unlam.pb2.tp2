package ar.edu.unlam.pb2.tp2;

public class CajaDeAhorro extends CuentaSueldo {

	//CONSTRUCTOR
	public CajaDeAhorro () {
		this.contador = 0;
	}
	
	//ATRIBUTOS
	private Integer contador;
	
	//FUNCIONES
	@Override
	public void extraer(Double pMonto){
		contador++;
		Double saldoActual = this.obtenerSaldo();
		if(contador > 5) //Si es m�s de la quinta extracci�n, se cobra adicional.
		{
			//Se cobra un costo adicional por extracci�n
			pMonto += this.obtenerCostoAdicional() * (contador-5);
		}

		if(saldoActual >= pMonto)
		{
			//Establezco el sueldo
			this.establecerSaldo(saldoActual - pMonto);
		}
		else
		{
			 throw new RuntimeException("Saldo insufuciente para realizar esta operaci�n.");
		}
	}

}
