package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CirkelTest {
    private Punt middelpunt;
    private int radius;
    private Cirkel cirkel;

    @Before
    public void setUp() {
        middelpunt = new Punt(200, 100);
        radius = 20;
        cirkel = new Cirkel(middelpunt,radius);
    }

    @Test
    public void Cirkel_aanmaken_met_geldig_middelpunt_en_straal(){
        assertEquals(middelpunt, cirkel.getMiddelpunt());
        assertEquals(radius, cirkel.getRadius());
    }

    @Test(expected = DomainException.class)
    public void Gooit_exception_Cirkel_met_middelpunt_null(){
        new Cirkel(null,20);
    }

    @Test(expected = DomainException.class)
    public void Gooit_exception_Cirkel_met_straal_null(){
        new Cirkel(middelpunt,-5);
    }

    @Test(expected = DomainException.class)
    public void Gooit_exception_Cirkel_met_straal_0(){
        new Cirkel(middelpunt,-0);
    }

    @Test
    public void Equals_moet_true_geven_2_cirkels_zelfde_straal_en_middelpunt(){
        Cirkel zelfdeCirkel = new Cirkel(middelpunt,radius);
        assertTrue(cirkel.equals(zelfdeCirkel));
    }

    @Test
    public void Equals_false_als_1_cirkel_gelijk_is_aan_null(){
        Cirkel cirkelNull = null;
        assertFalse(cirkel.equals(cirkelNull));
    }

    @Test
    public void Equals_false_als_2_cirkels_met_verschillende_middelpunt(){
        Cirkel cirkelVerschillend = new Cirkel(new Punt(100,200), radius);
        assertFalse(cirkel.equals(cirkelVerschillend));

    }

    @Test
    public  void Equals_false_als_2_cirkels_met_verschillende_radius()
    {
        Cirkel cirkel2 = new Cirkel(middelpunt,1);
        assertFalse(cirkel.equals(cirkel2));
    }

    @Test
    public void test_omhullende_het_juiste_resultaat_geeft()
    {
        Punt p = new Punt(200,200);
        Cirkel c = new Cirkel(p,20);
        Punt p2 = new Punt(180,180);
        Omhullende o = new Omhullende(p2, 40,40);
        assertEquals(c.getOmhullende(),o);
    }


}
