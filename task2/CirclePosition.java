package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CirclePosition {
    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }

        String circleFile = args[0];
        String pointsFile = args[1];

        try {
            BufferedReader circleReader = new BufferedReader(new FileReader(circleFile));
            String circleData = circleReader.readLine();
            circleReader.close();

            String[] circleCoordinates = circleData.split(" ");
            float circleX = Float.parseFloat(circleCoordinates[0]);
            float circleY = Float.parseFloat(circleCoordinates[1]);
            float radius = Float.parseFloat(circleCoordinates[2]);

            BufferedReader pointsReader = new BufferedReader(new FileReader(pointsFile));

            String pointData;
            while ((pointData = pointsReader.readLine()) != null) {
                String[] pointCoordinates = pointData.split(" ");
                float pointX = Float.parseFloat(pointCoordinates[0]);
                float pointY = Float.parseFloat(pointCoordinates[1]);


                float distance = (float) Math.sqrt(Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2));


                if (distance < radius) {
                    System.out.println("1");
                } else if (distance > radius) {
                    System.out.println("2");
                } else {
                    System.out.println("0");


                }
            }

            pointsReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
