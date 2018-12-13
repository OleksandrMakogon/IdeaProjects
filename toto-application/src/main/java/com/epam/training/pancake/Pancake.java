package com.epam.training.pancake;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Pancake {

    private static final double MIN_DIFF = 0.1;

    private final String name;

    private final double diameter;

    public Pancake(String name, double diameter) {
        super();
        this.name = name;
        this.diameter = diameter;
    }

    @org.jetbrains.annotations.Contract(pure = true)
    public String getName() {
        return name;
    }

    public double getDiameter() {
        return diameter;
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public String toString() {
        return name + "; " + diameter;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pancake other = (Pancake) obj;
        if (Math.round(this.diameter / MIN_DIFF) != Math.round(other.diameter / MIN_DIFF))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Math.round(diameter/MIN_DIFF));
    }
}
