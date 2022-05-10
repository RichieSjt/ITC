package com.secondexam.view;

import java.util.Scanner;

import com.secondexam.model.Cuenta;
import com.secondexam.service.CuentaService;

public class App {
    private CuentaService cuentaService;
    private Scanner sc;

    public App() {
        cuentaService = new CuentaService();
        sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Bienvenido al sistema de banca en linea");
        
        boolean exit = false;

        while(!exit) {    
            int selection = menuSeleccion("menuPrincipal", 4);

            switch(selection) {
                case 1: crearCuenta(); break;
                case 2: buscarCuentaPorIndice(); break;
                case 3: buscarCuentaPorNumero(); break;
                case 4: exit = true; break;
                default: break;
            }
        }
        //buscar una cuenta por indice o por número de cuenta
        //hacer depositos o retiros de la cuenta seleccionada.
    }

    private void menuPrincipal() {
        System.out.println("\nOperaciones:");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Buscar cuenta por índice");
        System.out.println("3. Buscar cuenta por número de cuenta");
        System.out.println("4. Salir");
    }

    private void menuCuentaSeleccionada() {
        System.out.println("\nOperaciones:");
        System.out.println("1. Depositar a cuenta");
        System.out.println("2. Retirar de cuenta");
        System.out.println("3. Regresar al menú principal");
    }

    private void imprimirMenu(String menu) {
        switch (menu) {
            case "menuPrincipal":
                menuPrincipal();
                break;
            case "menuCuentaSeleccionada":
                menuCuentaSeleccionada();
                break;
            default:
                System.out.println("Menú inválido");
        }
    }

    private int menuSeleccion(String menu, int numberOfOptions) {
        boolean isInvalid = true;
        int selection = -1;

        imprimirMenu(menu);

        // Validación de la selección proporcionada
        while (isInvalid) {
            System.out.print("\nSelección: ");
            selection = sc.hasNextInt() ? sc.nextInt() : -1;
            sc.nextLine(); 
            isInvalid = selection < 0 || selection > numberOfOptions;

            if (isInvalid) {
                System.out.println("\nSeleccione una opción válida");
                imprimirMenu(menu);
                sc.next();
            }
        }

        return selection;
    }

    private void crearCuenta() {
        System.out.println("\nCrear cuenta");
        System.out.print("Introduzca su nombre para crear una nueva cuenta: ");
        String nombre = sc.nextLine();
        cuentaService.crearCuenta(nombre);
    }

    private void buscarCuentaPorIndice() {
        System.out.println("\nBuscar cuenta por índice ");
        System.out.print("Indice de la cuenta: ");
        int index = sc.nextInt();
        sc.nextLine();

        Cuenta cuenta = cuentaService.obtenerCuentaPorIndice(index);

        if(cuenta == null) { return; }

        boolean exit = false;
        
        while(!exit) {
            int selection = menuSeleccion("menuCuentaSeleccionada", 3);

            switch (selection) {
                case 1: deposito(index); break;
                case 2: retiro(index); break;
                case 3: exit = true; break;
                default: break;
            }
        }
    }

    private void buscarCuentaPorNumero() {
        System.out.println("\nBuscar cuenta por número de cuenta");
        System.out.print("Número de cuenta: ");
        String numeroDeCuenta = sc.nextLine();

        Cuenta cuenta = cuentaService.obtenerCuentaPorNumeroCuenta(numeroDeCuenta);
        int index = cuentaService.obtenerIndiceDeCuenta(cuenta);

        if(cuenta == null) { return; }

        boolean exit = false;
        
        while(!exit) {
            int selection = menuSeleccion("menuCuentaSeleccionada", 3);
            
            switch (selection) {
                case 1: deposito(index); break;
                case 2: retiro(index); break;
                case 3: exit = true; break;
                default: break;
            }
        }
    }

    private void deposito(int index) {
        System.out.print("\nCantidad a depositar: ");
        String input = sc.nextLine();
        Double monto = Double.parseDouble(input);
        cuentaService.depositar(index, monto);
    }

    private void retiro(int index) {
        System.out.print("\nCantidad a retirar: ");
        String input = sc.nextLine();
        Double monto = Double.parseDouble(input);

        System.out.print("Banco del retiro (Banco A, Banco B, Banco C): ");
        String banco = sc.nextLine();

        System.out.print("Tipo de retiro (ATM, Banco): ");
        String tipo = sc.nextLine();
        cuentaService.retirar(index, monto, banco, tipo);
    }
}
