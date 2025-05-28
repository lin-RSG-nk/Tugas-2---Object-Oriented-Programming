public class CameraUtils {
    public static DatasetCamera parseLine(String line) {
        String[] data = line.split(",");
        if (data.length < 13) return null;

        try {
            return new DatasetCamera(
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
        } catch (Exception e) {
            System.out.println("Gagal parsing baris: " + e.getMessage());
            return null;
        }
    }

    private static double parseDoubleOrDefault(String value, double defaultValue) {
        return (value == null || value.trim().isEmpty()) ? defaultValue : Double.parseDouble(value.trim());
    }

    private static int parseIntOrDefault(String value, int defaultValue) {
        return (value == null || value.trim().isEmpty()) ? defaultValue : Integer.parseInt(value.trim());
    }
}
