class Sensor {

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

}
