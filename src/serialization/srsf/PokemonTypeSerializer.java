package serialization.srsf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ronny on 2017-01-12.
 */
public class PokemonTypeSerializer extends Serializer<PokemonType>
{
    public PokemonTypeSerializer(SerializationContext context) {
        super(context);
    }

    @Override
    public PokemonType toObject(HashMap<String, String> keyValuePairs)
    {
        String name = keyValuePairs.get("$name");
        String weakness = keyValuePairs.get("$weakAgainst");
        String strength = keyValuePairs.get("$strongAgainst");

        return new PokemonType(name, new Lazy<>(new PokemonTypeResolver(this.getContext(), weakness)),
                new Lazy<>(new PokemonTypeResolver(this.getContext(), strength)));
}
}
