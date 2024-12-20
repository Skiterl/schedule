package ru.skitel.schedule.api.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skitel.schedule.modules.subgroup.Subgroup;
import ru.skitel.schedule.modules.subgroup.SubgroupService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class SubgroupController {
    private final SubgroupService subgroupService;

    @GetMapping("/subgroups")
    public List<Subgroup> getAll(Authentication authentication){
        log.info("{} {}", authentication.getName(), authentication.getAuthorities());
        return subgroupService.getAll();
    }

    @GetMapping("subgroups/{groupId}")
    public List<Subgroup> getSubgroupsByGroupId(@PathVariable int groupId){
        return subgroupService.findByGroupId(groupId);
    }
}
