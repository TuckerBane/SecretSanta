import java.util.*;
import java.io.*;
//import java.lang.String;

public class JavaProgram {
    public static void main(String args[]) {
        List<String> inputNames = new Vector<String>();
        Scanner in = new Scanner(System.in);
        String newName = new String();
		System.out.println("Enter names, or quit to move on");
        do
        {
            newName = in.next();
			inputNames.add(newName);
        }while( !newName.equals("quit") );
		inputNames.remove(inputNames.indexOf("quit"));
		Collections.shuffle(inputNames);
        int x=10;
        int y=25;
        int z=x+y;
		System.out.println(inputNames);
        System.out.println("Sum of x+y = " + z);
		newName = in.next();
    }
}