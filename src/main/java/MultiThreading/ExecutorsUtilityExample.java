package MultiThreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ExecutorsUtilityExample {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> futureObj = pool.submit(new ComputeSumTask(0, 100));
        try {
            System.out.println(futureObj.get());
        } catch (Exception e) {
            //Handle Exceptions here!!
        }
    }
}

class ComputeSumTask extends RecursiveTask<Integer> {
    int start;
    int end;

    public ComputeSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 4) {
            int totalSum = 0;
            for (int i = start; i <= end; i++) {
                totalSum += i;
            }
            return totalSum;
        } else {

            //Splitting the Task into 2 or more SubTasks
            int mid = start + (end - start) / 2;

            ComputeSumTask leftSubTask = new ComputeSumTask(start, mid - 1);
            ComputeSumTask rightSubTask = new ComputeSumTask(mid, end);

            //Forking the SubTasks for Parallel Execution;
            leftSubTask.fork();
            rightSubTask.fork();

            //Join the results from SubTasks
            int leftSum = leftSubTask.join();
            int rightSum = rightSubTask.join();

            return leftSum + rightSum;
        }
    }
}
