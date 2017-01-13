package serialization.srsf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ronny on 2017-01-12.
 */
public class SchemaSerializer extends Serializer<Schema>
{
    public SchemaSerializer(SerializationContext context) {
        super(context);
    }

    @Override
    public Schema toObject(HashMap<String, String> keyValuePairs)
    {
        String schemaName = keyValuePairs.get("$schemaName");
        String outputType = keyValuePairs.get("$outputType");
        HashMap<String, String> properties = new HashMap<>();
        for(Map.Entry<String, String> s : keyValuePairs.entrySet()) {
            if(s.getKey().startsWith("@")) {
                properties.put(s.getKey().substring(1), s.getValue());
            }
        }
        return new Schema(properties, schemaName, outputType);
    }
}
