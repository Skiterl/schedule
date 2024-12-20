package ru.skitel.schedule.modules.group;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ru.skitel.schedule.modules.faculty.Faculty;

public record GroupRequest (String number, String direction, String profile, int facultyId){
}
