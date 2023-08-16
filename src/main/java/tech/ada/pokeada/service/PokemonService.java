package tech.ada.pokeada.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tech.ada.pokeada.dto.PokemonDTO;
import tech.ada.pokeada.dto.PokemonHomeDTO;
import tech.ada.pokeada.dto.parser.PokemonDTOParser;
import tech.ada.pokeada.dto.parser.PokemonHomeParser;
import tech.ada.pokeada.exceptions.PokemonNaoEncontradoException;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.PokemonRepository;
import tech.ada.pokeada.repository.filter.PokemonFilter;
import tech.ada.pokeada.repository.spec.PokemonSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonHomeDTO> findAll() {
        return pokemonRepository.findAll()
                .stream()
                .map(PokemonHomeParser::toPokemonDTO)
                .collect(Collectors.toList());
    }


    public PokemonDTO findById(Long id) {
        Optional<Pokemon> pokemonOptional  = pokemonRepository.findById(id);

        return PokemonDTOParser.toPokemonDTO(pokemonOptional
                .orElseThrow(() ->
                        new PokemonNaoEncontradoException("Não encontrado pokemon de ID " + id)));
    }

    public Page<PokemonHomeDTO> findAll(Integer numeroPagina, Integer quantidadeRegistros, String ordem, String campoOrdenacao) {
        Sort ordenacao = Sort.by(Sort.Direction.fromString(ordem), campoOrdenacao);
        PageRequest pageRequest = PageRequest.of(numeroPagina, quantidadeRegistros, ordenacao);

        Page<Pokemon> pagePokemon = pokemonRepository.findAll(pageRequest);

        return pagePokemon
                .map(PokemonHomeParser::toPokemonDTO);
    }

    public List<PokemonHomeDTO> findByFilter(String name, Integer attack, Integer defense) {
        PokemonFilter filtro = new PokemonFilter(name, attack, defense);
        PokemonSpecification pokemonSpecification = new PokemonSpecification(filtro);

        return pokemonRepository.findAll(pokemonSpecification.findByFilter())
                .stream().map(PokemonHomeParser::toPokemonDTO).collect(Collectors.toList());
    }
}

