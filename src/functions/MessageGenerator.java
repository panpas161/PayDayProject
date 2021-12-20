package functions;

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
        public static String getDescription()
        {
            String[] descriptions = {
                ""
            };
            return descriptions[0];
        }
    }
    public static class Charity
    {
        public static String getDescription()
        {
            String[] descriptions = {
                ""
            };
            return descriptions[0];
        }
    }
    public static class MoveToDealOrBuyer
    {
        public static String getDescription()
        {
            String[] descriptions = {
                ""
            };
            return descriptions[0];
        }
    }
    public static class PayNeighbor
    {
        public static String getDescription()
        {
            String[] descriptions = {
                    ""
            };
            return descriptions[0];
        }
    }
    public static class TakeFromNeighbor
    {
        public static String getDescription()
        {
            String[] descriptions = {
                    ""
            };
            return descriptions[0];
        }
    }
}
