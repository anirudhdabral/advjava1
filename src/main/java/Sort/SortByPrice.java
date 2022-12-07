package Sort;

import java.util.Comparator;

import mavenassignment.Tshirts;

public class SortByPrice implements Comparator<Tshirts> {
    public int compare(Tshirts object1, Tshirts object2){
    	return object2.getPrice().compareTo(object1.getPrice());
    }
}
