import java.util.Scanner;

class Solution {
    public boolean isBoomerang(int[][] points) {
    int x1 = points[0][0], y1 = points[0][1];
    int x2 = points[1][0], y2 = points[1][1];
    int x3 = points[2][0], y3 = points[2][1];

    //I wanna find gradient using formula (dy1/dx1)
    int dx1 = x2-x1;
    int dy1 = y2-y1;
    int dx2 = x3-x2;
    int dy2 = y3-y2;

    //I wanna compare gradient, if not same then it is boomerang (not straight line)
    return (dy1*dx2) != (dy2*dx1);
    }
}
