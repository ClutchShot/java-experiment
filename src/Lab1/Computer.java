package Lab1;

public class Computer implements Work {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private Motherboard motherboard;

    public Computer(CPU cpu, Memory memory, HardDrive hardDrive, Motherboard motherboard ){
        this.cpu=cpu;
        this.memory=memory;
        this.hardDrive=hardDrive;
        this.motherboard=motherboard;
    }

    @Override
    public void work() {
        cpu.work();
        memory.work();
        hardDrive.work();
        motherboard.work();
    }

    public CPU getCpu() {
        return cpu;
    }
    public Memory getMemory() {
        return memory;
    }
    public HardDrive getHardDrive() {
        return hardDrive;
    }
    public Motherboard getMotherboard() {
        return motherboard;
    }

}


interface Work{
    void work();
}

interface Info{
    void getInfo();
}

abstract class CPU implements Work, Info {
    String Name;
    int coreNum,price;

    CPU(String Name, int coreNum, int price){
        this.Name=Name;
        this.coreNum=coreNum;
        this.price=price;
    }

    @Override
    public void work(){
        System.out.println(Name + " work");
    };

    @Override
    public void getInfo() {
        System.out.println("Name: " + Name + "," + " number of core: " +  coreNum + "," + " price: "+ price  );
    }
}

abstract class Memory implements Work, Info {
    String Name;
    int volume, price;

    Memory(String Name, int volume, int price){
        this.Name=Name;
        this.volume=volume;
        this.price=price;
    }

    @Override
    public  void work(){
        System.out.println(Name + " work");
    }

    @Override
    public void getInfo() {
        System.out.println("Name: " + Name + "," + " volune: " + volume + "," + " price: "+ price  );
    }
}

abstract class HardDrive implements Work, Info {
    String Name;
    int volume, price;

    HardDrive(String Name, int volume, int price){
        this.Name=Name;
        this.volume=volume;
        this.price=price;
    }

    @Override
    public  void work(){
        System.out.println(Name + " work");
    }

    @Override
    public void getInfo() {
        System.out.println("Name: " + Name + "," + " volune: " + volume + "," + " price: "+ price  );
    }
}

abstract class Motherboard implements Work, Info {
    String Name;
    int speed, price;

    Motherboard(String Name, int speed, int price){
        this.Name=Name;
        this.speed=speed;
        this.price=price;
    }

    @Override
    public  void work(){
        System.out.println(Name + " work");
    }

    @Override
    public void getInfo() {
        System.out.println("Name: " + Name + "," + " speed: " + speed + "," + " price: "+ price  );
    }
}