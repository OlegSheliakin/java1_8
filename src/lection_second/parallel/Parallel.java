package lection_second.parallel;

import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by Oleg on 11.12.2016.
 */
public class Parallel {

    public static void main(String[] args) {
        System.out.println("IterativeSum: " + measure(Parallel::iterativeSum, 10_000_000) + "msecs");
        System.out.println("SequentialStream: " + measure(Parallel::sequentialSum, 10_000_000) + "msecs");
        System.out.println("ParallelStream: " + measure(Parallel::parallelSum, 10_000_000) + "msecs");
        //System.out.println("ParallelStream: " + measure(Parallel::sideEffectSum, 20) + "msecs");

    }

    private static Long measure(Function<Long, Long> adder, long n) {
        long fastest = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long result = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Sum: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }


    private static Long parallelSum(Long limit) {
        return Stream.iterate(0L, operand -> operand + 1)
                .limit(limit)
                .parallel()
                .reduce(0L, Long::sum);
    }

    private static Long sequentialSum(Long limit) {
        return Stream.iterate(0L, operand -> operand + 1)
                .limit(limit)
                .sequential()
                .reduce(0L, Long::sum);
    }

    private static Long iterativeSum(Long limit) {
        long result = 0L;
        for (long i = 1L; i < limit; i++) {
            result += i;
        }
        return result;
    }

    private static Long sideEffectSum(Long limit) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(0L, limit).parallel().forEach(accumulator::add);
        return accumulator.getTotal();
    }
}



class Accumulator {
    private long total;

    public void add(long value) {
        total += value;
    }

    public long getTotal() {
        return total;
    }
}
