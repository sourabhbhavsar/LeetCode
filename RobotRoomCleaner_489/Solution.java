/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void cleanRoom(Robot robot) {
        HashSet<String> cleanedRooms = new HashSet<>();
        int direction = 0;
        
        cleanRoom(robot, 0, 0, direction, cleanedRooms);
    }
    
    public void cleanRoom(Robot robot, int x, int y, int direction, HashSet<String> cleanedRooms) {
        
        // clean the room and add it to cleaned rooms list.
        robot.clean();
        cleanedRooms.add(x + "," + y);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + directions[direction][0];
            int ny = y + directions[direction][1];
            
            if (cleanedRooms.contains(nx + "," + ny) == false) {
                if (robot.move()) {
                    cleanRoom(robot, nx, ny, direction, cleanedRooms);
                    goBack(robot);
                }
            }
            
            //turn the direction to move in a different direction
            robot.turnRight();
            direction = (direction + 1) % 4;
        }
    }
    
    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
