package gentjanahani.u2w6d2.services;

import gentjanahani.u2w6d2.entities.Authors;
import gentjanahani.u2w6d2.payloads.NewAuthorPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthorsService {

    List<Authors> allAuthors=new ArrayList<>();

    //metodo find
public List<Authors>findAllAuthors(){
    return this.allAuthors;
}

    //metodo save
    public Authors saveAuthors(NewAuthorPayload payload){
        Authors newAuthor = new Authors(payload.getNome(), payload.getCognome(),
                payload.getEmail(), payload.getDataDiNascita());
        this.allAuthors.add(newAuthor);
        log.info("L' autore " + newAuthor.getIdAutore() + " è stato aggiunto correttamente");
        return newAuthor;

    }

    //metodo getById
    public Authors getAuthorsById(long authorId){
    
    }
}
