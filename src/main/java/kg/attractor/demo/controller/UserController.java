package kg.attractor.demo.controller;

import kg.attractor.demo.model.User;
import kg.attractor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/employer/{id}")
    public ResponseEntity<User> getEmployer(@PathVariable int Userid) {
        return new ResponseEntity<>(userService.getUserById(Userid), HttpStatus.OK);

    }

    @GetMapping("/applicant/{id}")
    public ResponseEntity<User> getApplicant(@PathVariable int ApplicantId) {
        return new ResponseEntity<>(userService.getUserById(ApplicantId), HttpStatus.OK);
    }


}
