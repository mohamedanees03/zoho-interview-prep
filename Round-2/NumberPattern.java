public class NumberPattern{
    public static void main(String[] args) {
        int num = 5;
        for(int row=1;row<=num;row++){
            int temp = row;
            for(int col=1;col<=row;col++){
                System.out.print(temp+" ");
                temp = temp + num - col;
            }
            System.out.println();
        }
    }
}
