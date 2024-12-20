package ru.skitel.schedule.security.role;

import jakarta.persistence.*;
import lombok.*;
import ru.skitel.schedule.modules.group.Group;
import ru.skitel.schedule.security.user.User;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, nullable = false)
    private PermissionType type;
}
