package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;


@ToString
@Getter
@AllArgsConstructor
public class Aluno {
    private String name;
    private Set<String> turmas;
}
