package br.com.fiap.checkpoint.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParenthesesValidatorController {

    @PostMapping("/validate-parentheses")
    public ResponseEntity<Map<String, Boolean>> validateParentheses(@RequestBody Map<String, String> requestBody) {
        if (!requestBody.containsKey("input")) {
            Map<String, Boolean> response = new HashMap<>();
            response.put("isValid", false);
            return ResponseEntity.badRequest().body(response);
        }

        String input = requestBody.get("input");
        boolean isValid = isValidParentheses(input);

        Map<String, Boolean> response = new HashMap<>();
        response.put("isValid", isValid);

        return ResponseEntity.ok(response);
    }

    private boolean isValidParentheses(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatchingPair(char character1, char character2) {
        return (character1 == '(' && character2 == ')') ||
               (character1 == '{' && character2 == '}') ||
               (character1 == '[' && character2 == ']');
    }
}
