package ar.edu.unlam.pb2.tp2;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class CuentaCorrienteTest {
	
	@Test
	public void testQueDepositaEnUnaCuentaCorriente()
	{
		//Preparación
		Double deposito = 4000.0;
		Double valorEsperado = 4000.0;
		
		//Ejecución
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.depositar(deposito);
		
		//Contrastación
		Assert.assertEquals(true, cuenta.obtenerSaldo().equals(valorEsperado));
	}
	
	@Test
	public void testQueExtraeDeUnaCuentaCorriente()
	{
		//Preparación
		Double deposito = 100.0;
		Double extraccion = 200.0;
		Double descubierto = 150.0;
		Double porcentajeComision = 0.05;
		Double valorEsperado = -105.0;
		
		//Ejecución
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.depositar(deposito);
		cuenta.establecerDescubierto(descubierto);
		cuenta.establecerCostoAdicional(porcentajeComision);
		cuenta.extraer(extraccion);
		
		//Contrastación
		Assert.assertEquals(true, cuenta.obtenerSaldo().equals(valorEsperado));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testQueExtraeDeUnaCuentaCorrienteMasDeLoDisponible()
	{
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Saldo insufuciente para realizar esta operación.");
	    
		//Preparación
		Double deposito = 100.0;
		Double extraccion = 300.0;
		Double descubierto = 150.0;
		Double porcentajeComision = 0.05;
		
		//Ejecución
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.depositar(deposito);
		cuenta.establecerDescubierto(descubierto);
		cuenta.establecerCostoAdicional(porcentajeComision);
		cuenta.extraer(extraccion);
		
	}
}
