package com.company;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------------------\n" +
                           "Program to check validity of user-inputted address given list of valid addresses\n" +
                           "Created by Thomas Ibbotson\n" + "\n" +
                           "Last modified December 7th, 2022\n" +
                           "--------------------------------------------------------------------------------\n");

        Scanner in;
        ArrayList<Address> validAddressList = new ArrayList<>();
        try {
            in = new Scanner(new File("src/Valid Address List.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        while (in.hasNextLine()) {
            String line = in.nextLine();
            int streetNum = Integer.parseInt(line.substring(0, line.indexOf(',')));
            String streetName = line.substring(line.indexOf(',') + 1, line.indexOf(',', line.indexOf(',') + 1));
            int zipCode = Integer.parseInt(line.substring(line.indexOf(',', line.indexOf(',') + 1) + 1));

            validAddressList.add(new Address(streetNum, streetName, zipCode));
        }
        in.close();

        boolean status = true;
        while (status) {
            in = new Scanner(System.in);
            System.out.print("Please enter the address e.g. 3501 Lovers Ln: ");
            String input = in.nextLine();
            int zipCode = 11111;

            while (true) {
                System.out.print("Please enter the zipcode (must be 5-digit number) e.g. 75205: ");
                try {
                    zipCode = in.nextInt();
                    in.nextLine();
                } catch (InputMismatchException e) {
                    in.nextLine();
                    System.out.println("Error: input must be an integer.\n");
                }

                if (zipCode > 99999 || zipCode < 11111) {
                    System.out.println("Error: input must be a 5-digit number.\n");
                    continue;
                }
                break;
            }

            int streetNum = Integer.parseInt(input.substring(0, input.indexOf(' ')));
            String streetName = input.substring(input.indexOf(' ') + 1);

            Address inputAddress = new Address(streetNum, streetName, zipCode);
            boolean validity = false;
            for (int i = 0; i < validAddressList.size() && !validity; i++) {
                if (validAddressList.get(i).compareTo(inputAddress) == 0) {
                    System.out.println("Address valid!\n");
                    validity = true;
                }
            }
            if (!validity)
                System.out.println("Address invalid!\n");

            while (true) {
                System.out.println("Try again? Y or N: ");
                input = in.nextLine();
                input = input.toUpperCase();
                if (input.equals("Y"))
                    break;
                if (input.equals("N")) {
                    status = false;
                    break;
                }
                System.out.println("Invalid selection. Must input Y or N");
            }
        }
        System.out.println("Thank you for using the program.");
    }
}
