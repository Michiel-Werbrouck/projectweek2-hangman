package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TekeningHangManTest {

    TekeningHangMan tekeningHangMan;

    @Before
    public void setUp(){
        tekeningHangMan = new TekeningHangMan();
    }

    @Test
    public void eerste_4_vormen_zijn_altijd_zichtbaar(){
        for(int i = 0 ; i<=3; i++)
            assertTrue(tekeningHangMan.getVormen().get(i).isZichtbaar());
    }

    @Test
    public void vijfde_figuur_zichtbaar_na_1_fout() {
        tekeningHangMan.zetVolgendeZichtbaar();
        assertTrue(tekeningHangMan.getVormen().get(4).isZichtbaar());
    }

    @Test
    public void zesde_figuur_zichtbaar_na_2_fouten() {
        tekeningHangMan.zetVolgendeZichtbaar();
        tekeningHangMan.zetVolgendeZichtbaar();
        assertTrue(tekeningHangMan.getVormen().get(5).isZichtbaar());
    }

    @Test
    public void zevende_figuur_zichtbaar_na_3_fouten() {
        tekeningHangMan.zetVolgendeZichtbaar();
        tekeningHangMan.zetVolgendeZichtbaar();
        tekeningHangMan.zetVolgendeZichtbaar();
        assertTrue(tekeningHangMan.getVormen().get(6).isZichtbaar());
    }

    @Test
    public void achtste_figuur_zichtbaar_na_4_fouten() {
        tekeningHangMan.zetVolgendeZichtbaar();
        tekeningHangMan.zetVolgendeZichtbaar();
        tekeningHangMan.zetVolgendeZichtbaar();
        tekeningHangMan.zetVolgendeZichtbaar();
        assertTrue(tekeningHangMan.getVormen().get(7).isZichtbaar());
    }
}