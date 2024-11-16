package edu.cicdtest.controller;


import edu.cicdtest.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    @GetMapping("api/ai")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("연결 된 듯?");
    }
    @GetMapping()
    public ResponseEntity<?> test(@RequestParam int id){
        return ResponseEntity.ok(testService.findTestById(id));
    }
    @PostMapping()
    public ResponseEntity<?> testPost(){
        return ResponseEntity.ok(testService.testCreate());
    }
}
