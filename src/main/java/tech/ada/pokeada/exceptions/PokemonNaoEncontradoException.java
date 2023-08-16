package tech.ada.pokeada.exceptions;

public class PokemonNaoEncontradoException extends RuntimeException {

    public PokemonNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
