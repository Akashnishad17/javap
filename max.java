import java.util.Scanner;
class max {
    public static void maxPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int i,j;
        for(i = row-2; i >= 0; i--)
            grid[i][0] += grid[i+1][0];
        for(j = col-2; j >= 0; j--)
            grid[0][j] += grid[0][j+1];
        for(i = row-2; i >= 0; i--)
        {
            for(j = col-2; j >= 0; j--)
                grid[i][j] += Math.max(grid[i+1][j],grid[i][j+1]); 
        }
    }
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       int row = sc.nextInt();
       int col = sc.nextInt();
       int[][] grid = new int[row][col];
       for(int i = 0; i < row; i++)
       {
            for(int j = 0; j < col; j++)
                grid[i][j] = sc.nextInt();
       }
       maxPathSum(grid);
       int count = 0;
       int max = Integer.MIN_VALUE;
       for(int i = row-1; i >= 0; i--)
       {
            for(int j = col-1; j >= 0; j--)
            {
                if(i == row-1 || j == col-1)
                {
                    if(i == row-1 && j == col-1)
                    {
                        max = grid[i][j];
                        count++;
                        continue;
                    }
                    if(i == row-1)
                    {
                        if(max == Math.max(grid[i][j],grid[i][j+1]-grid[i][j]))
                            count++;
                        else
                        {
                            count = 1;
                            max = Math.max(grid[i][j],grid[i][j+1]-grid[i][j]);
                        }
                        continue;
                    }
                    if(j == col-1)
                    {
                        if(max == Math.max(grid[i][j],grid[i+1][j]-grid[i][j]))
                            count++;
                        else
                        {
                            count = 1;
                            max = Math.max(grid[i][j],grid[i+1][j]-grid[i][j]);
                        }
                        continue;
                    }
                }
                if(max == Math.max(grid[i][j],Math.max(grid[i][j+1]-grid[i][j],grid[i+1][j]-grid[i][j])))
                    count++;
                else
                {
                    count = 1;
                    max = Math.max(grid[i][j],Math.max(grid[i][j+1]-grid[i][j],grid[i+1][j]-grid[i][j]));
                }
            }
       }
       System.out.println(max+" "+count);
        sc.close();
    }    
}