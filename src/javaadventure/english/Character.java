package javaadventure.english;

public class Character {
    final private int HEALTH_POINTS;
    private String name;
    private int healthPoints;
    private int pointsOfAttack;
    private Weapon weapon;
    private Potion potion;

    public Character() {
        name = "";
        healthPoints = 0;
        pointsOfAttack = 0;
        HEALTH_POINTS = healthPoints;
        weapon = new Weapon();
        potion = new Potion();
    }
    
    

    public Character(String name, int healthPoints, int pointsOfAttack, Weapon weapon, Potion potion) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.pointsOfAttack = pointsOfAttack;
        HEALTH_POINTS = healthPoints;
        this.weapon = weapon;
        this.potion = potion;
    }
    
    public void getDamage(int totalDamage){
        healthPoints -= totalDamage;
    }
    
    public int doDamage(Weapon weapon){
        return pointsOfAttack + weapon.getDamage();
    }
    
    public boolean isLife(){
        if(healthPoints > 0){
            return true;
        }else{
            healthPoints = 0;
            return false;
        }
    }
    
    public void takePotion(Potion potion){
        healthPoints += potion.getHealthPoints();
        
        if(healthPoints > HEALTH_POINTS){
            healthPoints = HEALTH_POINTS;
        }
        
        potion.decreaseNumbers();
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getHEALTH_POINTS() {
        return HEALTH_POINTS;
    }

    public int getPointsOfAttack() {
        return pointsOfAttack;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setPointsOfAttack(int pointsOfAttack) {
        this.pointsOfAttack = pointsOfAttack;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}