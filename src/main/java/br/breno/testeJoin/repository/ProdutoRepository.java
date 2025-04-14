package br.breno.testeJoin.repository;

import br.breno.testeJoin.repository.DAO.ProdutoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoDAO, Long> {

}
