package com.secondexam.service;

import com.secondexam.model.Cuenta;
import com.secondexam.model.Retiro;
import com.secondexam.model.RetiroFactory;
import com.secondexam.repository.CuentaRepository;
import java.util.Random;

public class CuentaService {
    //Utilizar Singleton de Cuenta Repository para hacer uso de sus métodos e implementar todos los métodos faltantes
    public CuentaRepository cuentaRepository;
    
    public CuentaService() {
        cuentaRepository = CuentaRepository.getInstance();
    }

    public void depositar(int index, double monto){
        Cuenta cuenta = cuentaRepository.obtenerCuentaPorIndice(index);
        double montoActual = cuenta.getMonto();
        double montoFinal = montoActual + monto;

        cuentaRepository.actualizarMontoDeCuenta(index, montoFinal);
        System.out.println("\nSe depositó la cantidad $" + monto + " a la cuenta '" + cuenta.getNumeroDeCuenta() + "'");
        System.out.println("El monto final de la cuenta es de: $" + cuenta.getMonto());
    }

    public void retirar(int index, double monto, String banco, String tipo){
        Cuenta cuenta = cuentaRepository.obtenerCuentaPorIndice(index);
        double montoActual = cuenta.getMonto();
        
        RetiroFactory retiroFactory = new RetiroFactory();
        Retiro retiro = retiroFactory.crearRetiro(tipo, monto, banco);

        double montoFinal = montoActual - retiro.getMonto();

        if (montoFinal < 0) {
            System.out.println("\nFondos insuficientes");
            return;
        }

        cuentaRepository.actualizarMontoDeCuenta(index, montoFinal);
        System.out.println("\nSe retiró la cantidad $" + monto + " de la cuenta '" + cuenta.getNumeroDeCuenta() + "'");
        System.out.println("El monto final del retiro incluyendo comisiones es de: $" + retiro.getMonto());
        System.out.println("El monto final de la cuenta es de: $" + cuenta.getMonto());

    }

    public void agregarCuenta(Cuenta c){
        cuentaRepository.agregarCuenta(c);
    }

    public void crearCuenta(String nombre) {
        Cuenta cuenta = new Cuenta();
        Random random = new Random();
        cuenta.setNumeroDeCuenta(random.nextInt(10000) + nombre);
        cuenta.setNombre(nombre);
        cuenta.setMonto(0);

        System.out.println("\nCuenta creada exitosamente");
        System.out.println(cuenta.toString());
        
        agregarCuenta(cuenta);
    }

    public Cuenta obtenerCuentaPorIndice(int index) {
        Cuenta cuenta = null;

        try {
            cuenta = cuentaRepository.obtenerCuentaPorIndice(index);
            System.out.println("\nDatos de cuenta en el índice " + index);
            System.out.println(cuenta.toString());
        } catch (Exception e) {
            System.out.println("\nNo se encontró ninguna cuenta en el índice seleccionado.");
        }

        return cuenta;
    }

    public Cuenta obtenerCuentaPorNumeroCuenta(String numeroDeCuenta) {
        Cuenta cuenta = cuentaRepository.obtenerCuentaPorNumeroCuenta(numeroDeCuenta);
        
        if(cuenta == null) {
            System.out.println("\nNo se encontró ninguna cuenta con el número de cuenta proporcionado.");
        }   else {
            System.out.println("\nDatos de cuenta");
            System.out.println(cuenta.toString());
        }
        
        return cuenta;
    }

    public int obtenerIndiceDeCuenta(Cuenta cuenta) {
        return cuentaRepository.obtenerIndiceDeCuenta(cuenta);
    }
}
