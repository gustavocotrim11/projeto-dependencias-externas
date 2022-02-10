package entities;

import lombok.*;

import java.util.HashMap;
import java.util.UUID;

@AllArgsConstructor
@ToString
public class Turma {
    @Getter
    private String nome;
    @Setter @Getter
    private HashMap<UUID, Aluno> alunosDaTurma;
}
