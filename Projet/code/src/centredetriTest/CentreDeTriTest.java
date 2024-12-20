package centredetriTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.centredetri.CentreDeTri;
import com.centredetri.Contrat;
import com.centredetri.Menage;
import com.centredetri.Poubelle;
import com.centredetri.TypeDechet;

public class CentreDeTriTest {

    private CentreDeTri centreDeTri;

    @BeforeEach
    public void setUp() {
        centreDeTri = new CentreDeTri("trierBien", "8 boulevard saint martin");
        centreDeTri.setNom("Centre Test");
        centreDeTri.setAdresse("123 Rue Exemple");
    }

    @Test
    public void testInitialisation() {
        assertEquals("Centre Test", centreDeTri.getNom());
        assertEquals("123 Rue Exemple", centreDeTri.getAdresse());
        assertTrue(centreDeTri.getListeMenages().isEmpty());
        assertTrue(centreDeTri.getListeContratsPasses().isEmpty());
        assertTrue(centreDeTri.getListePoubelles().isEmpty());
    }

    @Test
    public void testAjouterMenage() {
        centreDeTri.ajouterMenage("maxime", "maxime24");

        List<Menage> menages = centreDeTri.getListeMenages();
        assertEquals(1, menages.size());
    }

    @Test
    public void testAjouterPoubelle() {
    	List<TypeDechet> listeDechets = new ArrayList<TypeDechet>();
		listeDechets.add(TypeDechet.PLASTIQUE);
        centreDeTri.ajouterPoubelle(listeDechets, "rue du clos saint george");

        List<Poubelle> poubelles = centreDeTri.getListePoubelles();
        assertEquals(1, poubelles.size());;
    }

    @Test
    public void testContratManagement() {
    	String dateStr = "04/12/2027";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
		
		Contrat contrat = new Contrat(parsedDate, "électro-ménager");
		
        centreDeTri.ajouterContratEnCours(parsedDate, "conserves");

        List<Contrat> contratsEnCours = centreDeTri.getListeContratsEnCours();
        assertEquals(1, contratsEnCours.size());

        centreDeTri.supprimerContratEnCours(contrat);

        List<Contrat> contratsPasses = centreDeTri.getListeContratsPasses();
        assertEquals(1, contratsPasses.size());
    }
}
