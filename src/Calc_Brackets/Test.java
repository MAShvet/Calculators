package Calc_Brackets;

public class Test
{
    private String input;
    private long output;
    private int number;
    private static int i = 1;
    static Test test1 = new Test("1+5*2+6.",17);
    static Test test2 = new Test("2*4.",8);
    static Test test3 = new Test("3*(2+1).",9);
    static Test test4 = new Test("(2+2)*2.",8);
    static Test test5 = new Test("(2+2)*3+2*(3+3).",24);
    static Test test6 = new Test("(1+(1+(1+(1+(2+3))))).",9);
    static Test test7 = new Test("1+(1+(1+(1+(2+3)))).",9);
    static Test test8 = new Test("10-2.",8);
    private Test(String test, long result)
    {
        this.input = test;
        this.output = result;
        this.number = i;
        i++;
    }

    public static long startTesting (Test test)
    {
        Calculator.clear();
        long result = Calculator.startCalculation(test.input);
        if (result == test.output)
        {
            System.out.println(test.toStringName() + " - Yes");
        }
        else
        {
            System.out.println(test.toStringName() + " - No");

        }
        System.out.println(test.input);
        System.out.print("Result - ");
        return result;
    }

    private String toStringName()
    {
        return "Test " + number;
    }
}
