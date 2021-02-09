import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreamExample1 {

        public void executeElements () {
            //Created a standard list
            List<String> list = new ArrayList<String>();
            //add three elements to it - 3 strings
            list.add("Element 1");
            list.add("Element 2");
            list.add("Element 3");

            //From the list obtain a Stream object
            Stream<String> stream = list.stream();

        /*This stream - there is a forEach Method will start the iteration of the elements in the list and for each element it will execute the 'Java Lambda Expression
        below
         */
            //Call a terminal operation on the Stream
            stream.forEach((String element) -> {
                //Prints out the value of each element
                System.out.println(element);
            });

        }
}
//The Java Streams API was designed to take advantage of Java Lambda Expression which were also add in Java8
/*
***Java Stream Usage***:
1. Obtain a Stream
2. Call zero or more non-terminal operations on Stream
3. Call a terminal operation on the Stream
 */
