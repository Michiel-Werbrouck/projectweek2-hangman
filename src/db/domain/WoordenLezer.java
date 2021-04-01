package db.domain;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {

    private ArrayList<String> gelezenWoorden;
    private String pathToFile;

    public WoordenLezer(String pathToFile) {

        gelezenWoorden = new ArrayList<>();
        if(pathToFile == null || pathToFile.trim().isEmpty()){
            throw new DbException("Pad mag niet leeg zijn");
        }

    }

    public WoordenLijst lees(){
        WoordenLijst woordenLijst = new WoordenLijst();
        File file = new File(pathToFile);

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()){
                woordenLijst.voegToe(sc.nextLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return woordenLijst;
    }
    public ArrayList<String> getGelezenWoorden() {
        return gelezenWoorden;
    }
}
