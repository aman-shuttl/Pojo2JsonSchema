
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import java.io.File;
import java.io.IOException;

/**
 * Parser is used to convert POJO into json schema and save that to a file.
 * Currently converting Car Model as an example
 * you can replace car with the name of your model
 */
public class Parser {

    private final static String fileName = "jsonSchema.json";

    public static void main(String args[]) throws IOException {

        //initialize Object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        // set configuration to treat enum value as String
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

        // set configuration to provide access to fields of any access level
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        // replace car with the name of your model
        JsonSchema schema = objectMapper.generateJsonSchema(Car.class);

        // print schema on the console you can copy from there
        System.out.println(schema);

        // save the schema to the file
        objectMapper.writeValue(new File(fileName), schema);
    }

}