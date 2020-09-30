package LeetCodeProblem.Else_Problem;

public class IsInside {
    public static void main(String[] args) {

    }

    public static double crossProduct(double x1, double y1, double x2, double y2){
        return x1*y2 - x2*y1;
    }

    public static boolean isInside(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x, double y){
        if (crossProduct(x3-x1, y3-y1, x2-x1, y2-y1) >= 0){
            double tempx = x2;
            double tempy = y2;
            x2 = x3;
            y2 = y3;
            x3 = tempx;
            y3 = tempy;
        }

        if (crossProduct(x2-x1, y2-y2, x-x1, y-y1) < 0){
            return false;
        }

        if (crossProduct(x3-x2, y3-y2, x-x2, y-y2) < 0){
            return false;
        }

        if (crossProduct(x1-x3, y1-y3, x-x3, y-y3) < 0){
            return false;
        }
        return true;
    }
}
