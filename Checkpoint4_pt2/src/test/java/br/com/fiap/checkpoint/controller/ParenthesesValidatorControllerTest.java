package br.com.fiap.checkpoint.controller;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ParenthesesValidatorControllerTest {

    @Test
    public void testValidParentheses() {
        ParenthesesValidatorController controller = new ParenthesesValidatorController();

        // Cenário feliz: Parênteses válidos
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("input", "({})[]");

        ResponseEntity<Map<String, Boolean>> response = controller.validateParentheses(requestBody);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().get("isValid"));
    }

    @Test
    public void testInvalidParentheses() {
        ParenthesesValidatorController controller = new ParenthesesValidatorController();

        // Cenário infeliz: Parênteses inválidos
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("input", "({}])");

        ResponseEntity<Map<String, Boolean>> response = controller.validateParentheses(requestBody);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().get("isValid"));
    }
}
