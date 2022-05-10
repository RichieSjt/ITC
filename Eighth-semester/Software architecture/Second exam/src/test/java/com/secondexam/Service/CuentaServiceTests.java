package com.secondexam.Service;

import com.secondexam.model.Cuenta;
import com.secondexam.repository.CuentaRepository;
import com.secondexam.service.CuentaService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CuentaServiceTests {
    CuentaService cuentaService = new CuentaService();
    CuentaRepository cuentaRepository = CuentaRepository.getInstance();

    @Before
    public void antesDeCadaPrueba() {
        // Borrando las cuentas y creando una sola cuenta antes de cada test
        cuentaRepository.resetCuentas(); 
        cuentaService.crearCuenta("CUENTA");
        cuentaService.depositar(0, 500);
    }

    @Test
    public void deberiaCrearUnaCuenta() {
        Cuenta cuenta = cuentaService.obtenerCuentaPorIndice(0);
        assertNotNull(cuenta);
    }

    @Test
    public void deberiaHacerUnDeposito() {
        cuentaService.depositar(0, 300);

        Cuenta cuenta = cuentaService.obtenerCuentaPorIndice(0);
        double montoActual = cuenta.getMonto();
        assertEquals(800, montoActual, 0.11);
    }
    
    @Test
    public void deberiaHacerUnRetiroSinComision() {
        cuentaService.retirar(0, 100, "Banco A", "Banco");
    
        Cuenta cuenta = cuentaService.obtenerCuentaPorIndice(0);
        double montoActual = cuenta.getMonto();
        assertEquals(400, montoActual, 0.11);
    }

    @Test
    public void deberiaHacerUnRetiroConComision() {
        cuentaService.retirar(0, 100, "Banco A", "ATM");
    
        Cuenta cuenta = cuentaService.obtenerCuentaPorIndice(0);
        double montoActual = cuenta.getMonto();
        assertEquals(370, montoActual, 0.11);
    }
}
