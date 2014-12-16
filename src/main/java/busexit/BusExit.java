package busexit;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Anton
 * Date: 02/11/13
 * Time: 19:56
 */
public class BusExit {

    private static List<Person> personList;
    private static boolean busPerson[][] = new boolean[4][8];

    public static void main(String[] args) {
        initBus();
        System.out.println("Iterations count = " + getIterationsToExit());
    }

    private static void initBus() {
        personList = intiPersons();
        occupyPlaces();

        System.out.println("Bus is ready and occupied.");

    }

    private static int getIterationsToExit() {
        int iterationNumber = 0;

        while (!personList.isEmpty()) {

            List<Integer> personsToRemove = new ArrayList<Integer>();
            for (Person person : personList) {
                person.makeStepToExit(busPerson);
                if (person.isOutOfBus()) {
                    personsToRemove.add(person.getId());
                }

                showBusSeats();
//                return 0;
            }

            for (Integer i : personsToRemove) {
                personList.remove(new Person(i, 0, 0));
                System.out.println("Person #" + i + " exited the bus.");
            }

            iterationNumber++;

        }

        return iterationNumber;
    }

    private static void occupyPlaces() {
        showBusSeats();
        for (Person person : personList) {
            busPerson[person.getX()-1][person.getY()-1] = true;
        }

        showBusSeats();
    }

    private static void showBusSeats() {
        System.out.println("-----");
        for (int i=busPerson.length-1; i>=0; i--) {
            boolean line[] = busPerson[i];
            for (int j = 0; j < line.length; j++) {
                System.out.print(busPerson[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }

    private static List<Person> intiPersons() {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person(1, 1, 1));
        persons.add(new Person(2, 1, 2));
        persons.add(new Person(3, 4, 1));

        return persons;

    }

    private static class Person {
        int id;
        int x;
        int y;

        private Person(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        void makeStepToExit(final boolean seatPlan[][]) {
            System.out.print("ID #" + getId() + " on x=" + getX() + " y=" + getY());
            int nextX = x;
            int nextY = y;
            if (x == 1 || x == 2) {
                nextX = x + 1;
            }
            if (x == 4) {
                nextX = x - 1;
            }
            if (x == 3) {
                nextY = y - 1;
            }

            System.out.print("  = nextX=" +nextX+" , nextY=" +nextY+" =  ");

            if (!isNextStepOccupied(seatPlan, nextX, nextY)) {
                freeOldSeat(seatPlan, x, y);
                x = nextX;
                y = nextY;
                occupyNewSeat(seatPlan, x, y);

                System.out.print("moved to x=" + getX() + " y=" + getY());
            }
            System.out.println();

        }

        private void freeOldSeat(final boolean seatPlan[][], final int x, final int y) {
            if (x > 0 && y > 0) {
                seatPlan[x-1][y-1] = false;
            }
        }

        private void occupyNewSeat(final boolean seatPlan[][], final int x, final int y) {
            if (x > 0 && y > 0) {
                seatPlan[x-1][y-1] = true;
            }
        }

        private boolean isNextStepOccupied(final boolean seatPlan[][], final int x, final int y) {
            if (x > 0 && y > 0) {
                return seatPlan[x-1][y-1];
            }

            return false;
        }

        boolean isOutOfBus() {
            return  (x == 3 && y <1);
        }

        private int getX() {
            return x;
        }

        private void setX(int x) {
            this.x = x;
        }

        private int getY() {
            return y;
        }

        private void setY(int y) {
            this.y = y;
        }

        private int getId() {
            return id;
        }

        private void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (id != person.id) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
