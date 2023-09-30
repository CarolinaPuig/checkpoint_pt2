package br.com.fiap.checkpoint.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingleNumberController {

    @PostMapping("/single-number")
    public ResponseEntity<Map<String, Integer>> findSingleNumbers(@RequestBody int[] nums) {
        if (nums == null || nums.length == 0) {
            return ResponseEntity.badRequest().body(null);
        }

        int result = findSingleNumber(nums);

        Map<String, Integer> response = new HashMap<>();
        response.put("singleNumber", result);

        return ResponseEntity.ok(response);
    }

    private int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // Usando operador XOR para encontrar o número único
        }
        return result;
    }
}
