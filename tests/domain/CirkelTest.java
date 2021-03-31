package domain;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CirkelTest {
    private Punt geldigMiddelpunt;
    private int geldigeRadius;
    private Cirkel cirkel;
    @Before
    public void setUp(){
        this.geldigMiddelpunt = new Punt(9,9);
        this.geldigeRadius = 4;
        this.cirkel = new Cirkel(geldigMiddelpunt, geldigeRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Middelpunt_met_Null_als_getal_gooit_exception(){
        new Cirkel(null, geldigeRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_cirkel_met_radius_0_gooit_exception(){
        new Cirkel(geldigMiddelpunt,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Straal_met_negatief_getal_gooit_exception_op(){
        new Cirkel(geldigMiddelpunt,-4);
    }

    @Test
    public void test_2_cirkels_met_zelfde_radius_en_middelpunt_zijn_gelijk() {
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        Cirkel cirkel2 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        assertEquals(cirkel1, cirkel2);
    }

    @Test
    public void test_2_cirkels_zijn_verschillend_met_tweede_cirkel_null() {
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        Cirkel cirkel2 = null;
        assertFalse(cirkel1.equals(cirkel2));
    }

    @Test
    public void test_2_cirkels_met_verschillend_middelpunt_zijn_verschillend() {
        Cirkel cirkel1 = new Cirkel(new Punt(5, 7), geldigeRadius);
        Cirkel cirkel2 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        assertFalse(cirkel1.equals(cirkel2));    }

    @Test
    public void test_2_cirkels_met_verschillende_straal_zijn_verschillend() {
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        Cirkel cirkel2 = new Cirkel(geldigMiddelpunt, 18);
        assertFalse(cirkel1.equals(cirkel2));
    }




    @Test
    public void test_Cirkel_met_geldige_waarde_voor_parameters_maakt_object_met_geldige_eigenschappen(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigeRadius);
        assertNotNull(cirkel);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(geldigeRadius, cirkel.getRadius(), 0.1);

    }




}
