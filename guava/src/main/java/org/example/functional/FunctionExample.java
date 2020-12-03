package org.example.functional;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2020-12-02 19:28
 **/
public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public @Nullable Integer apply(@Nullable String input) {
                Preconditions.checkNotNull(input);
                return input.length();
            }
        };
        System.out.println(function.apply("Hello"));

        Function<String, Double> compose = Functions.compose(new Function<Integer, Double>() {
            @Override
            public @Nullable Double apply(@Nullable Integer input) {
                return input*1.0;
            }
        }, new Function<String, Integer>() {
            @Override
            public @Nullable Integer apply(@Nullable String input) {
                Preconditions.checkNotNull(input);
                return input.length();
            }
        });
        System.out.println(compose.apply("Hello" +
                ""));
    }
}
