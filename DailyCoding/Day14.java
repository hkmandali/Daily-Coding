package DailyCoding;

import java.util.Random;

/*
The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x2 + y2 = r2.
 */
public class Day14 {
    // lets suppose we have a circle of radius 1/2 and a square circumscribing it with a side of 1 , area of square =1
    // area of circle = pi /4 , so area of circle / area of square = 4*pi( no of points inside circle / no of points in square)
    // we'll choose our points in such a way that they are always less than 1,1 i.e we keep the limit as 1
    public static void main(String[] args)
    {
        Random rand = new Random();
        int num_inside_circle = 0;
        int num_inside_square = 0;
        for(int i=0;i<100000;++i)
        {
            float x = rand.nextFloat();
            float y = rand.nextFloat();
            // this means that the points are always inside the square

            // now we'll check for the circle
            if(x*x +y*y <= 1)
                num_inside_circle++; // area of circle
            num_inside_square++;// area of aquare
        }
        System.out.println(num_inside_circle+"   "+num_inside_square);
        System.out.println("the value of pi is "+4*((float)num_inside_circle/num_inside_square));
    }
}
