package Test;

import java.util.ArrayList;

public class loops {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        //fruits = ["Apple", "Banana", "Orange"] /3

        //index 0
        //length, size, 1

        for(int i = 0; i < fruits.size(); i += 1){
            System.out.println("The fruit at position " + i + 1 + " is " + fruits.get(i));
        }

    }

}
