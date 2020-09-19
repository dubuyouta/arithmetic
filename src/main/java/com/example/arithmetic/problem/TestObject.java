package com.example.arithmetic.problem;

import java.util.Objects;

/**
 * @author xiaobao.chen
 * Create at 2020-08-12
 */
public class TestObject {

    private String name;

    private int day;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestObject that = (TestObject) o;
        return day == that.day &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, day);
    }
}
