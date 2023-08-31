package Calc_Brackets;

public class Test
{
    private final String input;
    private final long output;
    private final int number;
    private static int i = 1;
    static final Test test1 = new Test("1+5*2+6.",17);
    static final Test test2 = new Test("2*4.",8);
    static final Test test3 = new Test("3*(2+1).",9);
    static final Test test4 = new Test("(2+2)*2.",8);
    static final Test test5 = new Test("(2+2)*3+2*(3+3).",24);
    static final Test test6 = new Test("(1+(1+(1+(1+(2+3))))).",9);
    static final Test test7 = new Test("1+(1+(1+(1+(2+3)))).",9);
    static final Test test8 = new Test("10-2.",8);
    static Test test9 = new Test("4/2.",2);
    static Test test10 = new Test("(3+7)/(3-1).",5);
    static Test test11 = new Test("-3-7.",-10);
    static Test test12 = new Test("-3*7.",-21);
    static Test test13 = new Test("(-4)*(-7).",21);
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
