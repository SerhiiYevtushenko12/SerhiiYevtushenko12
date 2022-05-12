package Lesson1;

public class CristmasTree {
    public static void main(String[] args)
    {
        while (true) {
            printTree();
        }
    }

    private static void printTree() {
        int a = 6, b = 0;
        for (int i = 1; i <= a; i++)
        {
            for (int j = 1; j <= (a + i - 1); j++)
            {
                if (j <= (a - i))
                {
                    System.out.print('.');
                    b++;
                }
                else
                {
                    System.out.print('*');
                }
            }
            for (int j = 1; j <= b; j++)
            {
                System.out.print('.');
            }
            b = 0;
            System.out.println();
        }
    }
}
