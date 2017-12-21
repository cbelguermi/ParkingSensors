class SensorFilter2 extends SensorFilter1 {

    private String previousState;
    public static final String FIRST_ACTIVATION = "FIRST_ACTIVATION";

    SensorFilter2()
    {
        super();
        previousState = FIRST_ACTIVATION;
    }

    @Override
    void send(String line)
    {
        if (filter2(filter1(line)))
        {
            super.send(line);
        }
    }

    boolean filter2(String data)
    {
        if (data != DETECTED && data != UNDETECTED)
        {
            return false;
        }

        if (previousState == FIRST_ACTIVATION)
        {
            previousState = data;
            return true;
        }

        if (data == DETECTED && previousState == UNDETECTED)
        {
            previousState = DETECTED;
            return true;
        }
        else if (data == UNDETECTED && previousState == DETECTED)
        {
            previousState = UNDETECTED;
            return true;
        }
        else
        {
            return false;
        }
    }

}
