

//Classe Pessoa:
//Agora, pense em um sistema para gerenciar um evento social. Desenvolva uma classe Pessoa com atributos como nome e idade, 
//e implemente um método que permita cumprimentar os convidados. Isso tornará a recepção mais amigável!

public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa() {
        this.nome = "Desconhecido";
        this.idade = 0;
    }
    
    public Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
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
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        if (idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Idade deve estar entre 0 e 150");
        }
        this.idade = idade;
    }
    
    public String cumprimentar() {
        return "Olá! Eu sou " + nome + " e tenho " + idade + " anos. Prazer em conhecê-lo!";
    }
    
    public String cumprimentarConvidado(Pessoa convidado) {
        return "Olá " + convidado.getNome() + "! Eu sou " + this.nome + ". Bem-vindo ao evento!";
    }
    
    public boolean ehMaiorDeIdade() {
        return idade >= 18;
    }
    
    @Override
    public String toString() {
        return nome + " (" + idade + " anos)";
    }
    
    public static void main(String[] args) {
        Pessoa anfitriao = new Pessoa("Maria", 30);
        Pessoa convidado1 = new Pessoa("João", 25);
        Pessoa convidado2 = new Pessoa("Ana", 17);
        
        System.out.println(anfitriao.cumprimentar());
        System.out.println(anfitriao.cumprimentarConvidado(convidado1));
        System.out.println(convidado1.cumprimentarConvidado(convidado2));
        
        System.out.println(convidado1.getNome() + " é maior de idade: " + convidado1.ehMaiorDeIdade());
        System.out.println(convidado2.getNome() + " é maior de idade: " + convidado2.ehMaiorDeIdade());
    }
}