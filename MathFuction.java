@FunctionalInterface
interface MathFunction{
    int calculate(int a,int b);
    static void printResult(int a, int b, String function, MathFunction fobj) {
        System.out.println("Result of "+function+" is"+fobj.calculate(a, b));
    }
}
public class MathOperation {
    public static void main(String[] args) {
        //This method implements "IMathFunction" interface
        MathFunction add =  Integer::sum;
        //This expression implements 'IMathFunction'
        MathFunction multiply = (x,y) -> x * y;
        MathFunction divide = (int x , int y) -> x/y;

        //Add & Divide two numbers using lambda expression
        System.out.println("Addition is " + add.calculate(6,3));
        System.out.println("Multiplication is " + multiply.calculate(2,3));
        System.out.println("Division is " + divide.calculate(9,3));

   
        MathFunction.printResult(4, 2, "Multiplication", multiply);
        MathFunction.printResult(9, 3, "Division", divide);
    }
}
