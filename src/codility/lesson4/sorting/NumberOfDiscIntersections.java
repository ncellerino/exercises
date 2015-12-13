package codility.lesson4.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 93%
 * @author Jorge
 *
 */
public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        // int[] A = {1,5,2,1,4,0};
        int[] A = {1, 1, 1 };
        System.out.println(new NumberOfDiscIntersections().solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 2) {
            return 0;
        }

        List<Point> points = new LinkedList<Point>();
        for (int i = 0; i < A.length; i++) {
            points.add(new Point(i - A[i], true));
            points.add(new Point(i + A[i], false));
        }
        Collections.sort(points, new PointComparator());

        int intersections = 0;
        int openDiscs = 0;
        for (Point p : points) {
            if (p.leftPoint) {
                openDiscs++;
            } else {
                openDiscs--;
                intersections = intersections + openDiscs;
                if (intersections > 10000000) {
                    return -1;
                }
            }
        }
        return intersections;
    }

    private static class PointComparator implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            int compare = new Integer(o1.value).compareTo(o2.value);
            if (compare == 0) {
                if (o1.leftPoint && !o2.leftPoint) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return compare;
            }
        }

    }

    private static class Point {
        private int value;
        private boolean leftPoint;

        public Point(int value, boolean leftPoint) {
            this.value = value;
            this.leftPoint = leftPoint;

        }
    }
}
