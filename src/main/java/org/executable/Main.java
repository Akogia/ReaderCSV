package org.executable;

import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Main.class.getName());
        log.info("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        log.info("Your username is " + username);
    }
}