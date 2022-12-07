package Sort;

import java.util.Comparator;

import mavenassignment.Tshirts;

public class SortByRating implements Comparator<Tshirts> {
    public int compare(Tshirts object1, Tshirts object2){
    	return object2.getRating().compareTo(object1.getRating());
    }
}
