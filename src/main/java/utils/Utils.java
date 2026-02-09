package utils;

public class Utils {
    public static int generateRandomNumber(int min, int max){
        double randomNumber=Math.random()*(max-min)+min;
        return (int) randomNumber;
    }
}
