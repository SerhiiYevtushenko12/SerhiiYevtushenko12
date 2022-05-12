package lesson4;

public class MainTest {
    public static void main(String[] args) {
        LocationData[] locationData = LocationData.values();
        for (int i = 0; i < locationData.length; i++) {
            System.out.println(locationData[i].toString() + " ip: " + locationData[i].getIp());

            LocationData location = LocationData.valueOf(LocationData.USA.toString());
//            LocationData location = LocationData.valueOf("USA");
            System.out.println("City: " + location.getCity() + " ip: " + location.getIp());
        }
    }
}

enum LocationData {
    GBR("London", "213.171.197.181"),
    USA("New York", "69.147.251.50");


    private final String city;

    private final String ip;

    LocationData(String city, String ip) {
        this.city = city;
        this.ip = ip;
    }

    public String getCity() {
        return this.city;
    }

    public String getIp() {
        return this.ip;
    }
}
