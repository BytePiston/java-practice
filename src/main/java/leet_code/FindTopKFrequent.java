package leet_code;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class FindTopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.merge(num, 1, Integer::sum);
        }
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(Integer key: map.keySet()){
            pq.offer(key);
        }

        int[] output = new int[k];
        for(int i=0; i<k; i++)
            output[i] = pq.poll();
        return output;
    }
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int num: nums){
            pq.offer(num);
        }
        int[] output = new int[k];
        for(int i=0; i<k; i++)
            output[i] = pq.poll();
        return output[k-1];
    }
}
