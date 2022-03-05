package Flooring.UI;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    Scanner sc;

    public UserIOConsoleImpl() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        this.print(prompt);
        return Double.parseDouble(this.sc.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double num;
        do {
            this.print(prompt);
            num = Double.parseDouble(this.sc.nextLine());
        } while(num < min || num > max);

        return num;
    }

    @Override
    public float readFloat(String prompt) {
        this.print(prompt);
        return Float.parseFloat(this.sc.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float num;
        do {
            this.print(prompt);
            num = Float.parseFloat(this.sc.nextLine());
        } while(num < min || num > max);

        return num;
    }

    @Override
    public int readInt(String prompt) {
        this.print(prompt);
        return Integer.parseInt(this.sc.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int num;
        do {
            this.print(prompt);
            num = Integer.parseInt(this.sc.next());
        } while(num < min || num > max);

        return num;
    }

    @Override
    public long readLong(String prompt) {
        this.print(prompt);
        return Long.parseLong(this.sc.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long num;
        do {
            this.print(prompt);
            num = Long.parseLong(this.sc.nextLine());
        } while(num < min || num > max);

        return num;
    }

    @Override
    public String readString(String prompt) {
        this.print(prompt);
        return this.sc.nextLine();
    }
}