package br.breno.testeJoin.service;

import br.breno.testeJoin.exception.RecursoNaoEncontrado;
import br.breno.testeJoin.model.ProdutoDTO;
import br.breno.testeJoin.repository.CategoriaRepository;
import br.breno.testeJoin.repository.DAO.CategoriaDAO;
import br.breno.testeJoin.repository.DAO.ProdutoDAO;
import br.breno.testeJoin.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }


    public List<ProdutoDAO> getAllProdutos() {
        log.info("Pesquisando todos produtos");
        return produtoRepository.findAll().stream().toList();
    }

    public ProdutoDAO getProdutoById(Long id) {
        log.info("Pesquisando o produto com id: {}", id);
        return produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado("Produto não encontrado"));
    }
    public ProdutoDAO saveProduto(ProdutoDTO produtoDto) {
        log.info("Criando o produto com o nome: {}", produtoDto.getNome());
        CategoriaDAO categoria = categoriaRepository.findById(produtoDto.getCategoriaId())
                .orElseThrow(() -> new RecursoNaoEncontrado("Categoria não encontrada"));
        ProdutoDAO produto = new ProdutoDAO();
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setCategoria(categoria);
        produto.setDataCriacao(LocalDateTime.now());
        return produtoRepository.save(produto);
    }

    public ProdutoDAO updateProduto(Long id, ProdutoDTO produtoDto) {
        log.info("Atualizando o produto com id: {}", id);

        ProdutoDAO produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontrado("Produto não encontrado"));

        CategoriaDAO categoria = categoriaRepository.findById(produtoDto.getCategoriaId())
                .orElseThrow(() -> new RecursoNaoEncontrado("Categoria não encontrada"));

        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setCategoria(categoria);
        produto.setDataUltimaAtualizacao(LocalDateTime.now());
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id) {
        log.info("Deletando o produto com id: {}", id);
        produtoRepository.deleteById(id);
    }

}
