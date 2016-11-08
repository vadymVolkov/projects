public class AirconditionMain {
    public static void main(String[] args) {
        Aircondition aircondition1 = new Aircondition("Samsung", "white", "Japan", "SleepMode", "A", 30, 40, true);
        System.out.println(aircondition1.company);
        System.out.println(aircondition1.color);
        System.out.println(aircondition1.madeIn);
        System.out.println(aircondition1.feature);
        System.out.println(aircondition1.energyClass);
        System.out.println(aircondition1.roomSize);
        System.out.println(aircondition1.noizLevel);
        System.out.println(aircondition1.remoteControl);

    }
}
