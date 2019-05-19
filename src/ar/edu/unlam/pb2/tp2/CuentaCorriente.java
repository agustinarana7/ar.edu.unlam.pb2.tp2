package ar.edu.unlam.pb2.tp2;

public class CuentaCorriente extends CuentaSueldo {

	//CONSTRUCTORES
	public CuentaCorriente()
	{
	}

	//ATRIBUTOS
	private Double descubierto; //Limite adicional que otorga el banco.
	
	public Double obtenerDescubierto() {
		return descubierto;
	}

	public void establecerDescubierto(Double pDescubierto) {
		this.descubierto = pDescubierto;
	}
	
	
	//FUNCIONES
	@Override
	public void extraer(Double pMonto){
		Double saldoActual = this.obtenerSaldo();
		if((saldoActual + this.descubierto) < pMonto) //No alcanza el sueldo mas el descubierto
		{
			 throw new RuntimeException("Saldo insufuciente para realizar esta operación.");
		}
		else if(this.obtenerSaldo() >= pMonto) //El sueldo alcanza por si solo
		{
			//Establezco el sueldo
			this.establecerSaldo(saldoActual - pMonto);
		}
		else //Tengo que utilizar el sueldo y el descubierto
		{
			//Formula para obtener el descubierto utilizado
			Double descubiertoUtilizado = this.descubierto - ((saldoActual + this.descubierto) - pMonto);
			//Se le va a pasar 0.05 de comision siendo 1 el 100%
			Double comision = descubiertoUtilizado * this.obtenerCostoAdicional();
			//Establezco el sueldo
			this.establecerSaldo((saldoActual - pMonto) - comision);
		}
	}


}
