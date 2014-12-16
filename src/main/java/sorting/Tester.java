package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 25/06/13
 * Time: 23:57
 */
public class Tester {

    public static void main(String[] args) {


        List<Vehicle> vehicleList = fillVehicles();
        showList(vehicleList);
        Collections.sort(vehicleList, new VehicleComparatorById());
        showList(vehicleList);
        Collections.sort(vehicleList, new VehicleComparatorByRegistration());
        showList(vehicleList);
        Collections.sort(vehicleList, new VehicleComparatorByCity());
        showList(vehicleList);

    }


    private static List<Vehicle> fillVehicles() {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList.add(new Vehicle(1,  "xa1", "A"));
        vehicleList.add(new Vehicle(2,  "aab", "C"));
        vehicleList.add(new Vehicle(3,  "aba", "C"));
        vehicleList.add(new Vehicle(4,  "zb1", "A"));
        vehicleList.add(new Vehicle(5,  "aaa", "B"));
        vehicleList.add(new Vehicle(6,  "aa2", "A"));
        vehicleList.add(new Vehicle(7,  "baa", "C"));
        vehicleList.add(new Vehicle(8,  "xaa", "Z"));
        vehicleList.add(new Vehicle(9,  "aaa", ""));
        vehicleList.add(new Vehicle(0, "aa3", "A"));

        return vehicleList;
    }

    private static void showList(List<Vehicle> vehicleList) {
        System.out.println("------start-list------");
        System.out.println("id,     reg number,     city     ");
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getId() + "      " + vehicle.getRegistrationNumber() + "      " + vehicle.getOwnCity());
        }
        System.out.println("-------end-list------");
    }

    private static class VehicleComparatorById implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            if (o1.getId() < o2.getId()) {
                return -1;
            } else if (o1.getId() > o2.getId()) {
                return 1;
            } else return 0;
        }
    }

    private static class VehicleComparatorByRegistration implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getRegistrationNumber().compareTo(o2.getRegistrationNumber());
        }
    }

    private static class VehicleComparatorByCity implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getOwnCity().compareTo(o2.getOwnCity());
        }
    }

}
