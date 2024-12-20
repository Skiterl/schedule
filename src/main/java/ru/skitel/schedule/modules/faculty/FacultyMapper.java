package ru.skitel.schedule.modules.faculty;

import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {
    public Faculty convertToFaculty(FacultyRequest request){
        return Faculty.builder()
                .facultyName(request.facultyName())
                .abbreviation(request.abbreviation()).build();
    }
}
