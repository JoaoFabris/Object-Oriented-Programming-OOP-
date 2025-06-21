//Classe Retângulo:
//Considere a criação de um programa para calcular áreas de terrenos. Implemente uma classe Retângulo com atributos como comprimento e largura,
// e métodos para calcular a área e o perímetro. Esse conhecimento será útil para muitos!

public class Retangulo {
    private double comprimento;
    private double largura;
    
    public Retangulo() {
        this.comprimento = 1.0;
        this.largura = 1.0;
    }
    
    public Retangulo(double comprimento, double largura) {
        setComprimento(comprimento);
        setLargura(largura);
    }
    
    public double getComprimento() {
        return comprimento;
    }
    
    public void setComprimento(double comprimento) {
        if (comprimento <= 0) {
            throw new IllegalArgumentException("Comprimento deve ser maior que zero");
        }
        this.comprimento = comprimento;
    }
    
    public double getLargura() {
        return largura;
    }
    
    public void setLargura(double largura) {
        if (largura <= 0) {
            throw new IllegalArgumentException("Largura deve ser maior que zero");
        }
        this.largura = largura;
    }
    
    public double calcularArea() {
        return comprimento * largura;
    }
    
    public double calcularPerimetro() {
        return 2 * (comprimento + largura);
    }
    
    public boolean ehQuadrado() {
        return comprimento == largura;
    }
    
    public double calcularDiagonal() {
        return Math.sqrt(Math.pow(comprimento, 2) + Math.pow(largura, 2));
    }
    
    public String getTipoTerreno() {
        double area = calcularArea();
        if (area < 100) {
            return "Terreno pequeno";
        } else if (area <= 500) {
            return "Terreno médio";
        } else {
            return "Terreno grande";
        }
    }
    
    @Override
    public String toString() {
        return String.format("Retângulo [%.2f x %.2f] - Área: %.2f m², Perímetro: %.2f m", 
                           comprimento, largura, calcularArea(), calcularPerimetro());
    }
    
    public static void main(String[] args) {
        Retangulo terreno1 = new Retangulo();
        Retangulo terreno2 = new Retangulo(15.0, 20.0);
        Retangulo terreno3 = new Retangulo(10.0, 10.0);
        
        System.out.println("Terreno padrão: " + terreno1);
        System.out.println("Tipo: " + terreno1.getTipoTerreno());
        System.out.println();
        
        System.out.println("Terreno 15x20: " + terreno2);
        System.out.println("Tipo: " + terreno2.getTipoTerreno());
        System.out.println("Diagonal: " + String.format("%.2f m", terreno2.calcularDiagonal()));
        System.out.println();
        
        System.out.println("Terreno 10x10: " + terreno3);
        System.out.println("É quadrado: " + terreno3.ehQuadrado());
        System.out.println("Tipo: " + terreno3.getTipoTerreno());
        
        terreno1.setComprimento(25.0);
        terreno1.setLargura(30.0);
        System.out.println();
        System.out.println("Terreno após alteração: " + terreno1);
        System.out.println("Novo tipo: " + terreno1.getTipoTerreno());
    }
}