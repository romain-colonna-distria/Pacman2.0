package fr.univ_amu.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationsFile {
    private static final int KEY = 0;
    private static final int VALUE = 1;
    private Map<String, String> configs = new HashMap<>();

    public ConfigurationsFile(String fileName) throws IOException {
        BufferedReader fileReader = createFileReader(fileName);

        String configLineTmp;
        String[] tokens;
        while ((configLineTmp = fileReader.readLine()) != null){
            tokens = configLineTmp.split("=");
            verifyLineFormat(tokens);
            configs.put(tokens[KEY], tokens[VALUE]);
        }

        fileReader.close();
    }

    private BufferedReader createFileReader(String fileName){
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            return fileReader;
        } catch (FileNotFoundException e) {
            System.err.println("Fichier de configuration introuvalble.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du bufferedReader.");
            System.exit(1);
        }
        return null;
    }

    private void verifyLineFormat(String[] tokens){
        if(tokens.length != 2){
            System.err.println("Erreur dans le fichier de configuration.");
            System.exit(1);
        }
    }

    public String getAssociatedKey(String action){
        return configs.get(action);
    }
}
