package moodys;

import java.util.Scanner;

/*
* Anita and her friends, go on a trip. Now, they are back home and need to balance their expenses. During the trip, they perform many transactions
* but don't divide the expenses equally all the time. The total expenses should be balanced in such a way that everyone pays an equal amount.
* Given the information about the transactions, Anita needs to find who owes others and who should get money.
* Anita has an ID number of 1 and her friends are represented by IDs from 2 to m.
* There will be n transactions, each consisting of a person's ID and the amount of money that he/she paid. Note that, the required payment for all
* might be fractional. To avoid this situation, Anita has decided to pay some extra money (if needed) so that everybody has to pay a whole amount
* after that.
* For example, if an amount of 100 units is split across 3 people (Anita, Bret and Cathy) each has a share of 33.33 per person.
* To make the amount a whole number Anita decides to pay 1 extra unit, thus making her share to be 34. And for Bret and Cathy,
* the share becomes 33 each.
*/

public class Soln1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] paid = new int[m];
        int[] due = new int[m];
        int total = 0;

        for(int a0 = 0; a0 < n; a0++){
            int id = in.nextInt() - 1;
            int amount = in.nextInt();
            paid[id] += amount;
            total += amount;
        }
        in.close();

        double perHead = total/m;
        for(int id = 1; id < m; id++){
            due[id] = paid[id] - (int)perHead;
            total -= (int)perHead;
        }
        due[0] = paid[0] - total;

        for(int id = 0; id < m; id++){
            System.out.println((id + 1) + " " + due[id]);
        }
    }
}