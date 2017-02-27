package performance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static util.LogUtils.info;

public class CollectionsPerformance {

    public List<Integer> generateArrayList(int size, int randomization) {
        List<Integer> tokens = new ArrayList<>();
        long time = CollectionsHelper.countTimeMillis(() -> CollectionsHelper.generate(size, randomization, tokens));
        System.out.println(String.format("Generated %s nodes of ArrayList in time - %s ms", size, time));
        return tokens;
    }

    public List<Integer> generateLinkedList(int size, int randomization) {
        List<Integer> tokens = new LinkedList<>();
        long time = CollectionsHelper.countTimeMillis(() -> CollectionsHelper.generate(size, randomization, tokens));
        System.out.println(String.format("Generated %s nodes of LinkedList in time - %s ms", size, time));
        return tokens;
    }

    public void toArrayList(List<Integer> input) {
        long time = CollectionsHelper.countTimeMillis(() -> new ArrayList<>(input));
        System.out.println(String.format("Convert to ArrayList - %s ms", time));
    }

    public void toLinkedList(List<Integer> input) {
        long time = CollectionsHelper.countTimeMillis(() -> new LinkedList<>(input));
        System.out.println(String.format("Convert to LinkedList - %s ms", time));
    }

    public void sort(List<Integer> input) {
        long time = CollectionsHelper.countTimeMillis(() -> {
            Collections.sort(input);
            return input;
        });
        System.out.println(String.format("Sort of %s in time - %s ms", input.getClass().getName(), time));
    }

    public void addNode(Collection<Integer> input, Integer toAdd) {
        long time = CollectionsHelper.countTimeNanos(() -> input.add(toAdd));
        System.out.println(String.format("Add to %s in time - %s nanos (%s ms)",
                input.getClass().getName(), time, CollectionsHelper.nanosToMillis(time)));
    }

    public void deleteNode(Collection<Integer> input, Integer toDelete) {
        long time = CollectionsHelper.countTimeNanos(() -> input.remove(toDelete));
        System.out.println(String.format("Remove from %s in time - %s nanos (%s ms)",
                input.getClass().getName(), time, CollectionsHelper.nanosToMillis(time)));
    }

    public void getNode(List<Integer> input, Integer toGet) {
        long time = CollectionsHelper.countTimeNanos(() -> input.get(toGet));
        System.out.println(String.format("Get from %s in time - %s nanos (%s ms)",
                input.getClass().getName(), time, CollectionsHelper.nanosToMillis(time)));
    }
}
