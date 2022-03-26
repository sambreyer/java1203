import World.InterestingPoint;

/* FILE: ur_Robot.java */
// Created by: Samuel Breyer 2022

/* TODO: Finish display
        Refactor for 'Off' status
        Finish World class        
**/
public class ur_Robot {

    //X coordinate
    private int x;
    //Y coordinate
    private int y;
    //0 north, 1 east, 2 south, 3 west
    private int direction;
    //number of beepers in bag
    private int count;
    private World world;

    ur_Robot(int x, int y, int direction, int count, World world){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.count = count;
        if (world == null) {
            this.world = World.randomWorld();
        } else {
            this.world = world;
        }  
    } 

    ur_Robot(int x, int y, int direction, int count){
        this(x, y, direction, count, null);
    }
       
    //Walls at even numbers
    void move() {
        switch(direction){
            case 0: 
                if(world.corners[x][y+1].type == World.InterestingPoint.WALL){
                    turnOff();    
                } 
                y+=2;
                break;
            case 1:
                if(world.corners[x+1][y].type == World.InterestingPoint.WALL){
                    turnOff();    
                } 
                x+=2;
                break;
            case 2:
                if(world.corners[x][y-1].type == World.InterestingPoint.WALL){
                    turnOff();    
                } 
                y-=2;
                break;
            case 3:
                if(world.corners[x-1][y].type == World.InterestingPoint.WALL){
                    turnOff();    
                } 
                x-=2;
                break;
            default:
                throw new RuntimeException("Invalid Direction");    
        }
    }
    void turnLeft(){
        direction++;
        direction %= 4; 
    }
    void pickBeeper(){
        if(world.corners[x][y].type != World.InterestingPoint.BEEPER){
            turnOff();
        }
        world.corners[x][y].changeBeeper(-1);
        count++;
    }
    void putBeeper(){
        if(count == 0){
            turnOff();
        }
        world.corners[x][y].changeBeeper(1);
        count--;
    }
    void turnOff(){
        //hit wall, completed task, tried to pick up missing beeper, or drop missing beeper
        System.exit(0);
    }

    void display(){
        System.out.println(String.format("Robot:\n      Location: ( %d , %d )\n      Direction: %s\n      Beepers: %d\n     On/Off: %s\n============================", /*args*/ ));
    }

    public static void main(String[] args) {

        ur_Robot karel = new ur_Robot(1,1,2,0);

        karel.turnLeft();
        karel.move();
        karel.move();

        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        karel.move();
        karel.move();
        karel.pickBeeper();
        karel.move();

        karel.turnLeft();
        karel.move();
        karel.putBeeper();

        karel.turnOff();
    }
}
