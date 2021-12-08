package otherProblems;

public final class Fibonacci {
    private Fibonacci(){
    }

    public static int recursiveFibonacci(int nthNumber){
        if(nthNumber <= 1){
            return nthNumber;
        }

        return recursiveFibonacci(nthNumber-1) + recursiveFibonacci(nthNumber-2);
    }

    public static int iterativeFib(int nthNumber){

        int seed1 = 0;
        int seed2 =1;
        int total =0;
        if(nthNumber <2){
            return nthNumber;
        }
        for(int i=2;i<=nthNumber;i++){
            total = seed2 + seed1;
            seed1 = seed2;
            seed2 = total;
        }
        return total;
    }

    public static void main(String[] args){

        for(int i =0;i<4;i++){
            System.out.printf("i is %d%n",i);
            System.out.println(iterativeFib(i));
        }

        //System.out.println(recursiveFibonacci(0));
    }
}
