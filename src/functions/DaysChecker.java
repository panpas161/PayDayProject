package functions;

import model.event.SundayFootballDay;
import model.event.ThursdayRiseValueCrypto;

import java.io.IOException;

public class DaysChecker {
    public static class Days
    {
        public static String getDay(int number)
        {
            String[] days = {
                    "Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday",
                    "Saturday",
                    "Sunday"
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
        public static void checkDayEvent(int position)
        {
            if(getDay(position).equals("Sunday"))
            {
                try
                {
                    new SundayFootballDay();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            else if(getDay(position).equals("Thursday"))
            {
                try
                {
                    new ThursdayRiseValueCrypto();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
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
