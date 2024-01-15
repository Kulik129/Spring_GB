package ru.gb;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Student> getAllSt() {
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public Student getUser(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping
    public Student get(@RequestParam String name) {
        return repository.getByName(name);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable long id, @RequestBody Student student) {
        Student st = repository.getById(id);
        Student stud = repository.getById(id);
        stud.setName(student.getName());
        return st;
    }
    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        Student studentAdd = new Student(student.getName(), student.getGroupName());
        repository.add(studentAdd);
        return student;
    }

    @DeleteMapping("/{id}")
    public List<Student> deleteSt(@PathVariable long id) {
        repository.delete(id);
        return repository.getAll();
    }
}
