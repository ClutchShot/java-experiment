package Lab1;

public class ComputerStore {
    private Computer one, two, three;//Examples of computer in store

    ComputerStore(Computer one, Computer two, Computer three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    void getComponents(int numbofcomputer) { // print info about components of computer
        switch (numbofcomputer) {
            case (1): System.out.println("Cpu:");
                one.getCpu().getInfo() ;
                System.out.println("Memory:");
                one.getMemory().getInfo() ;
                System.out.println("Harddrive:");
                one.getHardDrive().getInfo() ;
                System.out.println("Motherboard:");
                one.getMotherboard().getInfo() ;
                break;
            case (2):
                System.out.println("Cpu:");
                two.getCpu().getInfo() ;
                System.out.println("Memory:");
                two.getMemory().getInfo() ;
                System.out.println("Harddrive:");
                two.getHardDrive().getInfo() ;
                System.out.println("Motherboard:");
                two.getMotherboard().getInfo() ;
                break;
            case (3):
                System.out.println("Cpu:");
                three.getCpu().getInfo() ;
                System.out.println("Memory:");
                three.getMemory().getInfo() ;
                System.out.println("Harddrive:");
                three.getHardDrive().getInfo() ;
                System.out.println("Motherboard:");
                three.getMotherboard().getInfo() ;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + numbofcomputer);
        }
    }

    void getPrice(int numbofcomputer) {
        int fullprice;
        switch (numbofcomputer) {
            case (1): fullprice = one.getCpu().price + one.getHardDrive().price + one.getMemory().price + one.getMotherboard().price;
            System.out.println("Price of computer numb one: " + fullprice);
                break;
            case (2):fullprice = two.getCpu().price + two.getHardDrive().price + two.getMemory().price + two.getMotherboard().price;
                System.out.println("Price of computer numb  two: " + fullprice);
                break;
            case (3): fullprice = three.getCpu().price + three.getHardDrive().price + three.getMemory().price + three.getMotherboard().price;
                System.out.println("Price of computer numb three: " + fullprice);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + numbofcomputer);
        }
    }

    void testWork(int numbofcomputer) {
        switch (numbofcomputer) {
            case (1):
                one.getCpu().work();
                one.getMemory().work();
                one.getHardDrive().work();
                one.getMotherboard().work();
                break;
            case (2):
                two.getCpu().work();
                two.getMemory().work();
                two.getHardDrive().work();
                two.getMotherboard().work();
                break;
            case (3):
                three.getCpu().work();
                three.getMemory().work();
                three.getHardDrive().work();
                three.getMotherboard().work();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + numbofcomputer);
        }
    }
}


class Intel extends CPU {
    Intel(String Name, int coreNum, int price){
        super(Name,coreNum, price);
    }
}

class AMD extends CPU {
    AMD(String Name, int coreNum, int price){
        super(Name,coreNum, price);
    }
}

class Samsung extends Memory {
    Samsung(String Name, int volume, int price){
        super(Name,volume, price);
    }
}

class Kingston extends Memory {
    Kingston(String Name, int volume, int price){
        super(Name,volume, price);
    }
}

class Seagate extends HardDrive {
    Seagate(String Name, int volume, int price){
        super(Name,volume, price);
    }
}

class WestDigitals extends HardDrive {
    WestDigitals(String Name, int volume, int price){
        super(Name,volume, price);
    }
}

class Asus extends Motherboard {
    Asus(String Name, int speed, int price){
        super(Name,speed, price);
    }
}

class Gigabyte extends Motherboard {
    Gigabyte(String Name, int speed, int price){
        super(Name,speed, price);
    }
}

