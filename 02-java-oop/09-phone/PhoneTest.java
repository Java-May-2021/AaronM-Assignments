class PhoneTest{
    public static void main(String[] args){
        Galaxy s9 = new Galaxy("S9", 99, "Verizon","Ring Ring Ring!");
        IPhone iphoneTen = new IPhone("X", 100, "AT&T", "Zing");
        iphoneTen.displayInfo();
        iphoneTen.unlock();
        iphoneTen.ring();
        s9.displayInfo();
        s9.unlock();
        s9.ring();
    }
}