package task3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateReport {
    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }

        String testsFile = args[0];
        String valuesFile = args[1];

        try {
            BufferedReader testsReader = new BufferedReader(new FileReader(testsFile));
            String testsData = "";
            String line;
            while ((line = testsReader.readLine()) != null) {
                testsData += line;
            }
            testsReader.close();

            BufferedReader valuesReader = new BufferedReader(new FileReader(valuesFile));
            String valuesData = "";
            while ((line = valuesReader.readLine()) != null) {
                valuesData += line;
            }
            valuesReader.close();

            JSONObject testsJson = new JSONObject(testsData);
            JSONArray valuesJson = new JSONArray(valuesData);

            fillValues(testsJson, valuesJson);

            FileWriter reportWriter = new FileWriter("report.json");
            reportWriter.write(testsJson.toString());
            reportWriter.close();


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private static void fillValues(JSONObject testsJson, JSONArray valuesJson) throws JSONException {
        if (testsJson.has("value") && testsJson.has("id")) {
            int testId = testsJson.getInt("id");

            for (int i = 0; i < valuesJson.length(); i++) {
                JSONObject valueObj = valuesJson.getJSONObject(i);
                if (valueObj.has("id") && valueObj.getInt("id") == testId) {
                    testsJson.put("value", valueObj.getString("value"));
                    break;
                }
            }
        }

        if (testsJson.has("values")) {
            JSONArray nestedValues = testsJson.getJSONArray("values");

            for (int i = 0; i < nestedValues.length(); i++) {
                fillValues(nestedValues.getJSONObject(i), valuesJson);
            }
        }
    }
}
