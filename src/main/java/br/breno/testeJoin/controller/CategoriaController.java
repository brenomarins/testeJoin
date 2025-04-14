package br.breno.testeJoin.controller;

import br.breno.testeJoin.model.CategoriaDTO;
import br.breno.testeJoin.repository.DAO.CategoriaDAO;
import br.breno.testeJoin.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDAO>> getAllCategorias() {
        return ResponseEntity.ok().body(this.categoriaService.getAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDAO>  getCategoriasById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.categoriaService.getCategoriaById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDAO> createCategoria(@RequestBody CategoriaDTO categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.categoriaService.createCategoria(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDAO> updateCategoria(@PathVariable Long id,
                                                        @RequestBody CategoriaDTO categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.categoriaService.updateCategoria(id,categoria)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        this.categoriaService.deleteCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
