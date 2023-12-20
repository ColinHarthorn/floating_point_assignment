package base;
// Import statement to handle IOException when writing a file
import java.io.IOException;
// Import statements to allow Java to access and modify files
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Program to add the values 1/2 and 1/3 a very large number of times using floating point numbers and doubles.
 * This program will add the floating points and double values
 * repeatedly in multiples of 10 starting with 1,000 and ending with 1,000,000,000
 *
 * The program will then multiply the original values by the number of times added and calculate the difference.
 * These values will be printed to screen and saved to AssignmentTwoOutputColinH.txt
 *
 *
 * Colin Harthorn, Assignment 2, CISC340
 */
public class Main {

    public static void main(String[] args) {
        // Declare variables and assign value of 1/2 and 1/3 for both double and floating point types
        double dHalf = 0.5;
        double dThird = 1.0/3;
        // Cast values to float
        float fHalf = (float)0.5;
        float fThird = (float)1.0/3;
        // Declare variables for the value of the sums
        float fHalfSums;
        float fThirdSums;
        double dHalfSums;
        double dThirdSums;
        // Declare variables for the value of the products
        float fHalfProduct;
        float fThirdProduct;
        double dHalfProduct;
        double dThirdProduct;
        // Declare output string. Used to save all generated info from loops as one string to easily save as a txt file.
        String output = "Colin Harthorn, Assignment 2, CISC340\n";

        //Outer loop to get the values we want to use to see the difference between floating point addition and multiplication
        for (int i = 1000; i <= 1000000000; i=i*10) {
            //set value of sums variables to 0 at beginning of outer loop
            fHalfSums  = 0;
            fThirdSums = 0;
            //Inner loop to add the floating point values to each other the number of times determined by the outer loop
            for (int j = 1; j <= i; j++) {
                fHalfSums  = fHalfSums  + fHalf;
                fThirdSums = fThirdSums + fThird;
            }
            // The values 1/2 and 1/3 will be multiplied by i at the values we are interested in comparing
            if (i == 1000 || i == 10000 || i == 100000 || i == 1000000 || i == 10000000 ||i == 100000000 || i == 1000000000) {
                // the floating point values are multiplied by i
                fHalfProduct  = fHalf * i;
                fThirdProduct = fThird * i;
                // Relevant information is saved as strings ending with new line characters for a formatted output file
                String fpHalfSumMessage = "The sums of "+i+" floating point numbers with the value of (1/2) is:"+fHalfSums+"\n";
                String fpThirdSumMessage = "The sums of "+i+" floating point numbers with the value of (1/3) is:"+fThirdSums+"\n";
                String fpHalfProductMessage = "The product of floating point number (1/2) * "+i+" is:"+fHalfProduct+"\n";
                String fpThirdProductMessage = "The product of floating point number (1/3) * "+i+" is:"+fThirdProduct+"\n";
                String fpHalfDifferenceMessage = "The difference between the floating point halves is:"+(fHalfSums-fHalfProduct)+"\n";
                String fpThirdDifferenceMessage = "The difference between the floating point thirds is:"+(fThirdSums-fThirdProduct)+"\n\n";
                String expectedValue = "A integer value for the halves for this operation is:"+(i/2)+"\n"+"A integer value for the thirds for this operation is:"+(i/3)+"\n------------------------------------------\n";
                // The information in the strings above is added together to make one string containing all information from one outer loop
                String print  = fpHalfSumMessage+fpThirdSumMessage+fpHalfProductMessage+fpThirdProductMessage+fpHalfDifferenceMessage+fpThirdDifferenceMessage+expectedValue;
                // The information from this outer loop is appended to the end of the output string
                output = output+print;
                // The information is printed to screen in IDE
                System.out.print(print);
        }
    }
        // Second set of Outer and Inner loops that perform the same actions as the loops above with double values instead of floating point values
        for (int i = 1000; i <= 1000000000; i=i*10) {
            dHalfSums  = 0;
            dThirdSums = 0;
            for (int j = 1; j <= i; j++) {
                dHalfSums  = dHalfSums  + dHalf;
                dThirdSums = dThirdSums + dThird;
            }
            if (i == 1000 || i == 10000 || i == 100000 || i == 1000000 || i == 10000000 ||i == 100000000 || i == 1000000000) {
                dHalfProduct  = dHalf * i;
                 dThirdProduct = dThird * i;

                String dHalfSumMessage = "The sums of "+i+" double numbers with the value of (1/2) is:"+dHalfSums+"\n";
                String dThirdSumMessage = "The sums of "+i+" double numbers with the value of (1/3) is:"+dThirdSums+"\n";
                String dHalfProductMessage = "The product of double number (1/2) * "+i+" is:"+dHalfProduct+"\n";
                String dThirdProductMessage = "The product of double number (1/3) * "+i+" is:"+dThirdProduct+"\n";
                String dHalfDifferenceMessage = "The difference between the double halves is:"+(dHalfSums-dHalfProduct)+"\n";
                String dThirdDifferenceMessage = "The difference between the double thirds is:"+(dThirdSums-dThirdProduct)+"\n\n";
                String expectedValue = "A integer value for the halves for this operation is:"+(i/2)+"\n"+"A integer value for the thirds for this operation is:"+(i/3)+"\n------------------------------------------\n";

                String print = dHalfSumMessage+dThirdSumMessage+dHalfProductMessage+dThirdProductMessage+dHalfDifferenceMessage+dThirdDifferenceMessage+expectedValue;
                output = output+print;
                System.out.print(print);
            }
        }
        //try writing output string to AssignmentTwoOutputColinH.txt
        try {
            Files.writeString(Paths.get("AssignmentTwoOutputColinH.txt"), output);
        //catch IOException
        } catch (IOException e) {
            System.out.println("Problem writing file");
        }
    }
}
