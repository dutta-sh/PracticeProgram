package misc;

import java.util.*;

public class Sample1 {

    public static void main(String[] args) {
        List<List<Integer>> prices = new ArrayList<>();
        List<Integer> stock = new ArrayList<>();
        stock.add(10);
        stock.add(150);
        stock.add(100);
        prices.add(stock);

        worstPerformingStock(prices);

    }


    // Complete the worstPerformingStock function below.
    static int worstPerformingStock(List<List<Integer>> prices) {
        //store minimum ratio here. Hence initialize with max value to start
        double ratio = Double.MAX_VALUE;
        //store corresponding stock id here
        int stockId = 0;

        //iterate thru the stocks
        for(List<Integer> stock : prices) {
            int closingPrice = stock.get(2);
            int openingPrice = stock.get(1);

            //compute performance and store to ratio, and update corresponding stock id
            //if its less than current ratio
            double perf = (double)(closingPrice - openingPrice)/(double)openingPrice;
            if(perf < ratio) {
                ratio = perf;
                stockId = stock.get(0);
            }
        }
        return stockId;
    }

    // Complete the allocateSchools function below.
    static List<Integer> allocateSchools(List<Integer> schoolSeatsArray, List<Integer> studentScoreArray, List<List<Integer>> studentSchoolPreferencesArray) {
        Map<Integer, List<Integer>> scoreToSchoolMap = new TreeMap<>(Collections.reverseOrder());
        int seatsNotFilled = 0;
        int studentsNotAssigned = 0;

        //store student score and corresponding school pref in a treemap in descending order
        //so that the values are sorted by score
        for(int i = 0; i < studentScoreArray.size(); i++) {
            scoreToSchoolMap.put(studentScoreArray.get(i), studentSchoolPreferencesArray.get(i));
        }

        //iterate thru the map values. since its a treemap in descending order, the list of
        //schools are sorted by high -> low score
        for(List<Integer> prefsDescending : scoreToSchoolMap.values()) {
            boolean isSchoolAssigned = false;

            //check if the preferred school has seats, if so
            //decrement seats and break, else try next school
            for(Integer schoolId : prefsDescending) {
                int seats = schoolSeatsArray.get(schoolId);
                if(seats > 0) {
                    seats--;
                    schoolSeatsArray.set(schoolId, seats);
                    isSchoolAssigned = true;
                    break;
                }
            }

            //if no school has seats, increment unassigned count
            if(!isSchoolAssigned) {
                studentsNotAssigned++;
            }
        }

        //check which school still has unfilled seats and add to unfilled count
        for(Integer openSeat : schoolSeatsArray) {
            if(openSeat > 0)
                seatsNotFilled += openSeat;
        }

        //return list
        List<Integer> returnList = new ArrayList();
        returnList.add(seatsNotFilled);
        returnList.add(studentsNotAssigned);

        return returnList;
    }
}
