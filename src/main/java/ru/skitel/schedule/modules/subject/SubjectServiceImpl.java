package ru.skitel.schedule.modules.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    @Override
    public Subject insert(Subject entity) {
        return subjectRepository.save(entity);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject findById(int id) {
        return subjectRepository.findById(id).orElseThrow();
    }
}
