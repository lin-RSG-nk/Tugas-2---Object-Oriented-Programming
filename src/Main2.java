
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        String[] daftarNamaFile = {getFile()};
        DatasetCamera[] listCamera = loadCamera(daftarNamaFile);

        DatasetCamera[] filterDatasetCamera = cariNetflixShows(listCamera);
        // O(1)
        System.out.println("Camera release in 2000 = " + filterDatasetCamera.length);
        saveToFile("filtered.csv", filterDatasetCamera);

    }

    public static String getFile() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Masukkan file: ");
        return scn.nextLine();
    }

    public static DatasetCamera[] loadCamera(String[] daftarNamaFile) {
        List<DatasetCamera> list = new ArrayList<>();

        for (String namaFile : daftarNamaFile) {
            try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
                br.readLine(); // skip header
                String line;

                while ((line = br.readLine()) != null) {
                    DatasetCamera camera = CameraUtils.parseLine(line);
                    if (camera != null) {
                        list.add(camera);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        return list.toArray(new DatasetCamera[0]);
    }

    public static DatasetCamera[] cariNetflixShows(DatasetCamera[] listCamera) {

        List<DatasetCamera> filteredShows = new ArrayList<>();

        // Algoritma Pencarian (Searching)
        for (int i = 0; i < listCamera.length; i++) {

            if (listCamera[i] == null) {
                continue;
            }

            // O(1)
            if (listCamera[i].getReleaseDate() == 2000) {
                filteredShows.add(listCamera[i]);
            }
        }
        return filteredShows.stream().toArray(DatasetCamera[] ::new);

    }

    public static void saveToFile(String fileName, DatasetCamera[] data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (DatasetCamera row : data) {
                writer.append(row.getModel() + ",");
                writer.append(row.getReleaseDate() + ",");
                writer.append(row.getMaxResolution() + ",");
                writer.append(row.getLowResolution() + ",");
                writer.append(row.getEffectivePixel() + ",");
                writer.append(row.getZoomWide() + ",");
                writer.append(row.getZoomTele() + ",");
                writer.append(row.getNormalFocusRange() + ",");
                writer.append(row.getMacroFocusRange() + ",");
                writer.append(row.getStorageIncluded() + ",");
                writer.append(row.getWeight() + ",");
                writer.append(row.getDimensions() + ",");
                writer.append(row.getPrice() + ",");
                writer.append("\n");
            }
            System.out.println("Data berhasil ditulis ke " + fileName);
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }
    }
}