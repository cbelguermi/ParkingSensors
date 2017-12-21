class SensorFilter1 extends Sensor {

    @Override
    void send(String line)
    {
        Server.getInstance().getData(this.filter1(line), this.getPlaceNumber(line));
    }

    String filter1(String line)
    {
        if (line.length() != LINE_LENGTH)
        {
            System.out.println("ERROR - BAD LINE LENGTH");
            return "ERROR";
        }
        char state = line.charAt(STATE_POSITION);
        if (state == '1')
        {
            return DETECTED;
        }
        else if (state == '0')
        {
            return UNDETECTED;
        }
        else
        {
            System.out.println("ERROR - BAD STATE CHARACTER");
            return "ERROR";
        }
    }

    int getPlaceNumber(String line)
    {
        if (line.length() != LINE_LENGTH)
        {
            System.out.println("ERROR - BAD LINE LENGTH");
            return -1;
        }
        int placeNb = Integer.parseInt(new StringBuilder().append(line.charAt(0)).append(line.charAt(1)).toString());
        placeNb--;
        return placeNb;
    }

}
