package cs102.dz07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Zadatak3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> stekA = new Stack<>();

        System.out.println("Unesite koliko elemenata zelite da imate u steku:");
        int n = input.nextInt();

        System.out.println("Unesite sve podatke osim -1");

        for (int i = 0; i < n; i++) {
            stekA.push(input.nextInt());
            if (stekA.peek() == -1) {
                break;
            } else {
                continue;
            }
        }

        System.out.println("Stampam stek A");
        System.out.println(stekA);

        Stack<Integer> stekC = new Stack<>();

        stekC = kopija(stekA);

        System.out.println("Stampam kopirani stek C");
        System.out.println(stekC);

    }

    /*
        metodu add i remove sam koristio samo za queue a u zadatku kaze samo u radu
        sa stekovima ne smem da koristim tako da se nadam da je ok
     */
    public static Stack<Integer> kopija(Stack<Integer> stack) {
        Stack<Integer> stekB = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        while (!q.isEmpty()) {
            stack.push(q.remove());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        while (!q.isEmpty()) {
            stekB.push(q.peek());
            stack.push(q.remove());
        }

        return stekB;
    }

}
