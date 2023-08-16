package tech.ada.pokeada.repository.filter;

public class PokemonFilter {

    private String name;
    private Integer attack;
    private Integer defense;

    public PokemonFilter(String name, Integer attack, Integer defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }
}
