package tech.ada.pokeada.repository.spec;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.filter.PokemonFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokemonSpecification {

    private final PokemonFilter pokemonFilter;

    public PokemonSpecification(PokemonFilter pokemonFilter) {
        this.pokemonFilter = pokemonFilter;
    }

    public Specification<Pokemon> findByFilter() {
        return (Root<Pokemon> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(pokemonFilter.getAttack())) {
                predicates.add(criteriaBuilder.greaterThan(root.get("attack"), pokemonFilter.getAttack()));
            }

            if (Objects.nonNull(pokemonFilter.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + pokemonFilter.getName() + "%"));
            }

            if (Objects.nonNull(pokemonFilter.getDefense())) {
                predicates.add(criteriaBuilder.greaterThan(root.get("defense"), pokemonFilter.getDefense()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

