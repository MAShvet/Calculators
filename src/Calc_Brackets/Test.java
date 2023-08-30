package Calc_Brackets;

public class Test
{
    private String input;
    private long output;
    static Test test1 = new Test("1+5*2+6.",17);
    static Test test2 = new Test("2*4.",8);
    static Test test3 = new Test("3*(2+1).",9);
    static Test test4 = new Test("(2+2)*2.",8);
    static Test test5 = new Test("(2+2)*3+2*(3+3).",24);
    static Test test6 = new Test("(1+(1+(1+(1+(2+3))))).",9);
    static Test test7 = new Test("1+(1+(1+(1+(2+3)))).",9);
    private Test(String test, long result)
    {
        this.input = test;
        this.output = result;
    }
//    public static String test1 = new String("1+5.");
//    public static long result1 = 6;
//    public static String test2 = new String("2*4.");
//    public static long result2 = 8;
//    public static String test3 = new String("3*(2+1).");
//    public static long result3 = 9;
//    public static String test4 = new String("(2+2)*2.");
//    public static long result4 = 8;
//    public static String test5 = new String("(2+2)*3+2(3+3).");
//    public static long result5 = 24;
//    public static String test6 = new String("(1+(1+(1+(1+(2+3))))).");
//    public static long result6 = 9;
//    public static String test7 = new String("1+(1+(1+(1+(2+3)))).");
//    public static long result7 = 9;


    public static long startTesting (Test test)
    {
        CalculatorBrackets.clear();
        long result = CalculatorBrackets.calculation(test.input);
        if (result == test.output)
        {
            System.out.println("test " + "1 - "  + "Yes");

        }
        else
        {
            System.out.println("test " + "1 - "  + "No");

        }
        System.out.println(test.input);
        System.out.print("Result - ");
        return result;
    }
}
