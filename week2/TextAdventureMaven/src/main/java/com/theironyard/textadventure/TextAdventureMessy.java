package com.theironyard.textadventure;//import java.util.Scanner;
//
///**
// * Created by jeff on 11/30/16.
// */
//public class TextAdventureMessy {
//
//    public static void main(String[] args) throws Exception {
//        //Create our scanner
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Welcome traveler");
//        System.out.println("What is your name foolish traveler");
//        String name = input.nextLine();
//
//        System.out.println("Welcome, " + name);
//
//        //Ask for what weapon
//        System.out.println("Choose your weapon: Mace or Sword");
//        String weapon = input.nextLine();
//
//        if(weapon.equalsIgnoreCase("sword")){
//            System.out.println("A sword is a fine choice.");
//        }
//        else if(weapon.equalsIgnoreCase("Mace")){
//            System.out.println("A mace is a stupid choice.");
//        }
//        else{
//            throw new Exception("Invalid weapon");
//        }
//
//        System.out.println("Choose your location [forest/cave]");
//        String location = input.nextLine();
//
//        if(location.equalsIgnoreCase("forest")){
//            System.out.println("Now entering spooky forest...");
//        }
//        else if(location.equalsIgnoreCase("cave")){
//            System.out.println("Now entering cave strong with the dark side of the force");
//        }
//        else{
//            throw new Exception(("Invalid location"));
//        }
//    }
//}
