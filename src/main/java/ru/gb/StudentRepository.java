package ru.gb;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Dmitrii", "Физ тех"));
        students.add(new Student("Igor", "Информатика"));
        students.add(new Student("Katerina", "Биология"));
        students.add(new Student("Irina", "Математика"));
        students.add(new Student("Ludmila", "География"));
    }

    public void delete(long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void add(Student student) {
        students.add(new Student(student.getName(), student.getGroupName()));
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst().orElse(null);
    }

    public Student getByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst().orElse(null);
    }
}
