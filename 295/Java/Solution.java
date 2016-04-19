import java.util.*;

class MedianFinder {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int count1;
    int count2;

    public MedianFinder() {
        //desc order priority queue
        this.queue1 = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //asc order priority queue
        this.queue2 = new PriorityQueue<>();
        this.count1 = 0;
        this.count2 = 0;
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        count1++;
        if(count1 / 2 + 1 > count2){
            count2++;
            if(queue2.isEmpty() || num <= queue2.element())  queue1.add(num);
            else{
                queue1.add(queue2.poll());
                queue2.add(num);
            }
        }
        else{
            if(num >= queue1.element())  queue2.add(num);
            else{
                queue2.add(queue1.poll());
                queue1.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(count1 % 2 != 0) return queue1.element();
        else{
            double re;
            int temp1 = queue1.poll();
            int temp2 = queue1.element();
            queue1.add(temp1);
            re = (double) (temp1 + temp2) / 2;
            return re;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
