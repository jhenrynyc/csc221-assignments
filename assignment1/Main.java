import java.util.Scanner;
public class Main {

    public static void Task1() {
        //assign values to a int, double, and string then print them

        int x = 3;
        double y = 7.5;
        String s = "First Print";
        System.out.println("Task 1: Variables and Types (10 points)");
        System.out.println("Number: "+x);
        System.out.println("Double: "+y);
        System.out.println("String: "+s);
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void Task2(){
        //use scanner to get input to question
        System.out.println("Task 2: Control Flow and Functions (15 points)");
        Scanner scanner = new Scanner((System.in));
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        //if input is greater than or equal 18 then choose response
        if (age >= 18){
            System.out.println("You are an adult");
        }
        else{
            System.out.println("You are a minor");
        }
        System.out.println("-------------------------------------------------------------------------------");

    }
    public static void Task3(){
        System.out.println("Task 3: Conditional Statements and Loops (20 points)");
        System.out.print("Loop from 1 to 20: ");
//begin at first even number and iterate by 2's
        for (int numEven=2;numEven<=20;numEven+=2){

            System.out.print(numEven+" ");
        }
        System.out.println();
//begin at first odd number and add all other odd numbers up until 50
        int totalSum = 0;
        for (int sumOdd =1;sumOdd <=50;sumOdd+=2){
            totalSum+=sumOdd;
        }
        System.out.println("Odd numbers sum from 1-50: "+totalSum);
        System.out.println("-------------------------------------------------------------------------------");
    }
    public static void calculateArea(double length, double width){
        System.out.println("Task 4: Defining and Calling Functions (15 points)");
        System.out.println("The length is: "+length);
        System.out.println("The width is: "+width);
        // area is length x width
        double area = length * width;
        System.out.println("The area is: "+area);
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void calculateFactorial(int n){
        int totalFactorial = 1;
        System.out.println("Task 5: Parameter Passing and Return Values (20 points)");
        //factorial is number - 1 multipled ie 5 x 4 x 3 x 2 x 1. Start at number then subtract 1 but not until 0
        for(int i = n; i>0;i--){
            totalFactorial *= i;
        }
        System.out.println("The factorial of "+n+" is: "+totalFactorial);
        System.out.println("-------------------------------------------------------------------------------");
    }
    public static void BonusTask(){
        //use scanner to get user inputs
        System.out.println("Bonus Task (10 points)");
        System.out.println("Pick your operation (+,-,*,/): ");
        Scanner scannerNew = new Scanner(System.in);
        char sign = scannerNew.next().charAt(0);
        System.out.println("Enter your first number: ");
        double num1 = scannerNew.nextDouble();
        System.out.println("Enter your second number: ");
        double num2 = scannerNew.nextDouble();
        // based on case do operation
        switch (sign){
            case '+':
                double resultAdd = num1+num2;
                System.out.println(num1 + " + " + num2 + " = "+ resultAdd);
                break;

            case '*':
                double resultMult = num1*num2;
                System.out.println(num1 + " * " + num2 + " = "+ resultMult);
                break;

            case '-':
                double resultSub = num1-num2;
                System.out.println(num1 + " - " + num2 + " = "+ resultSub);
                break;

            case '/':
                if (num2==0){
                    System.out.println("Division by 0 is undefined. Try again");
                    //division by 0 is invalid so rerun program and break
                    BonusTask();
                    break;
                }
                double resultDiv = num1/num2;
                System.out.println(num1 + " / " + num2 + " = "+ resultDiv);
                break;

        }

    }





    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();
        calculateArea(3.442,3.56);
        calculateArea(13,9.3);
        calculateFactorial(6);
        calculateFactorial(3);
        BonusTask();
    }


}

