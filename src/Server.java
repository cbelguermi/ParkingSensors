public class Server
{
    private boolean parking_places[]; // true si emplacement occupe
    /** Constructeur privé */
    private Server()
    {
        parking_places = new boolean[3];
        for (boolean place : parking_places)
        {
            place = false;
        }
    }

    /** Instance unique non préinitialisée */
    private static Server INSTANCE = null;

    /** Point d'accès pour l'instance unique du singleton */
    public static Server getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new Server();
        }
        return INSTANCE;
    }

    public void getLine(String line)
    {
        this.getData(this.serverFilter1(line), this.serverGetPlaceNumber(line));
    }

    public void getData(String data, int placeNumber)
    {
        if (data == Sensor.DETECTED)
        {
            parking_places[placeNumber] = true;
        }
        else if (data == Sensor.UNDETECTED)
        {
            parking_places[placeNumber] = false;
        }
        printPlaceState(placeNumber);
    }

    String serverFilter1(String line)
    {
        if (line.length() != Sensor.LINE_LENGTH)
        {
            System.out.println("ERROR - BAD LINE LENGTH");
            return "ERROR";
        }
        char state = line.charAt(Sensor.STATE_POSITION);
        if (state == '1')
        {
            return Sensor.DETECTED;
        }
        else if (state == '0')
        {
            return Sensor.UNDETECTED;
        }
        else
        {
            System.out.println("ERROR - BAD STATE CHARACTER");
            return "ERROR";
        }
    }

    int serverGetPlaceNumber(String line)
    {
        if (line.length() != Sensor.LINE_LENGTH)
        {
            System.out.println("ERROR - BAD LINE LENGTH");
            return -1;
        }
        int placeNb = Integer.parseInt(new StringBuilder().append(line.charAt(0)).append(line.charAt(1)).toString());
        placeNb--;
        return placeNb;
    }

    private void printPlaceState (int placeNumber)
    {
        String state;
        if (isEmpty(placeNumber))
        {
            state = "empty";
        }
        else
        {
            state = "occupied";
        }
        System.out.println("Place number " + placeNumber + " is " + state);
    }

    public boolean isEmpty(int placeNumber)
    {
        return !(parking_places[placeNumber]);
    }

    public boolean[] getPlaces()
    {
        return parking_places;
    }
}
