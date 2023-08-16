package tech.ada.pokeada.dto.parser;

import tech.ada.pokeada.dto.PokemonHomeDTO;
import tech.ada.pokeada.model.Pokemon;


public class PokemonHomeParser {

    public static PokemonHomeDTO toPokemonDTO(Pokemon pokemon) {
        PokemonHomeDTO pokemonHomeDTO = new PokemonHomeDTO();
        pokemonHomeDTO.setId(pokemon.getId());
        pokemonHomeDTO.setImage(pokemon.getUrlImage());
        pokemonHomeDTO.setName(capitalizeString(pokemon.getName()));
        pokemonHomeDTO.setType(pokemon.getFirstType());
        return pokemonHomeDTO;
    }

    private static String capitalizeString(String str) {
       return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static void main(String[] args) {

        String abacate = "aBdxaseqwqas";
        String s = capitalizeString(abacate);
        System.out.println(s);
    }
}
