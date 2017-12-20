import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String [] args)
    {
        ArrayList<Sensor> sensors = new ArrayList<>(3);
        sensors.add(new Sensor());
        sensors.add(new SensorFilter1());
        sensors.add(new SensorFilter2());

        for (Sensor sensor : sensors)
        {
            sensor.activate();
        }

        boolean running = true;
        Random randomGenerator = new Random();
        int linesCount = IDataReader.getLinesCount(Paths.get("../res/data.txt"));
        int randomLine;

        while (running)
        {
            for (Sensor sensor : sensors)
            {
                randomLine = randomGenerator.nextInt(linesCount);
                String line = IDataReader.getLine(Paths.get("../res/data.txt"), randomLine);

            }
        }
    }
}
