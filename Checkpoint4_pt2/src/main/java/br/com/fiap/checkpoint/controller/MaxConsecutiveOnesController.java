package br.com.fiap.checkpoint.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaxConsecutiveOnesController {

    @PostMapping("/max-consecutive-ones")
    public ResponseEntity<Map<String, Integer>> findMaxConsecutivesOnes(@RequestBody int[] nums) {
        if (nums == null || nums.length == 0) {
            return ResponseEntity.badRequest().body(null);
        }

        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);

        Map<String, Integer> response = new HashMap<>();
        response.put("maxConsecutiveOnes", maxConsecutiveOnes);

        return ResponseEntity.ok(response);
    }

    private int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                currentConsecutiveOnes++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
            } else {
                currentConsecutiveOnes = 0;
            }
        }

        return maxConsecutiveOnes;
    }
}
