package fr.univ_amu.game_engine.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationsFile {
    private static final int KEY = 1; // l'action (ex: left, up, ...)
    private static final int VALUE = 0; // la touche (ex: q, z, ...)
    private Map<String, String> configs = new HashMap<>();

    public ConfigurationsFile(String fileName) throws IOException {
        BufferedReader fileReader = createFileReader(fileName);

        String configLineTmp;
        String[] tokens;
        while ((configLineTmp = fileReader.readLine()) != null){
            tokens = configLineTmp.split("=");
            verifyLineFormat(tokens);
            configs.put(tokens[KEY].toLowerCase(), tokens[VALUE].toLowerCase());
        }

        fileReader.close();
    }

    private BufferedReader createFileReader(String fileName){
        try{
            FileReader reader = new FileReader(fileName);
            BufferedReader fileReader = new BufferedReader(reader);
            return fileReader;
        } catch (FileNotFoundException e) {
            System.err.println("Fichier de configuration introuvalble.");
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
