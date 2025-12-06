import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class CustomPartitioningCollector2<T> implements Collector<T, Map<Boolean, List<T>>, Map<Boolean, List<T>>> {

    private final Predicate<? super T> predicate;
    private final Supplier<List<T>> listSupplier;

    public CustomPartitioningCollector2(Predicate<? super T> predicate, Supplier<List<T>> listSupplier) {
        this.predicate = predicate;
        this.listSupplier = listSupplier;
    }

    @Override
    public Supplier<Map<Boolean, List<T>>> supplier() {
        return () -> {
            Map<Boolean, List<T>> map = new HashMap<>();
            map.put(true, listSupplier.get());
            map.put(false, listSupplier.get());
            return map;
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<T>>, T> accumulator() {
        return (map, element) -> {
            boolean key = predicate.test(element);
            List<T> selectedList = map.get(key);
            selectedList.add(element);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<T>>> combiner() {
        return (map1, map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<T>>, Map<Boolean, List<T>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public static <T> CustomPartitioningCollector2<T> customPartitioningBy(Predicate<? super T> predicate, Supplier<List<T>> listSupplier) {
        return new CustomPartitioningCollector2<>(predicate, listSupplier);
    }

    
}
