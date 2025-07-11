import java.util.*;

public class temperatureConverter {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter the Temprature Value : ");
        float temp=sc.nextFloat();
        System.out.println("Enter the Unit of Temprature :\n1. Celsius\n2. Fahrenheit\nEnter 1 or 2 -");
        int n=sc.nextInt();
        switch (n){
            case 1: float fa=(temp*9/5)+32;
                System.out.print(temp+" Celsius = "+fa+" Faherenheit.");
                break;
            case 2: float c=(temp-32)*5/9;
                System.out.print(temp+" Faherenheit = "+c+" Celsius.");
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}
