package ar.edu.unlam.pb2.tp2;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class CuentaCorrienteTest {
	
	@Test
	public void testQueDepositaEnUnaCuentaCorriente()
	{
		//Preparaci�n
		Double deposito = 4000.0;
		Double valorEsperado = 4000.0;
		
		//Ejecuci�n
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.depositar(deposito);
		
		//Contrastaci�n
		Assert.assertEquals(true, cuenta.obtenerSaldo().equals(valorEsperado));
	}
	
	@Test
	public void testQueExtraeDeUnaCuentaCorriente()
	{
		//Preparaci�n
		Double deposito = 100.0;
		Double extraccion = 200.0;
		Double descubierto = 150.0;
		Double porcentajeComision = 0.05;
		Double valorEsperado = -105.0;
		
		//Ejecuci�n
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.depositar(deposito);
		cuenta.establecerDescubierto(descubierto);
		cuenta.establecerCostoAdicional(porcentajeComision);
		cuenta.extraer(extraccion);
		
		//Contrastaci�n
		Assert.assertEquals(true, cuenta.obtenerSaldo().equals(valorEsperado));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testQueExtraeDeUnaCuentaCorrienteMasDeLoDisponible()
	{
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Saldo insufuciente para realizar esta operaci�n.");
	    
		//Preparaci�n
		Double deposito = 100.0;
		Double extraccion = 300.0;
		Double descubierto = 150.0;
		Double porcentajeComision = 0.05;
		
		//Ejecuci�n
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.depositar(deposito);
		cuenta.establecerDescubierto(descubierto);
		cuenta.establecerCostoAdicional(porcentajeComision);
		cuenta.extraer(extraccion);
		
	}
}
