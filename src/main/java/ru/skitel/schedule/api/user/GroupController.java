package ru.skitel.schedule.api.user;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skitel.schedule.modules.group.Group;
import ru.skitel.schedule.modules.group.GroupService;
import ru.skitel.schedule.security.role.PermissionService;
import ru.skitel.schedule.security.role.Role;
import ru.skitel.schedule.security.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final PermissionService permissionService;
    private final UserService userService;

    @GetMapping("/groups")
    public List<Group> getAll(Authentication authentication){
        if(authentication.getAuthorities().stream().toList().getFirst().getAuthority().equals(Role.ADMIN.name())){
            return groupService.getAll();
        }
        var user = userService.findByEmail(authentication.getName());

        return groupService.findByUserId(user.getId());
    }

    @GetMapping("/group/{groupNumber}")
    public Group getGroupByNumber(@PathVariable String groupNumber){
        return groupService.findByNumber(groupNumber);
    }

    @GetMapping("/group/id/{groupId}")
    public Group getGroupById(@PathVariable int groupId){
        return groupService.findById(groupId);
    }
}
