package br.breno.testeJoin.repository;

import br.breno.testeJoin.repository.DAO.CategoriaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaDAO, Long> {

}
