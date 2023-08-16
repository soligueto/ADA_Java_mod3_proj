package tech.ada.pokeada.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.ada.pokeada.dto.PokemonDTO;
import tech.ada.pokeada.dto.PokemonHomeDTO;
import tech.ada.pokeada.service.PokemonService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }


    //Integer numeroPagina
    //Integer quantidadeRegistros
    //String ordem
    //String campoOrdenacao
    @GetMapping
    public ResponseEntity<Page<PokemonHomeDTO>> findAllPokemons(
            @RequestParam(value = "numeroPagina", required = false, defaultValue = "0")
            @Min(value = 0, message = "Valor mínimo para o número de página é 0") @Max(200) Integer numeroPagina,
            @RequestParam(value = "quantidadeRegistros", required = false, defaultValue = "150")
            @Min(value = 5, message = "No mínimo 5 registros por página") @Max(200)
            Integer quantidadeRegistros,
            @RequestParam(value = "ordem", required = false, defaultValue = "desc")
            @Size(min = 3, max = 4, message = "Os campos aceitos são somente 'desc' ou 'asc'")
            String ordem,
            @RequestParam(value = "campoOrdenacao", required = false, defaultValue = "name")
            @Size(min = 2, message = "Campo ordenação inválido")
            String campoOrdenacao
    ) {
        return ResponseEntity.ok(pokemonService.findAll(numeroPagina, quantidadeRegistros, ordem, campoOrdenacao));
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<PokemonHomeDTO>> findAllByFilter(
            @RequestHeader(value = "name", required = false) String name,
            @RequestHeader(value = "attack", required = false) Integer attack,
            @RequestHeader(value = "defense", required = false) Integer defense
    ) {
        return ResponseEntity.ok(pokemonService.findByFilter(name, attack, defense));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(pokemonService.findById(id));
    }


}
