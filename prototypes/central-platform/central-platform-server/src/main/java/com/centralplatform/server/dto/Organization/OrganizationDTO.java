package com.centralplatform.server.dto.Organization;

import com.centralplatform.server.model.Organization.OrganizationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizationDTO {
    private String name;

    private OrganizationType organizationType;

}
