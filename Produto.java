//   Classe Produto:
//Você está criando um sistema de e-commerce. Crie uma classe Produto com atributos como nome e preço, 
//e um método para calcular o preço com desconto. Isso ajudará os clientes a economizar em suas compras!

public class Produto {
    private String nome;
    private double preco;
    private String categoria;
    private int estoque;
    private String codigo;
    
    public Produto() {
        this.nome = "";
        this.preco = 0.0;
        this.categoria = "";
        this.estoque = 0;
        this.codigo = "";
    }
    
    public Produto(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
        this.categoria = "";
        this.estoque = 0;
        this.codigo = "";
    }
    
    public Produto(String nome, double preco, String categoria, int estoque, String codigo) {
        setNome(nome);
        setPreco(preco);
        setCategoria(categoria);
        setEstoque(estoque);
        setCodigo(codigo);
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
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria != null ? categoria.trim() : "";
    }
    
    public int getEstoque() {
        return estoque;
    }
    
    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }
        this.estoque = estoque;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo != null ? codigo.trim() : "";
    }
    
    public double calcularPrecoComDesconto(double percentualDesconto) {
        if (percentualDesconto < 0 || percentualDesconto > 100) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e 100%");
        }
        return preco * (1 - percentualDesconto / 100);
    }
    
    public double calcularEconomia(double percentualDesconto) {
        if (percentualDesconto < 0 || percentualDesconto > 100) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e 100%");
        }
        return preco * (percentualDesconto / 100);
    }
    
    public boolean temEstoque() {
        return estoque > 0;
    }
    
    public boolean reduzirEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        if (quantidade > estoque) {
            return false;
        }
        estoque -= quantidade;
        return true;
    }
    
    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        estoque += quantidade;
    }
    
    public String getStatusEstoque() {
        if (estoque == 0) {
            return "ESGOTADO";
        } else if (estoque < 10) {
            return "ESTOQUE BAIXO";
        } else {
            return "DISPONÍVEL";
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s - R$ %.2f (%s) - Estoque: %d", 
                           nome, preco, getStatusEstoque(), estoque);
    }
    
    public static void main(String[] args) {
        Produto produto1 = new Produto("Smartphone", 899.99);
        Produto produto2 = new Produto("Notebook", 2499.99, "Eletrônicos", 15, "NB001");
        Produto produto3 = new Produto("Fone de Ouvido", 199.99, "Acessórios", 5, "FO001");
        
        System.out.println("Produtos disponíveis:");
        System.out.println(produto1);
        System.out.println(produto2);
        System.out.println(produto3);
        System.out.println();
        
        double desconto = 15.0;
        System.out.println("Promoção - " + desconto + "% de desconto:");
        System.out.println(produto1.getNome() + ":");
        System.out.println("  Preço original: R$ " + String.format("%.2f", produto1.getPreco()));
        System.out.println("  Preço com desconto: R$ " + String.format("%.2f", produto1.calcularPrecoComDesconto(desconto)));
        System.out.println("  Economia: R$ " + String.format("%.2f", produto1.calcularEconomia(desconto)));
        System.out.println();
        
        System.out.println("Simulando compra de 2 notebooks:");
        if (produto2.reduzirEstoque(2)) {
            System.out.println("Compra realizada! Estoque atual: " + produto2.getEstoque());
        } else {
            System.out.println("Estoque insuficiente!");
        }
        System.out.println();
        
        System.out.println("Simulando compra de 10 fones:");
        if (produto3.reduzirEstoque(10)) {
            System.out.println("Compra realizada!");
        } else {
            System.out.println("Estoque insuficiente! Disponível: " + produto3.getEstoque());
        }
        
        produto3.adicionarEstoque(20);
        System.out.println("Estoque reabastecido: " + produto3);
    }
}