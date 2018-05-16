package si.ijs.maslick.ai.realtor;

public class FeatureHelper {
    public static double calcHouseSize(House house) {
        return house.getHouseSize();
    }

    public static double calcLotSize(House house) {
        return house.getLotSize();
    }

    public static double calcBedrooms(House house) {
        return house.getBedrooms();
    }

    public static double calcGranite(House house) {
        return house.getGranite();
    }

    public static double calcNumberOfBathrooms(House house) {
        return house.getBathroom();
    }
}