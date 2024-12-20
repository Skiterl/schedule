package ru.skitel.schedule.api.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skitel.schedule.modules.group.GroupService;
import ru.skitel.schedule.modules.record.ScheduleRecord;
import ru.skitel.schedule.modules.record.ScheduleRecordRequest;
import ru.skitel.schedule.modules.record.ScheduleRecordService;
import ru.skitel.schedule.modules.subgroup.SubgroupService;
import ru.skitel.schedule.modules.subject.SubjectService;
import ru.skitel.schedule.modules.teacher.Teacher;
import ru.skitel.schedule.modules.teacher.TeacherService;
import ru.skitel.schedule.security.role.Constants;
import ru.skitel.schedule.security.role.PermissionService;
import ru.skitel.schedule.security.role.Role;
import ru.skitel.schedule.security.user.UserService;

import java.nio.file.Path;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class ScheduleRecordController {
    private final ScheduleRecordService scheduleRecordService;
    private final PermissionService permissionService;
    private final UserService userService;
    private final SubgroupService subgroupService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final GroupService groupService;

    @GetMapping("/schedule_records/{groupId}")
    @PreAuthorize("@Role.ADMIN.name().equals(authentication.getAuthorities().stream().toList().getFirst().getAuthority()) || @PermissionService.includePermissionByEmailAndGroupId(#authentication.getName(), #groupId, @Permission.READ)")
    public List<ScheduleRecord> getAllByAuthorization(Authentication authentication, @PathVariable int groupId){
        return scheduleRecordService.findByGroupId(groupId);
    }
//@Role.ADMIN.name().equals(authentication.getAuthorities().stream().toList().getFirst()) ||
    @PostMapping("/schedule_record")
    @PreAuthorize("@Role.ADMIN.name().equals(authentication.getAuthorities().stream().toList().getFirst().getAuthority()) || @PermissionService.includePermissionByEmailAndSubgroupId(#authentication.getName(), #request.subgroup_id(), @Permission.EDIT)")
    public void addScheduleRecord(Authentication authentication, @RequestBody ScheduleRecordRequest request){
        var subgroup = subgroupService.findById(request.subgroup_id());
        var subject = subjectService.findById(request.subject_id());
        var teacher = teacherService.findById(request.teacher_id());
        log.info(authentication.getAuthorities().toString());

        var scheduleRecord = ScheduleRecord.builder()
                .dayWeek(request.dayWeek())
                .classroom(request.classroom())
                .parity(request.parity())
                .timeStart(request.timeStart())
                .timeEnd(request.timeEnd())
                .subgroup(subgroup)
                .teacher(teacher)
                .subject(subject)
                .build();

        scheduleRecordService.insert(scheduleRecord);
    }

    @GetMapping("/schedule_records/subgroup/{subgroupId}")
    public List<ScheduleRecord> getBySubgroupId(@PathVariable int subgroupId){
        return scheduleRecordService.findBySubgroupId(subgroupId);
    }


}
