class Sensor {

    public static final int LINE_LENGTH = 14;
    public static final int STATE_POSITION = 9;
    public static final String DETECTED = "DETECTE";
    public static final String UNDETECTED = "NA";

    int id;
    int range;
    int rate;
    private boolean activated;

    Sensor()
    {
        activated = false;
    }

    void activate()
    {
        activated = true;
    }

    void send(String line)
    {
        Server.getInstance().getLine(line);
    }
}
