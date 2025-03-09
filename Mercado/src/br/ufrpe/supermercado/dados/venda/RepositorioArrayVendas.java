package br.ufrpe.supermercado.dados.venda;

import br.ufrpe.supermercado.negocio.Venda;

public class RepositorioArrayVendas implements IRepositorioVendas {
    private int tamanhoAtual;
    private Venda[] vendas; // Array de vendas

    // Construtor corrigido
    public RepositorioArrayVendas() {
        this.vendas = new Venda[100]; // Inicializa o array com tamanho 100
        this.tamanhoAtual = 0; // Inicializa o tamanho atual como 0
    }

    private void redimensionarArray() {
        Venda[] novoArray = new Venda[vendas.length * 2];
        for (int i = 0; i < vendas.length; i++) {
            novoArray[i] = vendas[i];
        }
        vendas = novoArray;
    }

    @Override
    public void registrarVenda(Venda venda) {
        if (tamanhoAtual == vendas.length) {
            redimensionarArray();
        }
        vendas[tamanhoAtual] = venda;
        tamanhoAtual++;
    }

    @Override
    public void listarVendas() {
        for (int i = 0; i < tamanhoAtual; i++) {
            System.out.println(vendas[i]);
        }
    }
}