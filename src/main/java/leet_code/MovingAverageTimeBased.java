package leet_code;


import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageTimeBased {

    double windowSize;
    Queue<Integer> queue;
    Queue<Double> timeStamps;
    double sum;

    MovingAverageTimeBased(double windowSize){
        this.windowSize = windowSize;
        queue = new LinkedList<>();
        timeStamps = new LinkedList<>();
        this.sum = 0;
    }

//    public double next(double n, double timeStamp){
//        if(queue.size()>0 && timeStamps.size()>0){
//            sum -= queue.poll();
//            timeStamps.poll();
//        }
//        queue.offer(n);
//        timeStamps.offer(timeStamp);
//        sum += n;
//        return sum/queue.size();
//    }


    public double next(int val) {
        if (queue.size() == windowSize) {
            sum -= queue.remove(); // remove the oldest element from the sum
        }
        queue.add(val);
        sum += val;

        return sum / queue.size();
    }


    public static void main(String[] args) {
        MovingAverageTimeBased obj = new MovingAverageTimeBased(3);
        System.out.println(obj.next(30)); // User spends 30 minutes in the subway
        System.out.println(obj.next(10)); // Next trip is 10 minutes
        System.out.println(obj.next(20)); // Next trip is 20 minutes
        System.out.println(obj.next(25)); //
    }
}
