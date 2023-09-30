package br.com.fiap.checkpoint.controller;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MaxConsecutiveOnesControllerTest {

    @Test
    public void testFindMaxConsecutiveOnes() {
        MaxConsecutiveOnesController controller = new MaxConsecutiveOnesController();

        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1};
        ResponseEntity<Map<String, Integer>> response = controller.findMaxConsecutivesOnes(nums);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().get("maxConsecutiveOnes").intValue());
    }

    @Test
    public void testInvalidRequest() {
        MaxConsecutiveOnesController controller = new MaxConsecutiveOnesController();

        int[] nums = {};
        ResponseEntity<Map<String, Integer>> response = controller.findMaxConsecutivesOnes(nums);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }
}
