package com.centralplatform.server.model.UserAssignOrganizationRequest;

import com.centralplatform.server.model.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_assign_organization_request")
public class UserAssignOrganizationRequest {

    @Id
    @UuidGenerator
    private UUID id;
    @ManyToOne
    @JsonBackReference(value = "user-asign-organization-requests")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String organizationId;
    private Date registeredAt;

    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;


}
