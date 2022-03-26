public class World {
    
    //types of points
    public enum InterestingPoint {
        NONE,
        BEEPER,
        WALL
    }

    class interestingCorners {
        InterestingPoint type;
        int count;
        
        void changeBeeper(int d){
            count += d;
            if(count == 0){
                type = InterestingPoint.NONE;
            } else {
                type = InterestingPoint.BEEPER;
            }
        }
    }



    static World randomWorld(){

    }
    //Double point world for wall placement
    public interestingCorners[][] corners = new interestingCorners[20][20];
}
