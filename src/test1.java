import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {

    //Count the number of Names String with alphabet 'A' in List
//    @Test
    public void regular()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Aisha");
        names.add("Max");
        names.add("Mpilz");
        names.add("Alisha");
        names.add("Adam");

        int count = 0;

        //Iterate the 'for loop' to get the count of number of names
        for(int i = 0; i < names.size(); i++)
        {
            String actual = names.get(i);
            //Check if actual name starts with letter 'A'
            if(actual.startsWith("A"))
            {
                //Increment count
                count++;
            }
        }
        //Print the count variable and you will see the output
        System.out.println(count);
    }
    //    @Test
    public void streamFilter()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Aisha");
        names.add("Max");
        names.add("Mpilz");
        names.add("Alisha");
        names.add("Adam");
        /*
        Topics Learnt:
        1. There is no life intermediate operation if there is no Terminal operation
        2. Terminal operation will execute only if intermediate operation (Filter)returns true
        3. We can Create Stream
        4. How to use Filter in stream API
         */

        //Streams is a list of strings
        long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

        //Create Stream light weight compatible collection
        long d = Stream.of("Aisha", "Max", "Mpilz", "Alisha", "Adam").filter(s->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        //print all the names of ArrayList using Lambda Expression
//        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        //Important is forEach helps scan through the whole array and i could print on one sing shot
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }
    @Test
    public void streamMap()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Coco");
        names.add("Ash");
        names.add("Coral");

        //method called Map -> manipulate sting to the way you would like to change it

        //printing names which have last letter "a" with upperCase (Map -> to modify stream filer result
        Stream.of("Aisha", "Max", "Mpilz", "Alisha", "Adam", "Rovana").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        //Print names which have first letter as a with uppercase and sorted
        List <String> names1 = Arrays.asList("Aisha", "Max", "Mpilz", "Alisha", "Adam", "Rovana");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        //Merging two different Lists
        Stream <String> newStream = Stream.concat(names.stream(), names1.stream());
//        newStream.sorted().forEach(s -> System.out.println(s));
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);
    }
    @Test
    public void streamCollect()
    {
        List<String> ls = Stream.of("Aisha", "Max", "Mpilz", "Alisha", "Adam", "Rovana").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());//Collect the results
        System.out.println(ls.get(0));

        List<Integer> value = Arrays.asList(3,2,4,4,4,5,6,8,9,1);
        //print unique number from the list
        //Sort the Array
        value.stream().distinct().forEach(s -> System.out.println(s));

        List<Integer> li = value.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }
}
