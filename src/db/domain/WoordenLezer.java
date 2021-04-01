package db.domain;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {

    private ArrayList<String> gelezenWoorden;

    public WoordenLezer(String pathToFile) {

        gelezenWoorden = new ArrayList<>();

        File file = new File(pathToFile);

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()){
                gelezenWoorden.add(sc.nextLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getGelezenWoorden() {
        return gelezenWoorden;
    }
}
