package com.didi.quizapp.authentications.shared.utils;

import com.didi.quizapp.authentications.shared.dto.MetaDataDTO;
import org.springframework.data.domain.Page;

public class Utils {
    public static MetaDataDTO setMetaDataFromEntityPage(Page<?> entity) {
        MetaDataDTO metaDataDTO = new MetaDataDTO();
        metaDataDTO.setCount(entity.getContent().size());
        metaDataDTO.setPage(entity.getNumber());
        metaDataDTO.setSize(entity.getSize());
        metaDataDTO.setTotalCount(entity.getNumberOfElements());
        metaDataDTO.setTotalPages(entity.getTotalPages());
        return metaDataDTO;
    }
}
