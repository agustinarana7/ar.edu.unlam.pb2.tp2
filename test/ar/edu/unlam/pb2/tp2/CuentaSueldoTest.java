package ar.edu.unlam.pb2.tp2;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class CuentaSueldoTest {

	@Test
	public void testQueDepositaEnUnaCuentaSueldo()
	{
		//Preparaci�n
		Double deposito = 4000.0;
		Double valorEsperado = 4000.0;
		
		//Ejecuci�n
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(deposito);
		
		//Contrastaci�n
		Assert.assertEquals(true, cuenta.obtenerSaldo().equals(valorEsperado));
	}
	
	@Test
	public void testQueExtraeDeUnaCuentaSueldo()
	{
		//Preparaci�n
		Double deposito = 4000.0;
		Double extraccion = 500.0;
		Double valorEsperado = 3500.0;
		
		//Ejecuci�n
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(deposito);
		cuenta.extraer(extraccion);
		
		//Contrastaci�n
		Assert.assertEquals(true, cuenta.obtenerSaldo().equals(valorEsperado));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testQueExtraeDeUnaCuentaSueldoMasDeLoDisponible()
	{
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Saldo insufuciente para realizar esta operaci�n.");
	    
		//Preparaci�n
		Double deposito = 4000.0;
		Double extraccion = 4500.0;
		
		//Ejecuci�n
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(deposito);
		cuenta.extraer(extraccion);
		
	}
}
