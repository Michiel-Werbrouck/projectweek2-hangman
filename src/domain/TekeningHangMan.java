package domain;

public class TekeningHangMan extends Tekening {

    public TekeningHangMan() {
        super("Hangman");
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//…
        Vorm neus = new Cirkel(new Punt(280, 128), 2);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        /*voegToe(galgBodem);
        voegToe(galgStaaf);
        voegToe(hangbar);
        voegToe(koord);
        voegToe(hoofd);
        voegToe(oogLinks);
        voegToe(oogRechts);
        voegToe(neus);
        voegToe(mond);
        voegToe(lijf);
        voegToe(beenLinks);
        voegToe(beenRechts);
        voegToe(voetLinks);
        voegToe(voetRechts);
        voegToe(armLinks);
        voegToe(armRechts);
        voegToe(handLinks);
        voegToe(handRechts);*/

        getVormen().add(galgBodem);
        getVormen().add(galgStaaf);
        getVormen().add(hangbar);
        getVormen().add(koord);
        getVormen().add(hoofd);
        getVormen().add(oogLinks);
        getVormen().add(oogRechts);
        getVormen().add(neus);
        getVormen().add(mond);
        getVormen().add(lijf);
        getVormen().add(beenLinks);
        getVormen().add(beenRechts);
        getVormen().add(voetLinks);
        getVormen().add(voetRechts);
        getVormen().add(armLinks);
        getVormen().add(armRechts);
        getVormen().add(handLinks);
        getVormen().add(handRechts);

        for (int i = 4; i<18; i++) {
            getVorm(i).setZichtbaar(false);
        }
        for (int i = 0; i<4; i++) {
            getVorm(i).setZichtbaar(true);
        }
    }

    public int getAantalOnzichtbaar() {
        int count = 0;
        for (Vorm vorm: getVormen()){
            if (!vorm.isZichtbaar()) {
                count++;
            }
        }
        return count;
    }

    public void zetVolgendeZichtbaar() {
        for (Vorm vorm: getVormen()){
            if (!vorm.isZichtbaar()) {
                vorm.setZichtbaar(true);
                return;
            }
        }
        throw new DomainException("Alles is reeds zichtbaar");
    }

    @Override
    public void voegToe(Vorm vorm) {
        throw new DomainException("Kan niets toevoegen aan tekening");
    }

    @Override
    public void verwijder(Vorm vorm) {
        throw new DomainException("Kan niets verwijderen van tekening");
    }

}
