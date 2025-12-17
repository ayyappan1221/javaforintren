import java.util.Scanner;

public class TemperatureConverter{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter temperature value:");
        double temp=sc.nextDouble();

        System.out.println("Enter unit (C or F):");
        char unit=sc.next().charAt(0);

        if(unit=='C' || unit=='c'){
            double f=(temp*9/5)+32;
            System.out.println("Temperature in Fahrenheit: "+f);
        }
        else if(unit=='F' || unit=='f'){
            double c=(temp-32)*5/9;
            System.out.println("Temperature in Celsius: "+c);
        }
        else{
            System.out.println("Invalid unit! Enter C or F only.");
        }

        sc.close();
    }
}
