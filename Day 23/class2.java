class Calculator{

    int getResult(int val1, int val2, int op) {

        if(op==1)
            { return val1+val2;}

            else if {
                (op==2) return val1-val2;
            }
            else if{(op==3) return val1*val2;
            }
            else if(op==4) {
                if (val2!=0) {
                    return val1/val2;}
                 else{ return 0;}}
                    else{ return -1;}
}
public static void main(String args[]){
Calculator C = new Calculator();
System.out.println("Result for add: " + C.getResult(10, 5, 1));
System.out.println("Result for subtract: " + C.getResult(10, 5, 2));
System.out.println("Result for multiply: " + C.getResult(10, 5, 3));
System.out.println("Result for divide: " + C.getResult(10, 5, 4));
System.out.println("Result for divide by zero: " + C.getResult(10, 0, 4));
System.out.println("Result for invalid op: " + C.getResult(10, 5, 99));
}
}