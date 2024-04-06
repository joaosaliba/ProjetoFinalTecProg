package desafiotecnicojr.projetomigratecsv.service;

import desafiotecnicojr.projetomigratecsv.entity.Produto;
import desafiotecnicojr.projetomigratecsv.service.db.DataBaseGet;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Actions {
    private DataBaseGet dataBaseGet;

    public Actions(DataBaseGet dataBaseGet) {
        this.dataBaseGet = dataBaseGet;
    }

    public void runAll() throws Exception {
        this.quantidadeDeCategorias();
        System.out.println();
        this.quantidadeProdutosPorCategoria();
        System.out.println();
        this.calcularValorMedio();
        System.out.println();
        this.encontrarProdutosEstoqueBaixo();
    }

    private void quantidadeDeCategorias() throws Exception {
        List<Produto> produtos = dataBaseGet.getAll();

        long count = produtos.stream()
                .map(Produto::getCategoria)
                .distinct()
                .count();

        System.out.println("Quantidade de categorias: " + count);
    }

    private void quantidadeProdutosPorCategoria() throws Exception {
        List<Produto> produtos = dataBaseGet.getAll();

        Map<String, Long> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.summingLong(Produto::getQuantidade)));

        produtosPorCategoria.forEach((categoria, quantidade) -> {
            System.out.println("Categoria: " + categoria + ", Quantidade em estoque: " + quantidade);
        });
    }

    private void calcularValorMedio() throws Exception {
        List<Produto> produtos = dataBaseGet.getAll();

        BigDecimal totalValue = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            totalValue = totalValue.add(produto.getPreco());
        }
        BigDecimal valorMedio = totalValue.divide(BigDecimal.valueOf(produtos.size()), 2, RoundingMode.HALF_UP);
        System.out.println("Valor medio dos produtos é de R$" + valorMedio);
    }

    private void encontrarProdutosEstoqueBaixo() throws Exception {
        List<Produto> produtos = dataBaseGet.getAll();

        List<Produto> produtosBaixos = produtos.stream()
                .filter(produto -> produto.getQuantidade() < 3)
                .collect(Collectors.toList());

        produtosBaixos.forEach(produto -> System.out.println("Produtos baixos em estoque " + produto));
    }


}
