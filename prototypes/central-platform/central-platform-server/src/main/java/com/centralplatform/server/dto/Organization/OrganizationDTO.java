package com.centralplatform.server.dto.Organization;

import com.centralplatform.server.model.Location.Location;
import com.centralplatform.server.model.Organization.OrganizationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class OrganizationDTO {
     String name;

     OrganizationType organizationType;

     List<Location> locations;
}
