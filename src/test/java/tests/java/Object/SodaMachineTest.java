package tests.java.Object;

public class SodaMachineTest {
    public static void main(String[] args){
        SodaMachine sodaMachine1 = new SodaMachine("Soda Machine 1");
        sodaMachine1.showSodaMachineName();
        sodaMachine1.insertCoin(10);
        sodaMachine1.buySoda();
    }
}
