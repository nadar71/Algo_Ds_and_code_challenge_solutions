
/*
t : O(n)
s : O(1)
*/

public class Main {

  

  public void printMatrix(int[][] matrix){
    int col_len = matrix[0].length;
    int row_len = matrix.length;
    for(int i=0; i<row_len; i++){
      for(int j=0; j<col_len; j++){
        System.out.print("  "+ matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println("---------------------");
  }

  public void zeroMatrix(int[][] matrix){
    int col_len = matrix[0].length;
    int row_len = matrix.length;
    boolean firstZero = true;
    
    
    for(int i=0; i<row_len; i++){
      for(int j=0; j<col_len; j++){
        if ( (matrix[i][j]) == 0 && firstZero == true) {
           int idx_up = i-1; 
           int idx_dw = i+1; 
           int idx_lf = j-1; 
           int idx_rg = j+1;

           boolean done_up = false;
           boolean done_dw = false;
           boolean done_lf = false;
           boolean done_rg = false;

           while (done_up == false || done_dw == false || 
                  done_lf == false || done_rg == false){
              // up
              if(idx_up>=0){
                matrix[idx_up][j] = 0;
                idx_up--;
              } else done_up = true;

              // down
              if(idx_dw<row_len){
                matrix[idx_dw][j] = 0;
                idx_dw++;
              }  else done_dw = true;

              // right
              if(idx_lf>=0){
                matrix[i][idx_lf] = 0;
                idx_lf--;
                System.out.println("idx_lf : "+idx_lf);
              }  else done_lf = true;

              // left
              if(idx_rg<col_len){
                matrix[i][idx_rg] = 0;
                idx_rg++;
              }  else done_rg = true;
              
           }  // while
           firstZero = false;          
        } // if
        if (firstZero == false) break;
      } // for j 
      if (firstZero == false) break;
    } // for i
  
  }


  public static void main(String args[]){  
    Main m = new Main();

    int[][] matrix = {
      {1,1,1,1,1,1},
      {1,1,1,1,1,1},
      {1,1,1,0,1,1},
      {1,1,1,1,1,1}           
    };

    m.zeroMatrix(matrix);  
    m.printMatrix(matrix); 
    
    
    int[][] matrix2 = {
      {0,1,1,1,1,1},
      {1,1,1,1,1,1},
      {1,1,1,1,1,1},
      {1,1,1,1,1,1}           
    };
    
    m.zeroMatrix(matrix2);  
    m.printMatrix(matrix2); 
    
    
    int[][] matrix3 = {
      {1,1,1,1,1,1},
      {1,1,1,1,1,1},
      {1,1,1,1,1,1},
      {1,1,1,1,1,0}           
    };
    
    m.zeroMatrix(matrix3);  
    m.printMatrix(matrix3); 
    
    
    int[][] matrix4 = {
      {1,1,1,1,1,1},
      {1,1,1,1,1,1},
      {0,1,1,1,1,1},
      {1,1,1,1,1,1}           
    };
    
    m.zeroMatrix(matrix4);  
    m.printMatrix(matrix4); 
    
          
  }
    
}
