package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String producer = Vehicle.producer();

        Vehicle vehicle = new VehicleImpl();
        String overview = vehicle.getOverview();

        String[] vName = new String[]{"Honda", "Hyundai", "", null, "Lancer"};
        List<String> vNameList = Arrays.asList(vName);

        long s = vNameList.stream().
                filter(name -> Vehicle.isRealVehicle(name)).
                count();

        System.out.println(s);
    }
}
