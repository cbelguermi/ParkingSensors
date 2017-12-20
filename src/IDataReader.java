import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public interface IDataReader {

    static int getLinesCount(Path file)
    {
        int lines = 0;
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file, charset))
        {
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                lines ++;
            }
        }
        catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }
        return lines;
    }

    static String getLine(Path file, int lineNumber)
    {
        int lines = 0;
        String line = null;
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file, charset))
        {
            while ((line = reader.readLine()) != null && (lines < lineNumber))
            {
                lines ++;
            }
        }
        catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }
        return line;
    }

}
