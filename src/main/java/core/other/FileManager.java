package core.other;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

@Component
@Getter
public class FileManager {
    private static HashMap<String, String> mapManager;
    private final String staticFolderPath = "static";

    public FileManager(HashMap<String, String> mapManager) throws IOException {
        FileManager.mapManager = mapManager;
        init();
    }

    public static HashMap<String, String> getMapManager() {
        return mapManager;
    }

    public void setMapManager(HashMap<String, String> mapManager) {
        FileManager.mapManager = mapManager;
    }

    public void getFilesFromStaticFolder(File[] files) throws IOException {
        for (File file: files) {
            if (!file.isDirectory()) {
                String path = file.getPath();
                String subPath = path.substring(path.indexOf(staticFolderPath));
                String key = subPath.replace(String.format("%s\\", staticFolderPath), "");
                putFileFromResources(subPath, key);
            }
            else {
                getFilesFromStaticFolder(Objects.requireNonNull(file.listFiles()));
            }
        }
    }

    public void init() throws IOException {
        File[] staticFolder = new ClassPathResource(staticFolderPath).getFile().listFiles();
        getFilesFromStaticFolder(staticFolder);
    }

    public void putFileFromResources(String filePath, String key) throws IOException {
        InputStream inputStream = new ClassPathResource(filePath).getInputStream();
        String value = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(key);
        mapManager.put(key, value);
    }
}
