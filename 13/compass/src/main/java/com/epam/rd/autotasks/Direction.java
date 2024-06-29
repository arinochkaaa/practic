package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        for (Direction direction : Direction.values()) {
            if (direction.degrees == degrees) {
                return direction;
            }
        }
        return null; // Возвращаем null, если не найдено соответствие
    }

    public static Direction closestToDegrees(int degrees) {
        Direction closestDirection = null;
        int minDifference = Integer.MAX_VALUE;

        for (Direction direction : Direction.values()) {
            int difference = Math.abs(degrees - direction.degrees);
            if (difference < minDifference) {
                minDifference = difference;
                closestDirection = direction;
            }
        }

        return closestDirection;
    }

    public Direction opposite() {
        int oppositeDegrees = (this.degrees + 180) % 360;
        return Direction.ofDegrees(oppositeDegrees);
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = direction.degrees - this.degrees;
        if (difference < 0) {
            difference += 360;
        }
        return difference;
    }
}
