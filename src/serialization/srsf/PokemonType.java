package serialization.srsf;

/**
 * Created by Ronny on 2017-01-12.
 */
public class PokemonType
{
    private final String name;
    private final Lazy<PokemonType> weaknesses;
    private final Lazy<PokemonType> strengths;
    public PokemonType(String name, Lazy<PokemonType> weaknesses, Lazy<PokemonType> strengths) {
        this.name = name;
        this.weaknesses = weaknesses;
        this.strengths = strengths;
    }

    public String getName() {
        return this.name;
    }

    public PokemonType getWeaknesses() {
        return this.weaknesses.getValue();
    }

    public PokemonType getStrengths() {
        return this.strengths.getValue();
    }
}
