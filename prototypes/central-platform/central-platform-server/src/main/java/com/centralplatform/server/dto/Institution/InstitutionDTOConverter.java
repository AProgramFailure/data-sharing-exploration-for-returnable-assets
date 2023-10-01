package com.centralplatform.server.dto.Institution;

import com.centralplatform.server.model.Institution.Institution;
import com.centralplatform.server.util.Converters.GenericConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class InstitutionDTOConverter implements GenericConverter<Institution, InstitutionDTO> {
    @Override
    public InstitutionDTO apply(Institution institution) {
        InstitutionDTO dto = new InstitutionDTO();
        dto.setName(institution.getName());
        return dto;
    }

    @Override
    public <V> Function<V, InstitutionDTO> compose(Function<? super V, ? extends Institution> before) {
        return GenericConverter.super.compose(before);
    }

    @Override
    public <V> Function<Institution, V> andThen(Function<? super InstitutionDTO, ? extends V> after) {
        return GenericConverter.super.andThen(after);
    }

    @Override
    public InstitutionDTO convert(Institution input) {
        return GenericConverter.super.convert(input);
    }

    @Override
    public List<InstitutionDTO> convert(List<Institution> input) {
        return GenericConverter.super.convert(input);
    }
}
