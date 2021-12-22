package com.mycompany.credit.controller;

import com.mycompany.credit.service.CreditService;
import com.mycompany.credit.service.dto.DataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class CreditController {

    private final CreditService creditService;

    @PostMapping("/createCredit")
    public ResponseEntity<Long> createCredit(@RequestBody DataDto request) {
        return ResponseEntity.ok()
                .body(creditService.createCredit(request));
    }

    @GetMapping("/getCredits")
    public ResponseEntity<List<DataDto>> getCredit(){
        List<DataDto> credits = creditService.getCredits();
        if (CollectionUtils.isEmpty(credits)){
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.ok()
                .body(credits);
    }
}
