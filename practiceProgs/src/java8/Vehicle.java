package java8;

public interface Vehicle {
    static String producer() {
        return "N&F Vehicles";
    }

    static boolean isRealVehicle(String s) {
        return s != null && !s.isEmpty();
    }

    default String getOverview() {
        return "ATV made by " + producer();
    }
}
