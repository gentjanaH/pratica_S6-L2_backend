package gentjanahani.u2w6d2.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class NewAuthorPayload {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;

}
