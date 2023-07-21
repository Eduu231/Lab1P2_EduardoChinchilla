package lab1p2_eduardochinchilla;

import java.util.*;

public class Lab1P2_EduardoChinchilla {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 3) {

            opcion = menu();

            switch (opcion) {

                case 1: {
                    System.out.println("Ingrese a: ");
                    int a = read.nextInt();
                    while (a == 0) {
                        System.out.println("Error, a no puede ser igual a 0");
                        System.out.println("Ingrese a denuevo");
                        a = read.nextInt();
                    }
                    System.out.println("Ingrese b: ");
                    int b = read.nextInt();
                    System.out.println("Ingrese c: ");
                    int c = read.nextInt();

                    // ecuaciones
                    double vertice = -b / (2 * a);

                    //no las use tira un error en el calculo matematico
//                    double ecuacionS = (Math.pow(a * vertice, 2)) + b * vertice + c;
//                    double derivada = (2 * a * vertice) + b;
                    System.out.println("Raiz Positiva");
                    System.out.println(XRecursiva(a, b, c, vertice + 200, -100));
                    System.out.println("Raiz Negativa");
                    System.out.println(XRecursiva(a, b, c, vertice - 200, -100));

                    break;
                }

                case 2: {
                    System.out.println("Ingrese el limite");
                    int lim = read.nextInt();
                    System.out.println("Ingrese el valor de X");
                    int x = read.nextInt();

                    double resultado = 0;
                    double resultado2 = 0;
                    double resultado3 = 0;

                    System.out.println("Sen X");
                    System.out.println(sen(lim, x, resultado));
                    System.out.println("Cos X");
                    System.out.println(cos(lim, x, resultado2));
                    System.out.println("Tan X");
                    System.out.println(tan(lim, x, resultado3));
                    break;
                }
                case 3: {

                    System.out.println("Salir");
                    break;
                }
            }
        }

    }

    private static int menu() {
        int op = 0;
        System.out.println("Menu" + " \n " + "1. Metodo Newton-Raphson" + "\n" + "2. Serie de Taylor" + "\n" + "3. Salir");

        op = read.nextInt();

        return op;
    }

    private static double XRecursiva(int a, int b, int c, double vertice, int x) {
        //double calculo = 0;
        if (x < 0) {
            vertice -= (a * (Math.pow(vertice, 2)) + b * vertice + c) / (2 * a * vertice + b);
            return XRecursiva(a, b, c, vertice, x + 1);
        } else {
            return vertice;
        }
    }

    private static double sen(int lim, int valor, double resultado) {
//        double parte1 = Math.pow(-1, lim);
        int parte2 = (2 * lim + 1);
//        double parte3 = factorial(parte2);
//        double parte4 = (parte1/parte3)*Math.pow(x, (2*lim+1));

        if (lim > -1) {
            resultado += Math.pow(-1, lim) / factR(parte2) * Math.pow(valor, 2 * lim + 1);
            return sen(lim - 1, valor, resultado);
        } else {
            return resultado;
        }

    }

    private static double cos(int lim, int valor, double resultado2) {

        int parte1 = (2 * lim);

        if (lim > -1) {
            resultado2 += Math.pow(-1, lim) / factR(parte1) * Math.pow(valor, parte1);
            return cos(lim - 1, valor, resultado2);
        } else {
            return resultado2;
        }
    }

    private static double tan(int lim, int valor, double resultado3) {
        int parte1 = (2 * lim);

        if (cos(lim - 1, valor, resultado3) != 0) {
            if (lim > -1) {

                resultado3 += ((Math.pow(2, lim) * Math.pow(-4, lim) * (1 - Math.pow(4, lim)))) / ((factR(parte1) * Math.pow(valor, 2 * lim + 1)));
                return tan(lim - 1, valor, resultado3);
            } else {
                return resultado3;
                // -0.711
            }
        }
        return resultado3;
    }

    private static int factR(int x) {

        //en el caso de cos si empezamos por 0 en n nos tira infinity porque 2 * 0 = 0 entonces dividiriamos por 0
        if (x == 0) {
            return 1;
        }
        if (x > 1) {
            return x * (factR(x - 1));
        } else {
            return x;
        }
    }
}
