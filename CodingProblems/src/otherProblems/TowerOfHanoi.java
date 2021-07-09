package otherProblems;

import java.util.ArrayList;
import java.util.Objects;

public class TowerOfHanoi {

    static void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod)
    {
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }

    public static void main(String[] args)
    {
        int n = 5;
        towerOfHanoi(n,'A','C', 'B');
    }

    public void tower(int numberOfRings){
        Peg a = new Peg(numberOfRings,PegName.A);
        Peg b = new Peg(0,PegName.B);
        Peg c = new Peg(0,PegName.C);
    }

    private void helper(int numberOfRings,Peg a,Peg b, Peg c){
        if(numberOfRings == 1){

        }
        while (!a.isEmpty() && c.size() < numberOfRings){
            move(a.peek(), a,c);
            move(a.peek(), a,b);
        }
    }

    private static void move(Ring ring,Peg from,Peg to) {
        from.removeRing(ring);
        to.addRing(ring);
    }


    private static class Peg{
        private final ArrayList<Ring> rings;
        private final PegName pegName;

        public Peg(int numOfRings,PegName pegName){
            rings = new ArrayList<>();
            this.pegName = pegName;
            for(int i=0;i<numOfRings;i++){
                rings.add(new Ring(i));
            }
        }

        public boolean isEmpty(){
            return rings.isEmpty();
        }
        public int size(){
            return rings.size();
        }
        public Ring peek(){
            return rings.get(0);
        }

        public void removeRing(Ring ring){
            rings.remove(ring);
            System.out.printf("removing ring %s from peg %s%n",ring.getId(),this.pegName);
        }
        public void addRing(Ring ring){
            rings.add(ring);
        }

        public PegName getPegName() {
            return pegName;
        }
    }

    private static class Ring{

        public PegName getPegName() {
            return pegName;
        }

        public void setPegName(PegName pegName) {
            this.pegName = pegName;
        }

        public int getId(){
            return this.id;
        }

        private PegName pegName;
        private final int id;
        public Ring(int i){
            pegName = PegName.A;
            this.id = i;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Ring)) return false;
            Ring ring = (Ring) o;
            return pegName == ring.pegName;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pegName);
        }
    }


    private enum PegName {
        A,B,C
    }
}
