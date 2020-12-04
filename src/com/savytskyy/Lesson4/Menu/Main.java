package com.savytskyy.Lesson4.Menu;

import java.util.Scanner;

import static java.lang.Math.PI;

abstract class UserAction {
    public abstract void doAction();
    public abstract String getName();
    }
}


class CircleAreaUserAction extends UserAction {
    Scanner sc;

    public CircleAreaUserAction(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void doAction() {
        System.out.println("Enter the radius: ");
        double radius = sc.nextDouble();
        sc.nextLine();
        double area = PI * Math.pow(radius, 2);
        System.out.println("The area of the circle is: +" + area);
    }

    @Override
    public String getName() {
        return "Circle area ";
    }
}

class RectAreaUserAction extends UserAction {
    Scanner sc;

    public RectAreaUserAction(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void doAction() {
        System.out.println("Enter dimension of side a: ");
        double a = sc.nextDouble();
        System.out.println("Enter dimension of side b: ");
        double b = sc.nextDouble();
        sc.nextLine();
        double area = a * b;
        System.out.println("The area of the rectangle is: +" + area);
    }

    @Override
    public String getName() {
        return "Rectangle area ";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserAction[] actions = {
                new CircleAreaUserAction(sc),
                new RectAreaUserAction(sc)
        };

        for (int i = 0; i < actions.length; i++) {
            System.out.print(i + 1 + " - ");
            System.out.println(actions[i].getName());
        }

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        int index = choice-1;

        if (index >= 0 && index < actions.length) {
            actions[index].doAction();
        } else {
            System.out.println("No way Jose!");
        }
    }
}
