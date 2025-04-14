package br.breno.testeJoin.service;

import br.breno.testeJoin.exception.RecursoNaoEncontrado;
import br.breno.testeJoin.model.CategoriaDTO;
import br.breno.testeJoin.repository.CategoriaRepository;
import br.breno.testeJoin.repository.DAO.CategoriaDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDAO> getAllCategorias() {
        log.info("Pesquisando todas as categorias");
        return categoriaRepository.findAll().stream()
                .toList();
    }

    public CategoriaDAO getCategoriaById(Long id) {
        log.info("Pesquisando a categoria com id: {}", id);
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontrado("Categoria não encontrada"));
    }

    public CategoriaDAO createCategoria(CategoriaDTO categoriaDto) {
        log.info("Criando a categoria com o nome: {}", categoriaDto.getNome());
        CategoriaDAO categoria = new CategoriaDAO();
        categoria.setNome(categoriaDto.getNome());
        categoria.setDescricao(categoriaDto.getDescricao());
        categoria.setDataCriacao(LocalDateTime.now());
        return categoriaRepository.save(categoria);

    }

    public CategoriaDAO updateCategoria(long id,CategoriaDTO categoriaDAO) {//
        log.info("Atualizando a categoria com id: {}", id);

        CategoriaDAO categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontrado("Categoria não encontrada"));

        categoria.setNome(categoriaDAO.getNome());
        categoria.setDescricao(categoriaDAO.getDescricao());
        categoria.setDataUltimaAtualizacao(LocalDateTime.now());
        return categoriaRepository.save(categoria);

    }

    public void deleteCategoria(Long id) {
        log.info("Deletando a categoria com id: {}", id);
        categoriaRepository.deleteById(id);
    }
}
