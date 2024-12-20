package centredetriTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.centredetri.Application;
import com.centredetri.CentreDeTri;
import com.centredetri.Menage;
import com.centredetri.Poubelle;
import com.centredetri.TypeDechet;

class PoubelleTest {

    private Poubelle poubelle;
    private CentreDeTri centreDeTri;
    private Menage menage;

    @BeforeEach
    void setUp() {
        // Setup initial objects
        centreDeTri = new CentreDeTri("CentreDeTri", "6 rue saint georges");
        menage = centreDeTri.ajouterMenage("pauline", "popo24");
        
        List<TypeDechet> listeDechets = new ArrayList<TypeDechet>();
		listeDechets.add(TypeDechet.PLASTIQUE);
		listeDechets.add(TypeDechet.VERRE); 
        
        poubelle = centreDeTri.ajouterPoubelle(listeDechets, "rue albert 2");
    }

    @Test
    void testAjouterDepotSuccess() {
        // Test successful deposit
        float poids = 10f;
        poubelle.ajouterDepot(menage, poids, TypeDechet.PLASTIQUE);

        assertEquals(1, poubelle.getListeDepots().size());
        assertEquals(poids, poubelle.getCapacite());
        assertEquals(Application.pointsParKg * poids, menage.getTotalPoints());
    }

    @Test
    void testAjouterDepotPoubellePleine() {
        // Test deposit when the bin is full
        poubelle.setCapacite(200f);
        poubelle.ajouterDepot(menage, 10f, TypeDechet.PLASTIQUE);

        assertEquals(0, poubelle.getListeDepots().size());
        assertEquals(200f, poubelle.getCapacite());
    }

    @Test
    void testViderPoubelle() {
        // Test emptying the bin
        poubelle.setCapacite(100f);
        poubelle.vider();

        assertEquals(0f, poubelle.getCapacite());
    }

    @Test
    void testEstPleine() {
        // Test if the bin is full
        poubelle.setCapacite(180f); // 90% of 200f
        assertTrue(poubelle.estPleine());

        poubelle.setCapacite(50f);
        assertFalse(poubelle.estPleine());
    }

    @Test
    void testAjouterDepotTypeDechetIncorrect() {
        // Test deposit with incorrect type of waste
        float poids = 10f;
        poubelle.ajouterDepot(menage, poids, TypeDechet.PAPIER);

        assertEquals(1, poubelle.getListeDepots().size());
        assertEquals(poids, poubelle.getCapacite());
        assertEquals(-Application.pointsParKg * poids / 2, menage.getTotalPoints());
    }
}
