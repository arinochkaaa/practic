package com.epam.rd.autotasks.triangle;

class Triangle {
    private Point a;
    private Point b;
    private Point c;

    // Конструктор
    public Triangle(Point a, Point b, Point c) {
        if (isCollinear(a, b, c)) {
            throw new IllegalArgumentException("Точки не могут быть коллинеарными");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Метод для проверки коллинеарности точек
    private boolean isCollinear(Point a, Point b, Point c) {
        // Проверяем коллинеарность по площади параллелограмма
        return (b.getY() - a.getY()) * (c.getX() - b.getX()) == (c.getY() - b.getY()) * (b.getX() - a.getX());
    }

    // Метод для вычисления площади треугольника
    public double area() {
        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2.0);
    }

    // Метод для вычисления центра треугольника (центроида)
    public Point centroid() {
        double centroidX = (a.getX() + b.getX() + c.getX()) / 3.0;
        double centroidY = (a.getY() + b.getY() + c.getY()) / 3.0;
        return new Point(centroidX, centroidY);
    }

    public static void main(String[] args) {
        // Примеры использования класса Triangle

        // Пример 1: площадь треугольника
        double area = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).area();
        System.out.println(area); // Вывод: 6.0

        // Пример 2: центроид треугольника
        Point centroid = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 3)).centroid();
        System.out.println(centroid.getX()); // Вывод: 1.0
        System.out.println(centroid.getY()); // Вывод: 1.0

        // Пример 3: проверка коллинеарности (исключение)
        try {
            new Triangle(new Point(0, 0), new Point(1, 0), new Point(2, 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Вывод: Точки не могут быть коллинеарными
        }
    }
}
