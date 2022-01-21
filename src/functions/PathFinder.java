package functions;

import java.nio.file.Paths;

public class PathFinder
{
    public static class Images
    {
        public static String getImage(String filename)
        {
            return Paths.get("").toAbsolutePath() + "\\src\\resources\\image\\" + filename;
        }
    }
}
