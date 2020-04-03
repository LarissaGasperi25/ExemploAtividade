package dao.dinamico;

import java.util.ArrayList;
import modelo.Livro;
import modelo.Pessoa;

public class DAO {

    // objetos estáticos, para que quaisquer instâncias do DAO
    // acessem os mesmos dados
    static ArrayList<Pessoa> pessoas = new ArrayList();
    static ArrayList<Livro> livros = new ArrayList();

    // manipulação de pessoas    
    public ArrayList<Pessoa> retornarPessoas() { return pessoas; }
    public void adicionarPessoa(Pessoa p) { pessoas.add(p); }
    public int retornarQuantidadeDePessoas() { return pessoas.size(); }
    public void removerPessoa(Pessoa pe) { pessoas.remove(pe); }
    public Pessoa retornarPessoa(int i) { 
        // prepara o retorno padrão
        Pessoa retorno = new Pessoa("não encontrado", "n/a", "n/a");
        // percorrer as pessoas
        for (Pessoa pe : pessoas) {
            // se achou a pessoa (verifica pelo identificador)
            if (pessoas.get(i).getId() == pe.getId()) {
                // retorna a pessoa e finaliza o método
                return pe;
            }
        }
        // se não achou, retorna a pessoa com sinalização de erro
        return retorno;
    }
    
    public void atualizarPessoa(Pessoa p) {
        // sinalizar que será feita uma busca
        int ondeMudar = -1;
        // buscar a pessoa pelo nome
        for (int i = 0; i < pessoas.size(); i++) {
            // se achou a pessoa (verifica pelo identificador)
            if (pessoas.get(i).getId() == p.getId()) {
                ondeMudar = i;
                break;
            }
        }
        // se achou a pessoa pra mudar
        if (ondeMudar >= 0) {
            // altera a pessoa naquela posição da lista
            pessoas.set(ondeMudar, p);
        }
    }
    
    // manipulação de livros
    public ArrayList<Livro> retornarLivros() { return livros; }
    public void adicionarLivro(Livro novo) { livros.add(novo); }
    
    public ArrayList<Livro> retornarLivrosPorTextoDeBusca(String sequencia) {
        // criar lista de retorno
        ArrayList<Livro> retorno = new ArrayList();
        // converter string de busca para minúsculas
        sequencia = sequencia.toLowerCase();
        // buscar nos livros a sequência de busca
        for (Livro livro : livros) {
            // livro atual, convertido para minúsculas
            Livro tmp = new Livro(livro.getTitulo().toLowerCase(),
                    livro.getAutores().toLowerCase(),
                    livro.getAno().toLowerCase(),
                    livro.getEditora().toLowerCase());
            // se o livro atual possuir algo da string de busca
            if (tmp.getTitulo().contains(sequencia)
                    || tmp.getAutores().contains(sequencia)
                    || tmp.getAno().contains(sequencia)
                    || tmp.getEditora().contains(sequencia)) {
                // adicionar o livro no retorno
                retorno.add(livro);
            }
        }
        return retorno;
    }
}