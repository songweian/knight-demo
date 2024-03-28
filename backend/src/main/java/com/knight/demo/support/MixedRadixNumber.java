package com.knight.demo.support;

import java.util.Arrays;

public class MixedRadixNumber {
    private int[] digits;
    private int[] radices;

    public MixedRadixNumber(int[] digits, int[] radices) {
        this.digits = digits;
        this.radices = radices;
    }

    public MixedRadixNumber add(MixedRadixNumber other) {
        int[] result = new int[digits.length];
        int carry = 0;
        for (int i = 0; i < digits.length; i++) {
            int sum = digits[i] + other.digits[i] + carry;
            result[i] = sum % radices[i];
            carry = sum / radices[i];
        }
        return new MixedRadixNumber(result, radices);
    }

    public MixedRadixNumber subtract(MixedRadixNumber other) {
        int[] result = new int[digits.length];
        int borrow = 0;
        for (int i = 0; i < digits.length; i++) {
            int diff = digits[i] - other.digits[i] - borrow;
            if (diff < 0) {
                diff += radices[i];
                borrow = 1;
            } else {
                borrow = 0;
            }
            result[i] = diff;
        }
        return new MixedRadixNumber(result, radices);
    }

    @Override
    public String toString() {
        return Arrays.toString(digits);
    }
}
