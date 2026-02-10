package gentjanahani.u2w6d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@ToString
public class Authors {
    private long idAutore;
    private String name;
    private String surname;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    public Authors(String name, String surname, String email, LocalDate dataDiNascita){
        Random random=new Random();
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.dataDiNascita=dataDiNascita;
        this.idAutore=random.nextInt(1, 10000);
        this.avatar = "https://ui-avatars.com/api/?name=" + getName() + "+" + getSurname();


    }

}
