import javax.swing.*;
import java.util.Scanner;
import java.util.Arrays;

public class Tasks3 {
    public static void main(String[] args) {
        Scanner v = new Scanner(System.in);
        //1
        System.out.println("Введите коэффициент уравнения ");
        int a1 = v.nextInt();
        int b1 = v.nextInt();
        int c1 = v.nextInt();
        v.nextLine();
        System.out.println("Количество корней уравенеия " +t1(a1,b1,c1));
        //2
        System.out.println("Введите строку ");
        String a2 = v.nextLine();
        System.out.println("Позиция второго zip " +t2(a2));
        //3
        System.out.println("Введите число ");
        int a3 = v.nextInt();
        v.nextLine();
        System.out.println("Совершенное ли число " +t3(a3));
        //4
        System.out.println("Введите строку ");
        String a4 = v.nextLine();
        System.out.println("Результат " +t4(a4));
        //5
        System.out.println("Введите строку ");
        String a5 = v.nextLine();
        System.out.println("Результат " +t5(a5));
        //6
        int[] mas1 = new int[]{1,2,3};
        int[] mas2 = new int[]{5,2,3};
        System.out.println("Одинаковое ли кол-во уникальных элементов " +t6(mas1,mas2));
        mas1=new int[]{1,2,3};
        mas2=new int[]{2,3,3};
        System.out.println(mas1[0]+" "+mas1[1]+" "+mas1[2]);
        System.out.println(mas2[0]+" "+mas2[1]+" "+mas2[2]);
        System.out.println("Одинаковое ли кол-во уникальных элементов " +t6(mas1,mas2));
        //7
        System.out.println("Введите целое положительное число ");
        int a7 = v.nextInt();
        v.nextLine();
        System.out.println("Является числом Капрекара " +t7(a7));
        //8
        System.out.println("Введите строку двоичного кода ");
        String a8 = v.nextLine();
        System.out.println("Самая длинная последовательность нулей в строке " +t8(a8));
        //9
        System.out.println("Введите число для проверки ");
        int a9 = v.nextInt();
        System.out.println("Результат " +t9(a9));
        //10
        System.out.println("Введите стороны треугольника ");
        int a10 = v.nextInt();
        int b10 = v.nextInt();
        int c10 = v.nextInt();
        System.out.println("Прямоугольный ли треугольник " +t10(a10,b10,c10));

    }
    //1)
    public static int t1(int a1, int b1, int c1){
        double disc=b1*b1-4*a1*c1;
        if (disc > 0)
            return 2;
        if (disc == 0)
            return 1;
        return 0;
    }
    //2
     public static int t2(String a2){
        int c = 0;
        int check = 0;
        char[] zipA = a2.toCharArray();
        for (int i = 2; i < zipA.length ; i++) {
            if (zipA[i-2] == 'z' && zipA[i-1] == 'i' && zipA[i] == 'p'){
                check += 1;
                if (check == 2)
                    c = i-2;
            }
        }
        return c;
    }
    //3
    public static boolean t3(int a3){
        int sum=0;
        for (int i = 1; i < a3; i++) {
            if (a3 % i == 0)
                sum += i;
        }
        return sum == a3;
    }
    //4
    public static String t4(String a4){
        if (a4.length() < 2)
            return "несовместно";
        if (a4.toCharArray()[0] == a4.toCharArray()[a4.toCharArray().length-1])
            return "Является парой";
        char[] W = a4.toCharArray();
        char pHolder = W[W.length-1];
        W[W.length-1] = W[0];
        W[0] = pHolder;
        String rez = new String(W);
        return rez;
    }
    //5
    public static boolean t5(String a5) {
        boolean z1 = a5.toCharArray()[0] == '#';
        boolean z2 = a5.length() == 7;
        boolean z3 = true;
        char[] hexA = a5.toCharArray();
        for (char i = 1; i < hexA.length - 1; i++) {
            z3 = ((hexA[i] >= 'a') && (hexA[i] <= 'f')) ||
                    ((hexA[i] >= 'A') && (hexA[i] <= 'F')) ||
                    ((hexA[i] >= '0') && (hexA[i] <= '9'));
            if (!z3) {
                break;
            }
        }
        return z1 && z2 && z3;
    }
    //6
    public  static boolean t6(int[] mas1, int[] mas2){
        Arrays.sort(mas1);
        Arrays.sort(mas2);
        int r1 = 0;
        int r2 = 0;
        for (int i = 0; i < mas1.length; i++)
        {
            while (i < mas1.length - 1 && mas1[i] == mas1[i + 1])
                i++;
            r1++;
        }
        for (int i = 0; i < mas2.length; i++)
        {
            while (i < mas2.length - 1 && mas2[i] == mas2[i + 1])
                i++;
            r2++;
        }
        return r1 == r2;
    }
    //7
    public static boolean t7(int a7){
        int left,right = 0;
        int j = (int) Math.pow(a7,2);
        String num1 = String.valueOf(j);
        int mid = num1.length()/2;
        right = Integer.parseInt(num1.substring(mid));
        if (num1.length() == 1)
            left=0;
        else
            left=Integer.parseInt(num1.substring(0,mid));
        return left+right == j;
    }
    //8
    public static String t8(String a8){
        int w1 =0;
        int w2 =0;
        int w3 =0;
        int w4 =0;
        char[] seqA = a8.toCharArray();
        for (int i = 0; i < seqA.length; i++) {
            if (seqA[i] == '0') {
                w4 += 1;
                if (w4 == 1)
                    w2 = i;
            } else {
                if (w4 > w3) {
                    w3 = w4;
                    w1 = w2;
                }
                w4 = 0;
            }
        }
        String rez="0";
        System.out.println("Длинна " +w3);
        return rez.repeat(w3);
    }
    //9
    public static int t9(int a9){
        while(true){
            int l = (int) Math.sqrt(a9);
            int counter = 0;
            for(int i = 2; i <= l; i ++){
                if(a9 % i == 0)
                    counter++;
            }
            if(counter == 0)
                return a9;
            else{
                a9++;
            }
        }
    }
    //10
    public static boolean t10(int a10, int b10, int c10){
        return a10 * a10 + b10 * b10 == c10 * c10 || a10 * a10 + c10 * c10 == b10 * b10 || b10 * b10 + c10 * c10 == a10 * a10;
    }
}
