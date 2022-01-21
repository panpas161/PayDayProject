package functions;

import model.deck.DealCardDeck;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MessageGenerator {
    public static class Advertisement
    {
        public static String getDescription()
        {
            String[] descriptions = {
                "Βαριέσαι στα διαλείμματα δες λιγο ΤικΤοκ",
                "Δες Netflix άσε την σχολή",
                "Άσε το Θείο Διάβασε Java",
                "Java... Ποια Amstel?",
                "29 κατασκευαστές πλυντηρίων συνιστούν Skip",
                "11888 Σούπερ Αριθμός",
                "Μοιράσου μία Coca Cola με τον συμφοιτοιτή σου",
                "Για να είναι η μέρα σου ωραία Oreo!"
            };
            return descriptions[0]; // we'll return a random one on phase B
        }
    }
    public static class Bill
    {
        public static String getChoice()
        {
            return "Κράτα τον λογαριασμό";
        }
        public static String getDescription(int randomValue)
        {
            String[] descriptions = {
                "Πληρωμή 500 Ευρώ για την πρώτη δόση του ΕΝΦΙΑ",
                "Πληρωμή 50 Ευρώ για τον Λογαριασμο Τηλεφώνου",
                "Πληρωμή 200 Ευρώ για τον Λογαριασμο της ΔΕΗ",
                "Πληρωμή 1500 Ευρώ για την προκαταβολή του αυτοκινήτου",
                "Πληρωμή 250 Ευρώ για το Ενοίκιο",
                "Πληρωμή 1000 Ευρώ για τη δόση του Στεγαστικού Δανείου",
                "Πληρωμή 200 Ευρω για την ασφάλεια του αυτοκινήτου",
                "Πληρωμή 500 Ευρώ για την δόση της Εφορίας"
            };
            return descriptions[randomValue];
        }
        public static int getValue(int randomValue)
        {
            int[] values = {
                    500,
                    50,
                    200,
                    1500,
                    250,
                    1000,
                    200,
                    500
            };
            return values[randomValue];
        }
        public static BufferedImage getImage(int randomValue)
        {
            String[] images = {
                    "enfia.jpg",
                    "cosmote.jpg",
                    "deh.jpg",
                    "car.png",
                    "enoikio.jpg",
                    "daneio.jpg",
                    "asfaleia.jpg",
                    "eforia.jpg"
            };
            try {
                return ImageIO.read(new File(PathFinder.Images.getImage(images[randomValue])));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public static class Charity
    {
        public static int getValue(int randomValue)
        {
            int[] values = {
                50,
                100,
                200,
                300,
                150,
                350,
                250,
                250
            };
            return values[randomValue];
        }
        public static String getChoice(int randomValue)
        {
            String[] choices = {
                " Πλήρωσε 50 Ευρώ στο Jackpot",
                " Πλήρωσε 100 Ευρώ στο Jackpot",
                " Πλήρωσε 200 Ευρώ στο Jackpot",
                " Πλήρωσε 300 Ευρώ στο Jackpot",
                " Πλήρωσε 150 Ευρώ στο Jackpot",
                " Πλήρωσε 350 Ευρώ στο Jackpot",
                " Πλήρωσε 250 Ευρώ στο Jackpot",
                " Πλήρωσε 250 Ευρώ στο Jackpot"
            };
            return choices[randomValue];
        }
        public static String getDescription(int randomValue)
        {
            String[] descriptions = {
                "Διάσωση χελώνας Καρέτα-Καρέτα",
                "Σώσε τα αδέσποτα",
                "Βοήθησε τους Γιατρούς χωρίς σύνορα",
                "Βοήθησε τη Unicef",
                "Προστασία της άγριας ζωής- Αρκτούρος",
                "Όλοι μαζί μπορούμε",
                "Σώσε το Περιβάλλον-Greenpeace",
                "Αλληλεγγύη για όλους"
            };
            return descriptions[randomValue];
        }
        public static BufferedImage getImage(int randomValue)
        {
            String[] images = {
                "caretta.jpg",
                "adespoto.jpg",
                "doctor.jpg",
                "unicef.png",
                "arktouros.jpg",
                "mporoume.jpg",
                "greenpeace.jpg",
                "voitheia.jpg"
            };
            try {
                return ImageIO.read(new File(PathFinder.Images.getImage(images[randomValue])));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public static class MoveToDealOrBuyer
    {
        public static String getDescription()
        {

            return "Πηγαίνετε στην επόμενη θέση Συμφωνίας/Αγοραστή";
        }
        public static BufferedImage getImage()
        {
            try {
                return ImageIO.read(new File(PathFinder.Images.getImage("db.jpg")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        public static String getChoice()
        {
            return "Εντάξει";
        }
    }
    public static class PayNeighbor
    {
        public static String getDescription()
        {
            String[] descriptions = {
                    "Αγορά μεταχειρισμένης οθόνης από το γείτονα\n" +
                    "Ο γείτονας παίρνει πτυχίο\n" +
                    "Δώσε τα κοινόχρηστα στο γείτονα\n" +
                    "Ιδιαίτερα μαθήματα κιθάρας από το γείτονα\n" +
                    "Δώσε πίσω τα δανεικά που σου έδωσε ο γείτονας για να αγοράσεις Laptop\n" +
                    "Ο γείτονας κράτησε τον σκύλο σου στις διακοπές\n" +
                    "Ο γείτονας πουλάει λαχνούς\n" +
                    "Ο γείτονας παντρεύεται\n"
            };
            return descriptions[0];
        }
    }
    public static class TakeFromNeighbor
    {
        public static String getDescription()
        {
            String[] descriptions = {
                    "Format στον υπολογιστή του γείτονα\n" +
                    "Κράτηση της γάτας του γείτονα λόγω διακοπών\n" +
                    "Πήγες το αυτοκίνητο του γείτονα στο ΚΤΕΟ\n" +
                    "Ιδιαίτερα μαθήματα αγγλικών στο γείτονα\n" +
                    "Πάρε πίσω τα δανεικά που έδωσες στο γείτονα για να αγοράσει μηχανή\n" +
                    "Πώληση μεταχειρισμένου Playstasion 3 στο Γείτονα\n" +
                    "Πάρε τα χρήματα για τη δόση του πετρελαίου από το γείτονα\n" +
                    "Ο γείτονας σου δίνει χρήματα για τη γιορτή σου\n"
            };
            return descriptions[0];
        }
    }
    public static class DealCard
    {
        public static String getTitle()
        {
            return "Συμφωνία";
        }
        public static int getCost(int randomValue)
        {
            int[] costs = {
                7000,
                500,
                3000,
                4000,
                200,
                5000,
                700,
                200,
                1000,
                2000,
                1200,
                1500,
                250,
                1000,
                12000,
                3000,
                10000,
                900,
                700,
                5000
            };
            return costs[randomValue];
        }

        public static int getValue(int randomValue)
        {
            int[] values = {
                10000,
                700,
                5000,
                7000,
                400,
                9000,
                1400,
                500,
                1700,
                4000,
                2000,
                3000,
                550,
                2000,
                21000,
                6000,
                18000,
                1800,
                1200,
                9500
            };
            return values[randomValue];
        }

        public static String getDescription(int randomValue)
        {
            String[] descriptions = {
                    "Αγορά Αυτοκινήτου σε τιμή ευκαιρίας",
                    "Αγορά i-phone 13 από Ιαπωνία",
                    "Αγορά Ethereum",
                    "Αγορά Μηχανής",
                    "Αγορά Playstasion 5 από Κορέα",
                    "Αγορά Ταχύπλοου",
                    "Αγορά Εισιτηρίου VIP για τον τελικό του Champions League",
                    "Αγορά Εισιτηρίου για την συναυλία των Iron Maiden",
                    "Αγορά Macbook aπό το eBay",
                    "Αγορά Χρυσού Ρολογιού",
                    "Αγορά Επαγγελματικής Φωτογραφικής Μηχανής",
                    "Αγορά Ελαιόλαδου",
                    "Αγορά Σκύλου Yorkshire Terrier",
                    "Αγορά Μετοχών στο Facebook",
                    "Αγορά Οικοπέδου στο Ελαφονήσι",
                    "Αγορά Συλλεκτικής Κιθάρας",
                    "Αγορά Καταστήματος στο Talos Plaza",
                    "Αγορά Εισητηρίου για τον τελικό του NBA",
                    "Αγορά Σπάνιας Γάτας",
                    "Αγορά Ζαχαροπλαστείου"
            };
            return descriptions[randomValue];
        }
        public static BufferedImage getImage(int randomValue)
        {
            String[] images = {
                    "tesla.jpg",
                    "iphone.png",
                    "ethereum.png",
                    "honda.jpg",
                    "ps5.jpg",
                    "taxyploo.jpg",
                    "chl.jpg",
                    "maiden.jpg",
                    "laptop.jpg",
                    "watch.jpg",
                    "camera.jpg",
                    "elaiolado.jpg",
                    "terrier.jpg",
                    "facebook.jpg",
                    "elafonisi.jpg",
                    "guitar2.jpg",
                    "talos.jpg",
                    "nba.jpg",
                    "spania.jpeg",
                    "zaxar.jpg"
            };
            try{
                return ImageIO.read(new File(PathFinder.Images.getImage(images[randomValue])));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        public static String getChoiceOne()
        {
            return "Αγόρασε";
        }
        public static String getChoiceTwo()
        {
            return "Αγνόησε τη Συμφωνία";
        }
    }

    public static class Player
    {
        public static String playerActions()
        {
            String[] actions = {
                "Draw Card",
                "",
                ""
            };
            return actions[0];
        }
    }
}
