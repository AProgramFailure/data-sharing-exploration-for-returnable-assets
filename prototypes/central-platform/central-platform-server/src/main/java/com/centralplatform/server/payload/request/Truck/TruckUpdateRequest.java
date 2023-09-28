package com.centralplatform.server.payload.request.Truck;

import com.centralplatform.server.model.Truck.Truck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TruckUpdateRequest extends TruckRequest {

    Truck truck;
}
