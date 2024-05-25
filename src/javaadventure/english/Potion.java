package javaadventure.english;

public class Potion {
    private String name;
    private int healthPoints;
    private int numbers;

    public Potion(String name, int healthPoints, int numbers) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.numbers = numbers;
    }
    
    public Potion(){
        name = "";
        healthPoints = 0;
        numbers = 0;
    }
    
    public void decreaseNumbers(){
        if(numbers > 0){
            numbers--;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthPoints(int healthPoint) {
        this.healthPoints = healthPoint;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
}