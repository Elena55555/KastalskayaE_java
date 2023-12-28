package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import static java.util.Objects.isNull;

public final class BalancedBracketService {

    private static final Map<Character, Character> brackets = new HashMap<Character, Character>();

    static {
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
    }

    private BalancedBracketService() {
    }

    /**
     * Метод принимает строку и проверяет является ли строка "сбалансированной"
     */

    public static boolean isBalancedBrackets(String input) {
        if (isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("Длина должна быть больше ноля");
        }
        if (input.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (stack.size() > input.length() - i) {
                return false;
            }
            char c = input.charAt(i);
            if (brackets.containsKey(c)) {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            char lastSymbol = stack.pop();
            if (c != brackets.get(lastSymbol)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}







