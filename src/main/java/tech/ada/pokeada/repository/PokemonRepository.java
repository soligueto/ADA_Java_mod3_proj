package tech.ada.pokeada.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tech.ada.pokeada.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>, JpaSpecificationExecutor<Pokemon> {

    Page<Pokemon> findAll(Pageable pageable);


}
