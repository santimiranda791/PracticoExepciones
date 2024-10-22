import java.util.Scanner;

public class BancoApp {

    public static void main(String[] args) {
        // Crear algunas cuentas bancarias
        CuentaBancaria cuenta1 = new CuentaBancaria("12345", 1000.00);
        CuentaBancaria cuenta2 = new CuentaBancaria("67890", 500.00);

        // Mostrar el estado inicial de las cuentas
        System.out.println("Estado inicial de las cuentas:");
        System.out.println(cuenta1);
        System.out.println(cuenta2);

        // Crear un escáner para leer entradas del usuario
        Scanner scanner = new Scanner(System.in);

        try {
            // Operación de retiro
            System.out.println("\nIntentando retirar $200 de la cuenta 1...");
            cuenta1.retirar(200.00);
            System.out.println("Retiro exitoso. Nuevo saldo de la cuenta 1: " + cuenta1.getSaldo());

            // Operación de depósito
            System.out.println("\nIntentando depositar $300 en la cuenta 2...");
            cuenta2.depositar(300.00);
            System.out.println("Depósito exitoso. Nuevo saldo de la cuenta 2: " + cuenta2.getSaldo());

            // Operación de transferencia
            System.out.println("\nIntentando transferir $150 de la cuenta 1 a la cuenta 2...");
            cuenta1.transferir(cuenta2, 150.00);
            System.out.println("Transferencia exitosa. Nuevos saldos:");
            System.out.println("Cuenta 1: " + cuenta1.getSaldo());
            System.out.println("Cuenta 2: " + cuenta2.getSaldo());

        } catch (CuentaBancaria.SaldoInsuficienteException | CuentaBancaria.MontoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Mostrar el estado final de las cuentas
        System.out.println("\nEstado final de las cuentas:");
        System.out.println(cuenta1);
        System.out.println(cuenta2);
    }
}