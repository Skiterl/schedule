package ru.skitel.schedule.modules.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skitel.schedule.modules.subject.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
