import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class ClientMain {

    public static void main(String [] args)
    {
        boolean parking_places[] = Server.getInstance().getPlaces();
        int placeNumber = 0;
        String state;
        for (boolean place : parking_places)
        {
            System.out.println(place);
            if (!place)
            {
                state = "empty";
            }
            else
            {
                state = "occupied";
            }
            System.out.println("Place number " + placeNumber + " is " + state);
            placeNumber++;
        }
    }
}
