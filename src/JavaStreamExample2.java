import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class JavaStreamExample2 {

    public void nonTerminalOps() {

        //Created a standard list
        List<String> list = new ArrayList<String>();
        //add three elements to it - 3 strings
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        //From the list obtain a Stream object
        Stream<String> stream = list.stream();

        /*non-terminal operations only transform each element in the stream and the ooutput of calling a non-terminal operation on the stream is a new stream and
        this new stream contains the transformed element from the first stream
         */
        Stream<String> lowercaseStream = stream.map((String element) -> {

            return element.toLowerCase();
        });

        /*This stream - there is a forEach Method will start the iteration of the elements in the list and for each element it will execute the 'Java Lambda Expression
        below
         */
        //Call a terminal operation on the Stream
        /*
        Terminal operation: Starts the internal operation, and does not return a new stream instead in can return a void or can return whatever the result is of
        executing this the whole stream chain on all elements in the stream
         */
        lowercaseStream.forEach((String element) -> {
            //Prints out the value of each element
            System.out.println(element);
        });
    }
}
