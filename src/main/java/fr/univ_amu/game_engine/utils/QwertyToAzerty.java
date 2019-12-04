package fr.univ_amu.game_engine.utils;

public class QwertyToAzerty {
    public static String getAzertyFromQwerty(String qwertyString){
        String tmp = qwertyString;
        switch (tmp.toLowerCase()){
            case "a":
                tmp = "Q";
                break;
            case "q":
                tmp = "A";
                break;
            case "w":
                tmp = "Z";
                break;
            case "z":
                tmp = "W";
                break;
            case "semicolon":
                tmp = "M";
                break;
            default:
                tmp = qwertyString;
        }
        return tmp;
    }
}
