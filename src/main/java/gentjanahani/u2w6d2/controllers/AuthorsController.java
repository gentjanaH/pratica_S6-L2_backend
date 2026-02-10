package gentjanahani.u2w6d2.controllers;

import gentjanahani.u2w6d2.entities.Authors;
import gentjanahani.u2w6d2.payloads.NewAuthorPayload;
import gentjanahani.u2w6d2.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
private final AuthorsService authorsService;

@Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }


    // 1. GET http://localhost:3002/authors
    @GetMapping
    public List<Authors> findAuthors(){
        return authorsService.findAllAuthors();
    }

    // 2. POST http://localhost:3002/authors (+payload)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Authors addNewAuthor(@RequestBody NewAuthorPayload payload){
    return this.authorsService.saveAuthors(payload);
    }

    // 3. GET http://localhost:3002/authors/{authorsId}
    @GetMapping("/{authorId}")
    public Authors getAuthorById(@PathVariable long authorId){

    }

    // 4. PUT http://localhost:3002/authors/{authorsId} (+payload)


    // 5. DELETE http://localhost:3002/authors/{authorsId}
}
