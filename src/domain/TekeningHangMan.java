package domain;

public class TekeningHangMan extends Tekening {

    public TekeningHangMan() {
        super("Hangman");
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
        galgBodem.setZichtbaar(true);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
        galgStaaf.setZichtbaar(true);
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
        hangbar.setZichtbaar(true);
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
        koord.setZichtbaar(true);
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
        hoofd.setZichtbaar(false);
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
        oogLinks.setZichtbaar(false);
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//…
        oogRechts.setZichtbaar(false);
        Vorm neus = new Cirkel(new Punt(280, 128), 2);
        neus.setZichtbaar(false);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        mond.setZichtbaar(false);
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        lijf.setZichtbaar(false);
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        beenLinks.setZichtbaar(false);
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        beenRechts.setZichtbaar(false);
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        voetLinks.setZichtbaar(false);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        voetRechts.setZichtbaar(false);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        armLinks.setZichtbaar(false);
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        armRechts.setZichtbaar(false);
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        handLinks.setZichtbaar(false);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        handRechts.setZichtbaar(false);

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
        boolean bool = false;
        for (int i=0; i<getVormen().size() && !bool; i++){
            if (!getVorm(i).isZichtbaar()) {
                getVorm(i).setZichtbaar(true);
                bool = true;
            }
        }
        if(!bool){
            throw new DomainException("Alles is reeds zichtbaar");
        }
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
