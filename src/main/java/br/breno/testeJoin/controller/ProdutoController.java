package br.breno.testeJoin.controller;


import br.breno.testeJoin.model.ProdutoDTO;
import br.breno.testeJoin.repository.DAO.ProdutoDAO;
import br.breno.testeJoin.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos/")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDAO>> getAllProdutos() {
        return ResponseEntity.ok().body(this.produtoService.getAllProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDAO> getProdutosById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.produtoService.getProdutoById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoDAO> createProduto(@RequestBody ProdutoDTO produto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.produtoService.saveProduto(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDAO> updateProduto(@PathVariable long id, @RequestBody ProdutoDTO produto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.produtoService.updateProduto(id,produto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable long id) {
        this.produtoService.deleteProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
