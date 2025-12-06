import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CustomCollectors {
	public static <T, K, V> Collector<T, ?, Map<K, List<V>>> toListMap(
			Function<? super T, ? extends K> keyMapper,
			Function<? super T, ? extends V> valueMapper) {
		// Your code here
         
        return Collector.of(
            ConcurrentHashMap::new,

            (map,element)->
            {
                K key = keyMapper.apply(element);
                V value = valueMapper.apply(element);
                map.computeIfAbsent(key,k-> new ArrayList<>()).add(value);
            },

            (map1,map2)->
            {
                map2.forEach((key,list)->
                map1.computeIfAbsent(key, k-> new ArrayList<>()).addAll(list));
                return map1;

            },

            (map)->
            {
                return map;
            }
                
	);}
}