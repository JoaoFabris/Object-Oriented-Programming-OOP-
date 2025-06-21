//Classe Conta Bancária:
//Imagine que você está desenvolvendo um aplicativo de finanças pessoais. Crie uma classe ContaBancária com atributos como saldo e número da conta,
// e métodos para depositar e sacar. Isso ajudará os usuários a gerenciar suas economias!

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private String titular;
    
    public ContaBancaria(String numeroConta, String titular) {
        setNumeroConta(numeroConta);
        setTitular(titular);
        this.saldo = 0.0;
    }
    
    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        setNumeroConta(numeroConta);
        setTitular(titular);
        setSaldo(saldoInicial);
    }
    
    public String getNumeroConta() {
        return numeroConta;
    }
    
    public void setNumeroConta(String numeroConta) {
        if (numeroConta == null || numeroConta.trim().isEmpty()) {
            throw new IllegalArgumentException("Número da conta não pode ser vazio");
        }
        this.numeroConta = numeroConta.trim();
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    private void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo");
        }
        this.saldo = saldo;
    }
    
    public String getTitular() {
        return titular;
    }
    
    public void setTitular(String titular) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("Titular não pode ser vazio");
        }
        this.titular = titular.trim();
    }
    
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        saldo += valor;
        System.out.println("Depósito realizado: R$ " + String.format("%.2f", valor));
        System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
    }
    
    public boolean sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return false;
        }
        saldo -= valor;
        System.out.println("Saque realizado: R$ " + String.format("%.2f", valor));
        System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
        return true;
    }
    
    public boolean transferir(ContaBancaria contaDestino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência!");
            return false;
        }
        saldo -= valor;
        contaDestino.saldo += valor;
        System.out.println("Transferência realizada: R$ " + String.format("%.2f", valor));
        System.out.println("Para conta: " + contaDestino.getNumeroConta());
        return true;
    }
    
    @Override
    public String toString() {
        return String.format("Conta: %s | Titular: %s | Saldo: R$ %.2f", 
                           numeroConta, titular, saldo);
    }
    
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("12345-6", "João Silva");
        ContaBancaria conta2 = new ContaBancaria("98765-4", "Maria Santos", 500.00);
        
        System.out.println("Contas criadas:");
        System.out.println(conta1);
        System.out.println(conta2);
        System.out.println();
        
        conta1.depositar(1000.00);
        System.out.println();
        
        conta1.sacar(200.00);
        System.out.println();
        
        conta1.transferir(conta2, 300.00);
        System.out.println();
        
        System.out.println("Saldos finais:");
        System.out.println(conta1);
        System.out.println(conta2);
    }
}