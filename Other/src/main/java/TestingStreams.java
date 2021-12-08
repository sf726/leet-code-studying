
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class TestingStreams {

    public static void main(String[] args){
        testLazyStreams();
    }

    /**
     * This code will actually return 0
     * due to streams lazy behavior
     */
    private static void testLazyStreams(){
        int[] multi = new int[]{2};
        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = ints.stream().map(e-> e * multi[0]);
        multi[0] = 0;
        stream.forEach(System.out::println);
    }
}
