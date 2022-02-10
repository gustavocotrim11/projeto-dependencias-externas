package entities;

import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.UUID;


@Data
public class ListaAluno {
    @NonNull private HashMap<UUID, Aluno> listaAlunos;
}
