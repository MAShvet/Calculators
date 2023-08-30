package Calc_Brackets;

import java.util.LinkedList;
import java.util.List;

public class CalculatorBrackets
{
    static List<StringBuffer> list = new LinkedList<>();
    public static void clear()
    {
        list.clear();
    }

    public static long calculation(String numericExpression)
    {
        doListStringBuffer(numericExpression);
        if (list.isEmpty())
        {
            System.out.println("Have a letter");
        }
        brackets(list);

        return Long.parseLong(String.valueOf(list.get(0)));
    }
    private static void doListStringBuffer(String str)
    {
        int start = 0;
        int finish = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '.' || Character.isLetter(str.charAt(i)))
            {
                break;
            }
            else if (Character.isLetter(str.charAt(i)))
            {
                list.clear();
                break;
            }
            if (Character.isDigit(str.charAt(i)))
            {
                start = i;
                while (Character.isDigit(str.charAt(i)))
                {
                    i++;
                    finish = i;
                }
                i--;
                list.add(count, new StringBuffer(str.substring(start, finish)));
                count++;
            }
            else if (!Character.isDigit(str.charAt(i)))
            {
                list.add(count, new StringBuffer(String.valueOf(str.charAt(i))));
                count++;
            }
        }
    }
    public static void brackets(List<StringBuffer> list)
    {
        int start = 0;
        int finish = 0;

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).charAt(0) == ')')
            {
                finish = i;
                for (int j = finish; j >= 0; j--)
                {
                    if (list.get(j).charAt(0) == '(')
                    {
                        start = j;
                        break;
                    }
                }
                list.remove(start);
                list.remove(finish-1);
                finish--;

                brackets(list.subList(start, finish));
            }
        }
        calculation(list);
    }

    public static void calculation(List<StringBuffer> list)
    {
        while (list.size() != 1)
        {
            for (int i = 2; i < list.size(); i += 2)
            {
                long num1 = Long.parseLong(String.valueOf(list.get(i - 2)));
                long num2 = Long.parseLong(String.valueOf(list.get(i)));

                if (list.get(i - 1).charAt(0) == '*')
                {
                    list.get(i - 1).replace(0, 1, String.valueOf(num1 * num2));
                }
                else if (i == list.size() - 1)
                {
                    if (list.get(i - 1).charAt(0) == '+')
                    {
                        list.get(i - 1).replace(0, 1, String.valueOf(num1 + num2));
                    }
                    else if (list.get(i - 1).charAt(0) == '-')
                    {
                        list.get(i - 1).replace(0, 1, String.valueOf(num1 - num2));
                    }
                }
                else
                {
                    calculation(list.subList(i, list.size()));
                    break;
                }
                list.remove(i - 2);
                list.remove(i - 1);
            }
        }
    }
}