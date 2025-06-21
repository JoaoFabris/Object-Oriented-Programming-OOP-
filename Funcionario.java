//Classe Funcionário:
//Por fim, pense em um sistema de recursos humanos. Implemente uma classe Funcionário com características como nome, cargo e salário, e um método para calcular aumento de salário.
// Isso ajudará a gerenciar a equipe de forma eficaz!

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    
    public Funcionario(String nome, String cargo, double salario) {
        setNome(nome);
        setCargo(cargo);
        setSalario(salario);
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome.trim();
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("Cargo não pode ser vazio");
        }
        this.cargo = cargo.trim();
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        this.salario = salario;
    }
    
    public void calcularAumento(double percentual) {
        if (percentual < 0) {
            throw new IllegalArgumentException("Percentual não pode ser negativo");
        }
        double valorAumento = salario * (percentual / 100);
        double novoSalario = salario + valorAumento;
        
        System.out.println("Aumento aplicado para " + nome + ":");
        System.out.println("Salário anterior: R$ " + String.format("%.2f", salario));
        System.out.println("Percentual de aumento: " + percentual + "%");
        System.out.println("Valor do aumento: R$ " + String.format("%.2f", valorAumento));
        System.out.println("Novo salário: R$ " + String.format("%.2f", novoSalario));
        
        salario = novoSalario;
    }
    
    @Override
    public String toString() {
        return nome + " - " + cargo + " - R$ " + String.format("%.2f", salario);
    }
    
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario("João Silva", "Desenvolvedor", 5000.00);
        Funcionario func2 = new Funcionario("Maria Santos", "Analista", 4500.00);
        
        System.out.println("Funcionários:");
        System.out.println(func1);
        System.out.println(func2);
        System.out.println();
        
        func1.calcularAumento(10.0);
        System.out.println();
        
        func2.calcularAumento(15.0);
        System.out.println();
        
        System.out.println("Funcionários após aumento:");
        System.out.println(func1);
        System.out.println(func2);
    }
}