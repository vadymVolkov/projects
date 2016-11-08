public class Aircondition {
    String company;
    String color;
    String madeIn;
    String feature;
    String energyClass;
    int roomSize;
    int noizLevel;
    boolean remoteControl;

    public Aircondition(String company, String color, String madeIn, String feature, String energyClass, int roomSize, int noizLevel, boolean remoteControl) {
        this.company = company;
        this.color = color;
        this.madeIn = madeIn;
        this.feature = feature;
        if (energyClass.equals("A") || energyClass.equals("B")  || energyClass.equals("C") ) {
            this.energyClass = energyClass;
        }
        else {
            System.out.println("Wrong energy class");
        }
        if (roomSize>10 && roomSize<100) {
            this.roomSize = roomSize;
        }
        else {
            System.out.println("Wrong room size");
        }
        if (noizLevel>0 && noizLevel<50) {
            this.noizLevel = noizLevel;
        }
        else {
            System.out.println("Wrong noiz level");
        }
        this.remoteControl = remoteControl;
    }
}
