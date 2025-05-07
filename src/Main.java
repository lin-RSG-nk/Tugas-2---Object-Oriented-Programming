import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String file = "camera_dataset.csv";
        DatasetCamera[] listCamera = new DatasetCamera[1038];

        if (!file.endsWith(".csv")) {
            System.out.println("File harus berformat CSV !!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String baris;
            int idx = 0;

            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                if (data.length < 13) {
                    System.out.println("Baris tidak valid, dilewati.");
                    continue;
                }

                try {
                    DatasetCamera camera = new DatasetCamera(
                            data[0],
                            parseIntOrDefault(data[1], 1),
                            parseDoubleOrDefault(data[2], 1.0),
                            parseDoubleOrDefault(data[3], 1.0),
                            parseDoubleOrDefault(data[4], 1.0),
                            parseDoubleOrDefault(data[5], 1.0),
                            parseDoubleOrDefault(data[6], 1.0),
                            parseDoubleOrDefault(data[7], 1.0),
                            parseDoubleOrDefault(data[8], 1.0),
                            parseDoubleOrDefault(data[9], 1.0),
                            parseDoubleOrDefault(data[10], 1.0),
                            parseDoubleOrDefault(data[11], 1.0),
                            parseDoubleOrDefault(data[12], 1.0)
                    );
                    listCamera[idx++] = camera;
                } catch (Exception e) {
                    System.out.println("Error parsing angka: " + e.getMessage());
                }
            }

            for (int i = 0; i < listCamera.length; i++) {
                if (listCamera[i] != null && listCamera[i].getModel().equalsIgnoreCase("HP Photosmart R927")) {
                    listCamera[i].printInfo(true);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

    private static double parseDoubleOrDefault(String value, double defaultValue) {
        return (value == null || value.trim().isEmpty()) ? defaultValue : Double.parseDouble(value.trim());
    }

    private static int parseIntOrDefault(String value, int defaultValue) {
        return (value == null || value.trim().isEmpty()) ? defaultValue : Integer.parseInt(value.trim());
    }
}
