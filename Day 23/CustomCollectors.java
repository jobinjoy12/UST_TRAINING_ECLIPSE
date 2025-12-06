import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

public class CustomCollectors {
	public static <T, K, V> Collector<T, ?, Map<K, List<V>>> toListMap(
			Function<? super T, ? extends K> keyMapper,
			Function<? super T, ? extends V> valueMapper) {
		// Your code here
        return Collector.of(
            HashMap::new,

            (map,element)->{
                K key = keyMapper.apply(element);
                V value = valueMapper.apply(element);
                map.computeIfAbsent(key,k->new ArrayList<>()).add(value);
            },

            (map1,map2)->{
                map2.forEach((key,list)->
                map1.computeIfAbsent(key,k->new ArrayList<>()).addAll(list)
            );
            return map1;
            }


        );

        
	}
}