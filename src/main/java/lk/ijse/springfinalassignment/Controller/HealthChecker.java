package lk.ijse.springfinalassignment.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3/health")
public class HealthChecker {
    @GetMapping
    public String get(){
        return "Api is working";
    }
}
