import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TestingPredicates {


    public ExampleObject getObject(String id){
        return null;
        //   return getObject(id, ExampleObject::isFieldOne);
    }

    private ExampleObject getObject(String id, Object isFieldOne) {
        return null;
    }

//    private ExampleObject getObjects(String id, Predicate<ExampleObject> p){
//        return Stream.of(new ExampleObject(true,true,"id")).filter(p).collect(Collectors.toList())
//    }


    private static class ExampleObject{
        private final boolean fieldOne;
        private final boolean fieldTwo;
        private final String id;

        private ExampleObject(boolean fieldOne, boolean fieldTwo, String id) {
            this.fieldOne = fieldOne;
            this.fieldTwo = fieldTwo;
            this.id = id;
        }

        public boolean isFieldOne() {
            return fieldOne;
        }

        public boolean isFieldTwo() {
            return fieldTwo;
        }

        public String getId() {
            return id;
        }
    }
}
