package leetCode.helperClasses;

import java.util.Arrays;

public final class Utility {
    private Utility(){
    }
    public static void print(Object o){
        if(o.getClass().isArray()){
            o = Arrays.toString((int[]) o);
        }
        System.out.println(o);
    }
}
