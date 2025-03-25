import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Main {
    public static void main(String[] args) {

        String nameFile = "camera_dataset.csv";
        DatasetCamera [] listCamera = new DatasetCamera[1038];

        if (!nameFile.endsWith(".csv")) {
            System.out.println("File harus berformat CSV !!");
            return;
        }



        try (BufferedReader br = new BufferedReader(new FileReader(nameFile))){

            br.readLine();
            String line;

            int idx = 0;

            while((line = br.readLine())!= null) {
                String[] data = line.split(",");

                if (data.length < 12) {
                    System.out.println("Baris tidak valid, dilewati.");
                    continue;
                }
                DatasetCamera lc = new DatasetCamera();
                lc.model = data[0];
                try {
                    lc.realeaseDate = parseIntOrDefault(data[1], -1);
                    lc.maxResolution = parseDoubleOrDefault(data[2], -1.0);
                    lc.lowResolution = parseDoubleOrDefault(data[3], -1.0);
                    lc.effectivePixel = parseDoubleOrDefault(data[4], -1.0);
                    lc.zoomWide = parseDoubleOrDefault(data[5], -1.0);
                    lc.zoomTele = parseDoubleOrDefault(data[6], -1.0);
                    lc.normalFocusRange = parseDoubleOrDefault(data[7], -1.0);
                    lc.macroFocusRange = parseDoubleOrDefault(data[8], -1.0);
                    lc.storageIncluded = parseDoubleOrDefault(data[9], -1.0);
                    lc.weight = parseDoubleOrDefault(data[10], -1.0);
                    lc.dimensions = parseDoubleOrDefault(data[11], -1.0);
                    lc.price = parseDoubleOrDefault(data[12], -1.0);

                } catch (Exception ex) {
                    System.out.println("Error parsing angka pada baris " + line);
                    System.out.println("Error" + ex.getMessage());
                    continue;
                }
                listCamera[idx] = lc;
                idx++;

            }
            for (int i = 0; i < listCamera.length; i++) {
                if (listCamera[i].model.equalsIgnoreCase("HP Photosmart R927")){
                    System.out.println("Model :"+listCamera[i].model + " Berat :"+ listCamera[i].weight);
                    break;
                }
            }
        }catch (FileNotFoundException ex) {
            System.out.println("File tidak di temukan :"+ nameFile);
        }catch (Exception ex) {
            System.out.println("Error "+ ex.getMessage());
        }
    }
    private static double parseDoubleOrDefault(String value, double defaultValue) {
        return (value == null || value.trim().isEmpty()) ? defaultValue : Double.parseDouble(value);
    }
    private static int parseIntOrDefault(String value, int defaultValue) {
        return (value == null || value.trim().isEmpty()) ? defaultValue : Integer.parseInt(value);
    }
}
