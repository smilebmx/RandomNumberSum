

import com.github.iarks.RandomOrgAPI.InvalidMethodCallException;
import com.github.iarks.RandomOrgAPI.InvalidResponseException;
import com.github.iarks.RandomOrgAPI.RandomNumber;

import java.util.concurrent.ThreadLocalRandom;

public class SumNumbers {


    public static void main(String args[]){
        int number1 = getNumber1();
        int number2 = getNumber2();
        int sum = sum(number1, number2);
    }


    public static int getNumber1() {
        int random1 = ThreadLocalRandom.current().nextInt(1, 100);
        System.out.println("First random number:" + random1);
        return random1;
    }

    public static int getNumber2(){
        int random2=0, bitsLeft, bitsUsed, requestsLeft;
        try
        {

            RandomNumber rn = new RandomNumber("ebfcbd86-f75a-463a-87ca-8cf64aa4c8e1");
            rn.generate(1, 100, 1, false,"method1");

            for (int i=0; i<1 ; i++)
            {
                random2 = rn.getElementAt(i);
                System.out.print("Second random number:" + random2);
            }
            System.out.println();

            // obtaining other metadata about the request
            bitsLeft=rn.getBitsLeft();
            bitsUsed=rn.getBitsUsed();
            requestsLeft=rn.getRequestsLeft();
            //System.out.println("Bits Used = " + bitsUsed);
            //System.out.println("Bits Left = " + bitsLeft);
            //System.out.println("Requests Left = " + requestsLeft);
        }
        catch (InvalidResponseException invalidResponseException)
        {
            System.out.println(invalidResponseException.getMessage());
            invalidResponseException.printStackTrace();
        }
        catch(InvalidMethodCallException invalidMethodCallException)
        {
            System.out.println(invalidMethodCallException.getMessage());
            invalidMethodCallException.printStackTrace();
        }
        return random2;
    }

    public static int sum(int number1, int number2) {
        int sum = number1 + number2;
        System.out.println("Sum random number:" + sum);
        return sum;
    }
}


