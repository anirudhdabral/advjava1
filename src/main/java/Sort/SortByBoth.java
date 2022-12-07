package Sort;

import java.util.Comparator;

import mavenassignment.Tshirts;

public class SortByBoth implements Comparator<Tshirts> {
    public int compare(Tshirts object1, Tshirts object2) {
		if (object1.getRating().equals(object2.getRating())) {
			return object2.getPrice().compareTo(object1.getPrice());
		}
		return 0;
	}
}
