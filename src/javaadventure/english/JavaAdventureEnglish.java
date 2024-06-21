package javaadventure.english;

import java.util.Scanner;
import java.util.Random;

public class JavaAdventureEnglish {
    public static Scanner input = new Scanner(System.in);
    public static int option;
    public static boolean validOption;
    
    public static void main(String[] args) {
        do{
            showMainMenu();
            switch(option){
                case 1:
                    play();
                    break;
                case 2:
                    System.out.println("\nThank for playing :D");
                    break;
                default:
                    System.out.println("\nInvalid option :c, try again");
                    break;
            }
        }while(option != 2);
    }
    
    public static void play(){
        int turn = 0;
        
        Weapon bow = new Weapon("Bow",50);
        Potion potionPlayer  = new Potion("Healing",150,5);
        Character player = new Character("Henry", 1500, 50, bow, potionPlayer);
        
        Weapon hammer = new Weapon("Hammer", 70);
        Potion potionEnemy = new Potion("Healing",150,5);
        Character enemy = new Character("Peter", 2500, 30, hammer, potionEnemy);
        
        do{
            do{
                validOption = true;
                String showTurn = (turn%2 == 0) ? "Player" : "Enemy";
                System.out.println("\n\tTurn "+(turn + 1)+": " + showTurn);

                System.out.println();
                player.showStats();

                System.out.println();
                enemy.showStats();

                if(turn%2 == 0){
                    showGameMenu();
                    actionCharacter(player, enemy, option);
                }else{
                    actCPU();
                    actionCharacter(enemy, player, option);
                }
            }while(!validOption);
            turn++;
            
            if(player.isLife() && !enemy.isLife()){
                System.out.println("\nPlayer wins");
            }else if(enemy.isLife() && !player.isLife()){
                System.out.println("\nEnemy wins");
            }
        }while(player.isLife() && enemy.isLife());
    }
    
    public static void showMainMenu(){
        System.out.println("\nJava Adventure\n");
        System.out.println("\tMain menu\n");
        System.out.println("1.- Play");
        System.out.println("2.- Exit");
        System.out.print("\nChoose a option: ");
        option = input.nextInt();
    }
    
    public static void showGameMenu(){
        System.out.println("\n\tGame Menu\n");
        System.out.println("1.- Attack");
        System.out.println("2.- Heal");
        System.out.print("\nChoose a option: ");
        option = input.nextInt();
    }
    
    public static void actCPU(){
        Random random = new Random();
        option = random.nextInt(2) + 1;
    }
    
    public static void actionCharacter(Character a, Character b, int option){
        switch(option){
            case 1:
                b.getDamage(a.doDamage());
                break;
            case 2:
                if(a.getPotion().getNumbers() > 0){
                    a.drinkPotion();
                }else{
                    System.out.println("\nYou have not potions, try again");
                    validOption = false;
                }
                break;
            default:
                System.out.println("\nInvalid option :c, try again");
                validOption = false;
                break;
        }
    }
}