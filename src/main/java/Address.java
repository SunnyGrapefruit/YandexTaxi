public class Address {

    public String addressFrom;
    public String addressTo;
    public String phoneNumber;

    public static Address createValidAddress() {
        Address address = new Address();
        address.addressFrom = "проспект Ленина, 30";
        address.addressTo = "улица Розы Люксембург, 77";
        address.phoneNumber = "+79013462894";
        return address;
    }

}