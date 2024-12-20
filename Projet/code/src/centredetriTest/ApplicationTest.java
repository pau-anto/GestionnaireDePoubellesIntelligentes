package centredetriTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.*;

import com.centredetri.Application;
import com.centredetri.CentreDeTri;
import com.centredetri.Menage;

public class ApplicationTest {

    private Application appli;
    private CentreDeTri mockCentreDeTri;

    @BeforeEach
    public void setUp() {
        // Simulate a CentreDeTri for testing
        mockCentreDeTri = new CentreDeTri("epita", "6 rue du faubourg st george");
        appli = new Application(mockCentreDeTri);
    }
    

    @Test
    public void testCreerCompte() {
        appli.creerCompte("leandre", "leandre24");
        List<Menage> menages = mockCentreDeTri.getListeMenages();
        assertTrue(menages.stream().anyMatch(m -> m.getUsername().equals("leandre")));
    }
    

    @Test
    public void testLoginSuccess() {
    	appli.creerCompte("leandre", "leandre24");
        appli.login("leandre", "leandre24");
        assertNotNull(appli.getMenageActuel());
        assertEquals("leandre", appli.getMenageActuel().getUsername());
    }
    @Test
    public void testLoginFail() {
        appli.login("leandre", "bisounours");
        assertNull(appli.getMenageActuel());
    }

    @Test
    public void testConsulterPointsTotal() {
    	appli.creerCompte("leandre", "leandre24");
        appli.login("leandre", "leandre24");
        float points = appli.consulterPointsTotal();
        assertEquals(0, points);
    }

    @Test
    public void testConvertirPointsEnBon() {
        // Create the account first
        appli.creerCompte("leandre", "leandre24");

        // Login with the created account
        appli.login("leandre", "leandre24");

        // Ensure the login was successful
        assertNotNull(appli.getMenageActuel());

        // Add points and test conversion
        appli.getMenageActuel().addPoints(100f);
        assertNotNull(appli.convertirPointsEnBon("TestCommerce"));
        assertEquals(0f, appli.getMenageActuel().getTotalPoints());
    }
   

    @Test
    public void testAfficherListeDepots() {
        appli.login("leandre", "leandre24");
        List<?> depots = appli.afficherListeDepots();
        assertNotNull(depots);
    }

    @Test
    public void testAfficherListeCommerces() {
        List<String> commerces = appli.afficherListeCommerces();
        assertNotNull(commerces);
    }
    

    @Test
    public void testLogout() {
        appli.login("leandre", "leandre24");
        appli.logout();
        assertNull(appli.getMenageActuel());
    }
}

