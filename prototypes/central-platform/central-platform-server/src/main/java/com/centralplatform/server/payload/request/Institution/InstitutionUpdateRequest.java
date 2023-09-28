package com.centralplatform.server.payload.request.Institution;

import com.centralplatform.server.model.Institution.Institution;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
public class InstitutionUpdateRequest extends InstitutionRequest {

    Institution institutionToUpdate;
}
