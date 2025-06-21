//Classe Livro:
//Você está ajudando a montar uma biblioteca digital. Crie uma classe Livro com atributos como título, autor e número de páginas, além de um método para exibir detalhes do livro. Assim, 
//os usuários poderão explorar suas leituras de forma mais fácil.

public class Livro {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private String isbn;
    private boolean emprestado;
    
    public Livro() {
        this.titulo = "";
        this.autor = "";
        this.numeroPaginas = 0;
        this.isbn = "";
        this.emprestado = false;
    }
    
    public Livro(String titulo, String autor, int numeroPaginas) {
        setTitulo(titulo);
        setAutor(autor);
        setNumeroPaginas(numeroPaginas);
        this.isbn = "";
        this.emprestado = false;
    }
    
    public Livro(String titulo, String autor, int numeroPaginas, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setNumeroPaginas(numeroPaginas);
        setIsbn(isbn);
        this.emprestado = false;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        this.titulo = titulo.trim();
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser vazio");
        }
        this.autor = autor.trim();
    }
    
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    
    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser positivo");
        }
        this.numeroPaginas = numeroPaginas;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn != null ? isbn.trim() : "";
    }
    
    public boolean isEmprestado() {
        return emprestado;
    }
    
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    
    public String exibirDetalhes() {
        String status = emprestado ? "EMPRESTADO" : "DISPONÍVEL";
        String detalhes = "Título: " + titulo + "\n" +
                         "Autor: " + autor + "\n" +
                         "Páginas: " + numeroPaginas + "\n" +
                         "Status: " + status;
        
        if (!isbn.isEmpty()) {
            detalhes += "\nISBN: " + isbn;
        }
        
        return detalhes;
    }
    
    public boolean emprestar() {
        if (emprestado) {
            return false;
        }
        emprestado = true;
        return true;
    }
    
    public boolean devolver() {
        if (!emprestado) {
            return false;
        }
        emprestado = false;
        return true;
    }
    
    public String getCategoriaTamanho() {
        if (numeroPaginas < 100) {
            return "Livro pequeno";
        } else if (numeroPaginas <= 300) {
            return "Livro médio";
        } else {
            return "Livro grande";
        }
    }
    
    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + numeroPaginas + " páginas)";
    }
    
    public static void main(String[] args) {
        Livro livro1 = new Livro("1984", "George Orwell", 328);
        Livro livro2 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 96, "978-85-359-0277-5");
        Livro livro3 = new Livro("Dom Casmurro", "Machado de Assis", 256);
        
        System.out.println(livro1.exibirDetalhes());
        System.out.println();
        
        System.out.println(livro2.exibirDetalhes());
        System.out.println("Categoria: " + livro2.getCategoriaTamanho());
        System.out.println();
        
        System.out.println("Emprestando " + livro3.getTitulo() + ": " + livro3.emprestar());
        System.out.println(livro3.exibirDetalhes());
        System.out.println();
        
        System.out.println("Devolvendo " + livro3.getTitulo() + ": " + livro3.devolver());
        System.out.println("Status após devolução: " + (livro3.isEmprestado() ? "EMPRESTADO" : "DISPONÍVEL"));
    }
}