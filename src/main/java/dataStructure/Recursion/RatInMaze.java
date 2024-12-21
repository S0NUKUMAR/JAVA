package dataStructure.Recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    static String dir= "DLRU";
    static int[] dr ={1, 0, 0, -1};
    static int[] dc ={0, -1, 1, 0};

    public static boolean isValidMove(List<List<Integer>> maze , int row , int col){
        return row < maze.size() && col < maze.size() && col >=0 && row >=0 && maze.get(row).get(col) == 1;
    }

    public static void main(String[] args) {
        List<List<Integer>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(List.of(1, 0, 0, 0)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 1)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 0)));
        maze.add(new ArrayList<>(List.of(0, 1, 1, 1)));

        int n = maze.size();
        List<String> result = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        findPath(maze, 0, 0, result, currentPath);
        System.out.println(result);
    }

    private static void findPath(List<List<Integer>> maze, int row, int col, List<String> result, StringBuilder currentPath) {
        if(row == maze.size() -1 && col == maze.size() -1){
            result.add(currentPath.toString());
            return;
        }

        maze.get(row).set(col,0);

        for(int direction = 0 ; direction < 4 ; direction++){
                int nextrow = row + dr[direction];
                int nextcol = col + dc[direction];

                if(isValidMove(maze,nextrow,nextcol)){
                    currentPath.append(dir.charAt(direction));
                    findPath(maze,nextrow,nextcol,result,currentPath);
                    currentPath.deleteCharAt(currentPath.length() -1);
                }
        }
        maze.get(row).set(col,1);
    }
}
