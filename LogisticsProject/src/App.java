import AdomLogisticsConsoleApp.AdomBanner;

public class App {
    private static final int BANNER_WIDTH = 50;
    private static final AdomBanner adomBanner = new AdomBanner(BANNER_WIDTH);

    public static void main(String[] args) {
        try {
            adomBanner.selectMenuItem();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
