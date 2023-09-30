package br.com.fiap.checkpoint.controller;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SingleNumberControllerTest {

    @Test
    public void testFindSingleNumber() {
        SingleNumberController controller = new SingleNumberController();

        int[] nums = {4, 2, 5, 2, 4};
        ResponseEntity<Map<String, Integer>> response = controller.findSingleNumbers(nums);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(5, response.getBody().get("singleNumber").intValue());
    }

    @Test
    public void testInvalidRequest() {
        SingleNumberController controller = new SingleNumberController();

        int[] nums = {};
        ResponseEntity<Map<String, Integer>> response = controller.findSingleNumbers(nums);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }
}
