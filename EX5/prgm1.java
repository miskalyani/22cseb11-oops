package converter;

public class DistanceConverter {
    // Method to convert meters to kilometers
    public static double metersToKilometers(double meters) {
        return meters / 1000;
    }

    // Method to convert miles to kilometers
    public static double milesToKilometers(double miles) {
        return miles * 1.60934;
    }

    // Method to convert kilometers to meters
    public static double kilometersToMeters(double kilometers) {
        return kilometers * 1000;
    }

    // Method to convert kilometers to miles
    public static double kilometersToMiles(double kilometers) {
        return kilometers / 1.60934;
    }
}


package main;
import converter.TimeConverter;

public class Main {
    public static void main(String[] args) {
        double hours = 2.5; // Replace with your desired input
        int minutes = TimeConverter.hoursToMinutes(hours);
        int seconds = TimeConverter.hoursToSeconds(hours);

        System.out.println(hours + " hours is equivalent to:");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");

        int inputMinutes = 150; // Replace with your desired input
        int inputSeconds = 7200; // Replace with your desired input
        double convertedHoursFromMinutes = TimeConverter.minutesToHours(inputMinutes);
        double convertedHoursFromSeconds = TimeConverter.secondsToHours(inputSeconds);

        System.out.println(inputMinutes + " minutes is equivalent to " + convertedHoursFromMinutes + " hours.");
        System.out.println(inputSeconds + " seconds is equivalent to " + convertedHoursFromSeconds + " hours.");
    }
}