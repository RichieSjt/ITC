package com.secondexam.repository;

import com.secondexam.model.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaRepository {
    // Se optó por usar el patrón de diseño singleton para el repository de nuestra cuenta
    // ya que al ser el equivalente a nuestra base de datos, se requiere que solo exista una
    // instancia de esta a la vez.
    private static CuentaRepository instance;
    private List<Cuenta> cuentas;

    private CuentaRepository(){
        cuentas = new ArrayList<>();
    }

    public void resetCuentas() {
        cuentas.clear();
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

    public static CuentaRepository getInstance() {
        // Patrón singleton, solo hay una instancia de la clase

        if (instance == null) {
            // Si la instancia no existe, se inicializa
            instance = new CuentaRepository();
        }
        return instance;
    }
}
