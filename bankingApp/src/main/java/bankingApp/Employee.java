package bankingApp;
import java.util.*;

public class Employee {
	public ArrayList<Application> denyApplication(ArrayList<Application> array, int n) {
        if(n==0) {
            System.out.println("No more applications to deny.");
            return array;
        } else if(n<0) {
            System.out.println("Invalid input, please try again.");
            //denyApplication();
        } else {
            array.remove(n-1);
        }
        return array;
    }
}
