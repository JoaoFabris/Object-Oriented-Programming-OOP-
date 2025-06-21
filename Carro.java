//Classe Carro:
//Agora, considere a criação de um simulador de carros. Crie uma classe Carro com atributos como marca, 
//modelo e ano, e métodos para ligar, desligar e acelerar. Isso tornará a simulação mais realista!



public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private boolean ligado;
    
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.ligado = false;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getAno() {
        return ano;
    }
    
    public boolean isLigado() {
        return ligado;
    }
    
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado!");
        } else {
            System.out.println("Carro já está ligado!");
        }
    }
    
    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("Carro desligado!");
        } else {
            System.out.println("Carro já está desligado!");
        }
    }
    
    public void acelerar() {
        if (ligado) {
            System.out.println("Acelerando o " + marca + " " + modelo + "!");
        } else {
            System.out.println("Ligue o carro primeiro!");
        }
    }
    
    @Override
    public String toString() {
        String status = ligado ? "LIGADO" : "DESLIGADO";
        return marca + " " + modelo + " (" + ano + ") - " + status;
    }
    
    public static void main(String[] args) {
        Carro carro1 = new Carro("Toyota", "Corolla", 2022);
        Carro carro2 = new Carro("Honda", "Civic", 2021);
        
        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println();
        
        carro1.acelerar();
        carro1.ligar();
        carro1.acelerar();
        carro1.desligar();
        
        System.out.println();
        System.out.println("Status final: " + carro1);
    }
}