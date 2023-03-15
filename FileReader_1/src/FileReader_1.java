import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_1
{
    public static void main(String[] args) throws IOException
    {
        String fileName = "example.txt";

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            br.close();
        }
    }
}


