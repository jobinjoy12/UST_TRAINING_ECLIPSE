import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Person{}
public class PersonSorter {Collections.sort(list)

    public static List<Person> sortPeople(List<Person> people) {
        // Requirement: Return a NEW list. Do not modify the input.
        // If input is null, return empty list.
        if (people == null) return new ArrayList<>();
        
        List<Person> sortedList = new ArrayList<>(people);
        // Collections.sort(sortedList);
        Collections.sort(sortedList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // Requirement 4: Handle null Person objects (put them at the end)
                if (p1 == null && p2 == null) return 0;
                if (p1 == null) return 1; // p1 is null, goes to end (after p2)
                if (p2 == null) return -1; // p2 is null, p1 goes before

                // Requirement 1: Sort by age (Ascending)
                int ageCompare = Integer.compare(p1.getAge(), p2.getAge());
                if (ageCompare != 0) {
                    return ageCompare;
                }

                // Requirement 2: Sort by name (Ascending, Case-insensitive)
                String n1 = p1.getName();
                String n2 = p2.getName();
                
                // Requirement 5 (Ascending): Nulls should sort BEFORE non-nulls
                if (n1 == null && n2 == null) {
                    // fall through to check city
                } else if (n1 == null) {
                    return -1; 
                } else if (n2 == null) {
                    return 1;
                } else {
                    int nameCompare = n1.compareToIgnoreCase(n2);
                    if (nameCompare != 0) return nameCompare;
                }

                // Requirement 3: Sort by city (Descending)
                String c1 = p1.getCity();
                String c2 = p2.getCity();

                // Requirement 5 (Descending): Nulls should sort AFTER non-nulls
                if (c1 == null && c2 == null) return 0;
                if (c1 == null) return 1; // Nulls go last
                if (c2 == null) return -1; 

                // Standard Descending sort logic (p2 compared to p1)
                return c2.compareTo(c1);
            }
        });

        return sortedList;
    }
}