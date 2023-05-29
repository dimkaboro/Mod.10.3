import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class checkRepeatsWords {
    private static final String ABSOLUTE_PATH = "C:\\Users\\dmitr\\IdeaProjects\\Homerwork10.3\\src\\words.txt";

    public void checkWords() {
        File file = new File(ABSOLUTE_PATH);
        checkFileExists(file);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            Map<String, Integer> result = new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for(String s : words) {
                    if(!s.isEmpty()) {
                        result.put(s, result.getOrDefault(s, 0) + 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void checkFileExists(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
