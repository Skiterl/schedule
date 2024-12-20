package ru.skitel.schedule.modules.subject;

import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {
    public Subject convertToSubject(SubjectRequest request){
        return Subject.builder()
                .name(request.name())
                .type(request.type()).build();
    }
}
