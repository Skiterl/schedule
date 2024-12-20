package ru.skitel.schedule.modules.faculty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService{
    private final FacultyRepository facultyRepository;
    @Override
    public Faculty insert(Faculty entity) {
        return facultyRepository.save(entity);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public Faculty findById(int facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow();
    }
}
