package tech.ada.pokeada.dto;

import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.PokemonRepository;

public class PokemonHomeDTO {

    private Long id;
    private String name;
    private String image;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
