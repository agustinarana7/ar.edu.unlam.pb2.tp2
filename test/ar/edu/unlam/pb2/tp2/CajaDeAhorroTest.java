package ar.edu.unlam.pb2.tp2;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class CajaDeAhorroTest {
	
	@Test
	public void testQueDepositaEnUnaCajaDeAhorro()
	{
		//Preparaci�n
		Double deposito = 4000.0;
		Double valorEsperado = 4000.0;

		//Ejecuci�n
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(deposito);
		
		
		//Contrastaci�n
		Assert.assertEquals(true, cuenta.obtenerSaldo().equals(valorEsperado));
	}
	
	@Test
	public void testQueExtraeDeUnaCajaDeAhorro()
	{
		//Preparaci�n
		Double deposito = 4000.0;
		Double extraccion = 100.0;
		Double costoAdicional = 6.0;
		Integer cantidadDeExtracciones = 10;
		Double valorEsperado = 2910.0;
		
		
		//Ejecuci�n
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.establecerCostoAdicional(costoAdicional);
		cuenta.depositar(deposito);
		
	    for(int i = 1; i<=cantidadDeExtracciones; i++)
	    {
			cuenta.extraer(extraccion);
        }
	    

		//Contrastaci�n
		Assert.assertEquals(true, cuenta.obtenerSaldo().equals(valorEsperado));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testQueExtraeDeUnaCajaDeAhorroMasDeLoDisponible()
	{
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Saldo insufuciente para realizar esta operaci�n.");
	    
		//Preparaci�n
		Double deposito = 1000.0;
		Double extraccion = 100.0;
		Double costoAdicional = 6.0;
		Integer cantidadDeExtracciones = 10;
		
		
		//Ejecuci�n
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.establecerCostoAdicional(costoAdicional);
		cuenta.depositar(deposito);
		
	    for(int i = 1; i<=cantidadDeExtracciones; i++)
	    {
			cuenta.extraer(extraccion);
        }
		
	}
}
