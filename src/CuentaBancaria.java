public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar la cantidad solicitada.");
        }
        saldo -= monto;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
    }

    public void transferir(CuentaBancaria cuentaDestino, double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        this.retirar(monto);
        cuentaDestino.depositar(monto);
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "NumeroCuenta='" + numeroCuenta + '\'' +
                ", Saldo=" + saldo +
                '}';
    }
    public class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String message) {
            super(message);
        }
    }


    public class MontoInvalidoException extends Exception {
        public MontoInvalidoException(String message) {
            super(message);
        }
    }
}