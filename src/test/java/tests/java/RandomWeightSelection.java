/**
 * Statement:
 * We have a set of N (1 ≤ N ≤ 100) different versions of advertising messages that we would like to randomly select and
 * send out to the public. Each version has a weight w[i] (0 ≤ w[i] ≤ 1.000.000.000) of being selected.
 *
 * Implement a function to take an array w[] as input and return a message version i (0 ≤ i ≤ N-1) that satisfies the
 * weighted random condition.
 *      func f(w []int) int { * }
 *
 * For example, there are N = 3 versions where w[0] = 50, w[1] = 30 and w[2] = 60 which give a total weight of 140.
 *   - Now suppose that each time we randomly select a version for 1400 messages. The function satisfies the weighted
 *   random condition when around 500 times the selected message is version 0, around 300 times the message is version
 *   1, and around 600 times the message is version 2.
 *   - If we run the function for only 280 times, it is expected that we will get version 0 about 100 times, version 1
 *   about 60 times, and version 2 about 120 times.
 *
 * Requirement:
 *   - Describe your strategy to solve the task and how you test your code to make sure it works as expected.
 *   - Implement the function in any programming language that you feel comfortable to work
 *   - Write tests to cover your code, make sure that the weighted random condition is satisfied and all edge cases are
 *   checked properly.
 *   - Your code should be production ready, well organised and well tested.
 *
 * Solution: https://medium.com/@peterkellyonline/weighted-random-selection-3ff222917eb6
 */
package tests.java;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Random;

class ad {
    int ad_id;
    int ad_weight;

    public ad(int ad_id, int ad_weight){
        this.ad_id = ad_id;
        this.ad_weight = ad_weight;
    }
}

public class RandomWeightSelection {
    @Test
    public void basicTest(){
        ad[][] testList = {
                {new ad(0,50), new ad(1,30), new ad(2,60)},
                {},
                {new ad(0,0)},
                {new ad(0,-10)},
                {new ad(0,1000000000)},
                {new ad(0,0),  new ad(1,0)},
                {new ad(0,-1), new ad(1,10)},
                {new ad(0,10), new ad(1,1000000000)},
                {new ad(0,2),  new ad(1,2),  new ad(2,2)},
        };
        int count = 1;
        for (ad[] a : testList){
            System.out.println("Test array " + count);
            HashMap<Integer, Integer> result = verify(a,1400);
            for (HashMap.Entry<Integer, Integer> entry : result.entrySet()) {
                System.out.println("ID " + entry.getKey() + " has seclected " + entry.getValue() + " times");
            }
            count += 1;
            System.out.println("-----------------");
        }
    }

    @Test
    public void largeArrayTest(){
        ad[] array100 = new ad[100];
        ad[] array101 = new ad[101];
        for (int a = 0; a < array100.length; a++) {
            array100[a] = new ad(a, a + 1);
            array101[a] = new ad(a, a + 1);
        }
        array101[100] = new ad(100, 101);

        System.out.println("Test array 100 elements");
        HashMap<Integer, Integer> result100 = verify(array100,1400);

        for (HashMap.Entry<Integer, Integer> entry : result100.entrySet()) {
            System.out.println("ID " + entry.getKey() + " has seclected " + entry.getValue() + " times");
        }

        System.out.println("-----------------");
        System.out.println("Test array 101 elements");
        HashMap<Integer, Integer> result101 = verify(array101,1400);
        for (HashMap.Entry<Integer, Integer> entry : result101.entrySet()) {
            System.out.println("ID " + entry.getKey() + " has seclected " + entry.getValue() + " times");
        }
    }

    public HashMap verify(ad[] ad_list, int NoOfMessage){
        HashMap<Integer, Integer> result = new HashMap<>();
        // Warn if array has no element
        if (ad_list.length > 0 && ad_list.length <= 100){
            int weightSum = 0;
            for (ad a : ad_list){
                // Check if any weight is less than zero
                if (a.ad_weight >= 0 && a.ad_weight <= 1000000000){
                    result.put(a.ad_id, 0);
                    weightSum += a.ad_weight;
                }
                else{
                    System.out.println("ID " + a.ad_id + "'s weight is out of range. Supported range: 0 to  1.000.000.000");
                    result = new HashMap<>();
                    return result;
                }
            }

            if(weightSum > 0){
                for(int i=0; i < NoOfMessage; i++){
                    // Pick a number at random between 1 and the sum of the weights
                    Random rand = new Random();
                    int randomVal = rand.nextInt(weightSum)+1;

                    for (ad a : ad_list){
                        randomVal -= a.ad_weight;
                        if (randomVal <= 0) {
                            int temp = result.get(a.ad_id);
                            result.put(a.ad_id,temp + 1);
                            break;
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Input array size is out of range. Supported range: 1 to 100");
        }
        return result;
    }
}
