package com.secondexam.repository;

import com.secondexam.model.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaRepository {
    private static CuentaRepository instance;
    private List<Cuenta> cuentas;

    private CuentaRepository(){
        cuentas = new ArrayList<>();
    }

    public Cuenta obtenerCuentaPorIndice(int index){
        return cuentas.get(index);
    }

    public int obtenerIndiceDeCuenta(Cuenta cuenta) {
        return cuentas.indexOf(cuenta); 
    }

    public void agregarCuenta(Cuenta c){
        cuentas.add(c);
    }

    public Cuenta obtenerCuentaPorNumeroCuenta(String numeroDeCuenta){
        for (Cuenta c:
             cuentas) {
            if(c.getNumeroDeCuenta().equalsIgnoreCase(numeroDeCuenta)){
                return c;
            }
        }
        return null;
    }

    public void actualizarMontoDeCuenta(int index, double monto){
        Cuenta cuenta = obtenerCuentaPorIndice(index);
        cuenta.setMonto( monto);
    }

    // Patrón singleton, solo hay una instancia de la clase
    public static CuentaRepository getInstance() {
        if (instance == null) {
            // Si la instancia es null, se inicializa
            instance = new CuentaRepository();
        }
        return instance;
    }
}
