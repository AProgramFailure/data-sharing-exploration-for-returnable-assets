package com.centralplatform.server.dto.Location;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDTO {

    private String name;
    private String address;
    private String latitude;
    private String longitude;

}
