package Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskScheduler {

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));


        //WorkStealing Thread Pool Executor
        ExecutorService poolExecutor = Executors.newWorkStealingPool(4);
        poolExecutor.submit(() -> "this is the async task");


    }
    
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(char ch: tasks){
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Integer> taskPQ= new PriorityQueue<>(charMap.size(), (a, b) -> charMap.get(b) - charMap.get(a));
        for(Map.Entry<Character, Integer> entry: charMap.entrySet()){
            taskPQ.offer(entry.getValue());
        }
        
        System.out.println(taskPQ.poll());
        return 0;
    }
}
