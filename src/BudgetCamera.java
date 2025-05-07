public class BudgetCamera extends DatasetCamera {
    private boolean untukPemula;

    public BudgetCamera(String model, int releaseDate, double maxResolution, double lowResolution, double effectivePixel,
                        double zoomWide, double zoomTele, double normalFocusRange, double macroFocusRange,
                        double storageIncluded, double weight, double dimensions, double price) {

        super(model, releaseDate, maxResolution, lowResolution, effectivePixel, zoomWide, zoomTele,
                normalFocusRange, macroFocusRange, storageIncluded, weight, dimensions, price);


        this.untukPemula = price < 500;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Direkomendasikan untuk pemula: " + (untukPemula ? "Ya" : "Tidak"));
    }
}

