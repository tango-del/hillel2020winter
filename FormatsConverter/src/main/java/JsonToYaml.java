import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonToYaml {
    public static void main(String[] args) throws IOException {
        String json = readToString("../src/main/resources/20_item.json");

        ObjectMapper objectMapper2 = new ObjectMapper();

        JsonNode jsonNode = objectMapper2.readTree(json);

        new YAMLMapper().writeValue(new File("../src/main/resources/tt.yaml"), jsonNode);



        String yam = readToString("../src/main/resources/test1.yaml");

        ObjectMapper objectMapper = new ObjectMapper();

        Yaml yaml = new Yaml();

        Object objectYaml = yaml.load(yam);

        objectMapper.writeValue(new File("../src/main/resources/tt.json"), objectYaml);

        String appDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
    }

    private static String readToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
