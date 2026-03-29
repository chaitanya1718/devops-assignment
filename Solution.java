import java.util.*;

class TravelAgencies {
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;

    // Constructor
    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    // Getters and Setters
    public int getRegNo() {
        return regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getPackageType() {
        return packageType;
    }

    public int getPrice() {
        return price;
    }

    public boolean isFlightFacility() {
        return flightFacility;
    }
}

public class Solution {

    // Method 1
    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr) {
        int max = Integer.MIN_VALUE;

        for (TravelAgencies agency : arr) {
            if (agency.getPrice() > max) {
                max = agency.getPrice();
            }
        }
        return max;
    }

    // Method 2
    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] arr, int regNo, String packageType) {
        for (TravelAgencies agency : arr) {
            if (agency.getRegNo() == regNo &&
                agency.getPackageType().equalsIgnoreCase(packageType) &&
                agency.isFlightFacility()) {

                return agency;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        TravelAgencies[] arr = new TravelAgencies[n];

        for (int i = 0; i < n; i++) {
            int regNo = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String type = sc.nextLine();
            int price = sc.nextInt();
            boolean flight = sc.nextBoolean();
            sc.nextLine();

            arr[i] = new TravelAgencies(regNo, name, type, price, flight);
        }

        int searchRegNo = sc.nextInt();
        sc.nextLine();
        String searchType = sc.nextLine();

        // Call method 1
        int maxPrice = findAgencyWithHighestPackagePrice(arr);
        System.out.println(maxPrice);

        // Call method 2
        TravelAgencies result = agencyDetailsForGivenIdAndType(arr, searchRegNo, searchType);

        if (result != null) {
            System.out.println(result.getAgencyName() + ":" + result.getPrice());
        }
    }
}