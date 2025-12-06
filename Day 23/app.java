import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class app {
	public static <T> Optional<T> findMax(List<? extends T> elements, Comparator<? super T> comparator) {
		if(elements==null||elements.isEmpty())
		{
			return Optional.empty();
		}
		T max = elements.get(0);
		if(max == null)
		{
			return Optional.empty();
		}
		else
		{
			for(T element : elements)
			{
				if(comparator.compare(element, max)==1){
                    max = element;
                }
			}
			return Optional.ofNullable(max);
		}
	}
}