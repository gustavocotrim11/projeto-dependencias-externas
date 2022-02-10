import entities.Aluno;
import entities.ListaAluno;
import entities.Turma;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        ListaAluno listaAluno = new ListaAluno(new HashMap<>(Map.ofEntries(
                Map.entry(UUID.randomUUID(), new Aluno("Alexandre Martins", Set.of("Java"))),
                Map.entry(UUID.randomUUID(), new Aluno("Vitor Hugo Lima", Set.of("Java", "Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Esther Rodrigues", Set.of("Java", "Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Lavínia Cunha", Set.of("Java", "Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Natália Gomes", Set.of("Java", "Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Yago Ramos", Set.of("Java", "Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Letícia Cunha", Set.of("Java", "Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Srta. Ana Júlia Ramos", Set.of("Java", "Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Thomas Peixoto", Set.of("Java"))),
                Map.entry(UUID.randomUUID(), new Aluno("Thales Farias", Set.of("Java", "Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Nathan Nascimento", Set.of("Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Dra. Lavínia Lopes", Set.of("Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Luiz Miguel Azevedo", Set.of("Banco de dados"))),
                Map.entry(UUID.randomUUID(), new Aluno("Dra. Alana Porto", Set.of("Banco de dados")))
        )));

        Turma turmaJava = new Turma("Java", listaAluno.getListaAlunos().entrySet().stream()
                .filter(aluno -> aluno.getValue().toString().contains("Java"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, HashMap::new)));

        Turma turmaBancoDeDados = new Turma("Banco de dados", listaAluno.getListaAlunos().entrySet().stream()
                .filter(aluno -> aluno.getValue().toString().contains("Banco de dados"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, HashMap::new)));

        Set<Map.Entry<UUID, Aluno>> entrySet = listaAluno.getListaAlunos().entrySet();

        List<Map.Entry<UUID, Aluno>> list = new ArrayList<>(entrySet);

        list.sort(Comparator.comparing(aluno -> aluno.getValue().getName()));

        String fileToWritePath = "docs".concat(File.separator).concat("output.txt");
        File fileToWrite = FileUtils.getFile(fileToWritePath);

        List<String> lines = new ArrayList<>();
        lines.add("Turma " + turmaJava.getNome());
        lines.add("Total de alunos =  " + turmaJava.getAlunosDaTurma().size());
        lines.add("Lista de alunos da turma:");
        turmaJava.getAlunosDaTurma().forEach((key, value) -> lines.add(value.getName()));
        lines.add("");
        lines.add("Turma " + turmaBancoDeDados.getNome());
        lines.add("Total de alunos =  " + turmaBancoDeDados.getAlunosDaTurma().size());
        lines.add("Lista de alunos da turma:");
        turmaBancoDeDados.getAlunosDaTurma().forEach((key, value) -> lines.add(value.getName()));
        lines.add("");
        lines.add("Lista geral ordenada de alunos:");
        list.forEach(aluno -> lines.add(aluno.getValue().getName()));

        FileUtils.writeLines(fileToWrite, lines, true);

        LineIterator it = FileUtils.lineIterator(fileToWrite);
        while (it.hasNext()) {
            System.out.println(it.next());

        }
    }
}
