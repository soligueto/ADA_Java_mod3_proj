package tech.ada.pokeada.dto.parser;

import tech.ada.pokeada.dto.PokemonDTO;
import tech.ada.pokeada.model.Pokemon;

import static tech.ada.pokeada.util.StringUtils.capitalizeString;

public class PokemonDTOParser {

    public static PokemonDTO toPokemonDTO(Pokemon pokemon) {
        PokemonDTO dto = new PokemonDTO();
        dto.setId(pokemon.getId());
        dto.setName(capitalizeString(pokemon.getName()));
        dto.setAttack(pokemon.getAttack());
        dto.setDefense(pokemon.getDefense());
        dto.setFirstType(pokemon.getFirstType());
        dto.setHp(pokemon.getHp());
        dto.setSpecialAttack(pokemon.getSpecialAttack());
        dto.setSpeed(pokemon.getSpeed());
        dto.setUrlImage(pokemon.getUrlImage());
        return dto;
    }
}
