package Lab1;

public class test {
    public static void main(String[] args) {

        CPU cpu = new Intel("5755", 6, 1000);
        Memory memory = new Samsung("i-8913",6,650);
        HardDrive hardDrive = new WestDigitals("fastspeed-2.0", 1000, 1250);
        Motherboard motherboard = new Asus("Ultimate1",650,800);

        Computer one = new Computer(cpu,memory,hardDrive,motherboard);
        ComputerStore store = new ComputerStore(one,one,one);

        store.getComponents(1);
        store.getPrice(1);
        store.testWork(1);
    }
}
