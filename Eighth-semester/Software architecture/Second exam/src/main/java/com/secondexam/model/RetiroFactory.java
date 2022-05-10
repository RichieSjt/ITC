package com.secondexam.model;

public class RetiroFactory {
    // Decidí utilizar el patrón de factory ya que para este sistema contamos con dos posibles
    // tipos de retiros, un retiro realizado directamente en el banco (Sin comisión) y un retiro
    // realizado en un ATM (Con una determinada comisión dependiendo del banco), por lo que,
    // dependiendo del tipo de retiro se regresa un objeto diferente.  

    public Retiro crearRetiro(String tipo, double monto, String banco) {

        if(tipo.equals("Banco")) {
            Retiro retiro = new Retiro();
            retiro.setMonto(monto);
            retiro.setBanco(banco);
            return retiro;
        }

        if(tipo.equals("ATM")) {
            RetiroAtm retiroaAtm = new RetiroAtm();
            retiroaAtm.setBanco(banco);
            retiroaAtm.setMonto(monto);
    
            if (banco.equalsIgnoreCase("Banco A")) {
                retiroaAtm.setComision(30);
            }
            if (banco.equalsIgnoreCase("Banco B")) {
                retiroaAtm.setComision(15);
            }
            if (banco.equalsIgnoreCase("Banco C")) {
                retiroaAtm.setComision(10);
            }
            return retiroaAtm;
        }

        return null;
    }
}
