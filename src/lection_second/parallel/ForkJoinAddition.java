package lection_second.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Oleg on 11.12.2016.
 */
public class ForkJoinAddition extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    private static final long THRESHOLD = 10_000;

    public ForkJoinAddition(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD){
            computeSequentially();
        } else {
            ForkJoinAddition leftTask = new ForkJoinAddition(numbers, start, start + length / 2);
            leftTask.fork();

            ForkJoinAddition rightTask = new ForkJoinAddition(numbers, start + length / 2, end);
            long rightResult = rightTask.compute();
            long leftResult = leftTask.join();
            return rightResult + leftResult;
        }
        return null;
    }

    private long computeSequentially() {
        long result = 0L;
        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }

}
