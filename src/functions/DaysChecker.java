package functions;

public class DaysChecker {
    public static class Days
    {
        public static String getDay(int number)
        {
            String[] days = {
                    "monday",
                    "tuesday",
                    "wednesday",
                    "thursday",
                    "friday",
                    "saturday",
                    "sunday"
            };
            String[] dayNumber = new String[32];
            int j = 0;
            for(int i=0;i<dayNumber.length;i++)
            {
                dayNumber[i] = days[j];
                if(j++==6)
                {
                    j=0;
                }
            }
            return dayNumber[number];
        }
    }
    public static class DayLogos
    {
        public static String getImageDayPath(int number)
        {
            return "";
        }
    }
}
