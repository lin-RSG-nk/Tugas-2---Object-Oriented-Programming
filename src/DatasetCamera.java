public class DatasetCamera {
    private String model;
    private int releaseDate;
    private double maxResolution;
    private double lowResolution;
    private double effectivePixel;
    private double zoomWide;
    private double zoomTele;
    private double normalFocusRange;
    private double macroFocusRange;
    private double storageIncluded;
    private double weight;
    private double dimensions;
    private double price;

    public DatasetCamera() {

    }

    public DatasetCamera(String model, int releaseDate, double maxResolution, double lowResolution, double effectivePixel,
                         double zoomWide, double zoomTele, double normalFocusRange, double macroFocusRange,
                         double storageIncluded, double weight, double dimensions, double price) {
        this.model = model;
        this.releaseDate = releaseDate;
        this.maxResolution = maxResolution;
        this.lowResolution = lowResolution;
        this.effectivePixel = effectivePixel;
        this.zoomWide = zoomWide;
        this.zoomTele = zoomTele;
        this.normalFocusRange = normalFocusRange;
        this.macroFocusRange = macroFocusRange;
        this.storageIncluded = storageIncluded;
        this.weight = weight;
        this.dimensions = dimensions;
        this.price = price;
    }


    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getReleaseDate() { return releaseDate; }
    public void setReleaseDate(int releaseDate) {this.releaseDate = releaseDate;}

    public double getMaxResolution() { return maxResolution; }
    public void setMaxResolution(double maxResolution) { this.maxResolution = maxResolution; }

    public double getLowResolution() { return lowResolution; }
    public void setLowResolution(double lowResolution) { this.lowResolution = lowResolution; }

    public double getEffectivePixel() { return effectivePixel; }
    public void setEffectivePixel(double effectivePixel) { this.effectivePixel = effectivePixel; }

    public double getZoomWide() { return zoomWide; }
    public void setZoomWide(double zoomWide) { this.zoomWide = zoomWide; }

    public double getZoomTele() { return zoomTele; }
    public void setZoomTele(double zoomTele) { this.zoomTele = zoomTele; }

    public double getNormalFocusRange() { return normalFocusRange; }
    public void setNormalFocusRange(double normalFocusRange) { this.normalFocusRange = normalFocusRange; }

    public double getMacroFocusRange() { return macroFocusRange; }
    public void setMacroFocusRange(double macroFocusRange) { this.macroFocusRange = macroFocusRange; }

    public double getStorageIncluded() { return storageIncluded; }
    public void setStorageIncluded(double storageIncluded) { this.storageIncluded = storageIncluded; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getDimensions() { return dimensions; }
    public void setDimensions(double dimensions) { this.dimensions = dimensions; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public void printInfo() {
        System.out.println("Model: " + model);
        System.out.println("Berat: " + weight + " gram");
        System.out.println("Harga: $" + price);
    }


    public void printInfo(boolean fullDetail) {
        if (fullDetail) {
            System.out.println("--- Detail Kamera ---");
            System.out.println("Model: " + model);
            System.out.println("Release Date: " + releaseDate);
            System.out.println("Max Resolution: " + maxResolution);
            System.out.println("Low Resolution: " + lowResolution);
            System.out.println("Effective Pixel: " + effectivePixel);
            System.out.println("Zoom Wide: " + zoomWide);
            System.out.println("Zoom Tele: " + zoomTele);
            System.out.println("Normal Focus: " + normalFocusRange);
            System.out.println("Macro Focus: " + macroFocusRange);
            System.out.println("Storage: " + storageIncluded);
            System.out.println("Weight: " + weight);
            System.out.println("Dimensions: " + dimensions);
            System.out.println("Price: $" + price);
        } else {
            printInfo();
        }
    }
}
