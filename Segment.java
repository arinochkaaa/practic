package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;


 class Segment {
    private Point start;
    private Point end;

    // Конструктор
    public Segment(Point start, Point end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException("Начало и конец отрезка не могут быть одинаковыми точками");
        }
        this.start = start;
        this.end = end;
    }

    // Метод для получения длины отрезка
    public double length() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    // Метод для получения средней точки отрезка
    public Point middle() {
        double midX = (start.getX() + end.getX()) / 2;
        double midY = (start.getY() + end.getY()) / 2;
        return new Point(midX, midY);
    }

    // Метод для нахождения точки пересечения с другим отрезком
    public Point intersection(Segment another) {
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();

        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (denominator == 0) {
            return null; // Отрезки параллельны или коллинеарны
        }

        double intersectX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
        double intersectY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;
        Point intersection = new Point(intersectX, intersectY);

        if (isPointOnSegment(intersection, this) && isPointOnSegment(intersection, another)) {
            return intersection;
        }
        return null; // Точка пересечения не лежит на обоих отрезках
    }

    // Вспомогательный метод для проверки, лежит ли точка на отрезке
    private boolean isPointOnSegment(Point point, Segment segment) {
        double x = point.getX();
        double y = point.getY();
        double x1 = segment.start.getX();
        double y1 = segment.start.getY();
        double x2 = segment.end.getX();
        double y2 = segment.end.getY();

        return x >= Math.min(x1, x2) && x <= Math.max(x1, x2) &&
                y >= Math.min(y1, y2) && y <= Math.max(y1, y2);
    }

    public static void main(String[] args) {
        // Примеры использования класса Segment

        // Пример 1: длина отрезка
        double length = new Segment(new Point(0, 0), new Point(3, 4)).length();
        System.out.println(length); // Вывод: 5.0

        // Пример 2: точка пересечения
        Segment first = new Segment(new Point(0, 0), new Point(4, 4));
        Segment second = new Segment(new Point(2, 0), new Point(0, 2));
        Point intersection = first.intersection(second);

        if (intersection != null) {
            System.out.println(intersection.getX()); // Вывод: 1.0
            System.out.println(intersection.getY()); // Вывод: 1.0
        } else {
            System.out.println("Отрезки не пересекаются");
        }

        // Пример 3: средняя точка отрезка
        Segment segment = new Segment(new Point(2, 0), new Point(0, 2));
        Point midpoint = segment.middle();
        System.out.println(midpoint.getX()); // Вывод: 1.0
        System.out.println(midpoint.getY()); // Вывод: 1.0

        // Пример 4: отсутствие пересечения
        first = new Segment(new Point(0, 0), new Point(4, 0));
        second = new Segment(new Point(2, 1), new Point(1, 2));
        intersection = first.intersection(second);
        System.out.println(intersection == null); // Вывод: true
    }
}
