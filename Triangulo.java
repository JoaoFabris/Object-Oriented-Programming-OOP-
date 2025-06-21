// Classe Triângulo:
//Pense em um programa educacional que ensina geometria. Implemente uma classe Triângulo com atributos como base e altura,
// e um método para calcular a área. Essa prática será excelente para os alunos!

public class Triangulo {
    private double base;
    private double altura;
    
    public Triangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }
    
    public double getBase() {
        return base;
    }
    
    public void setBase(double base) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base deve ser maior que zero");
        }
        this.base = base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero");
        }
        this.altura = altura;
    }
    
    public double calcularArea() {
        return (base * altura) / 2;
    }
    
    @Override
    public String toString() {
        return String.format("Triângulo [Base: %.2f, Altura: %.2f] - Área: %.2f", 
                           base, altura, calcularArea());
    }
    
    public static void main(String[] args) {
        Triangulo triangulo1 = new Triangulo(10.0, 8.0);
        Triangulo triangulo2 = new Triangulo(5.0, 12.0);
        
        System.out.println(triangulo1);
        System.out.println(triangulo2);
        
        triangulo1.setBase(15.0);
        System.out.println("Após alterar base: " + triangulo1);
    }
}