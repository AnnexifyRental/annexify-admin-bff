package com.anuradha.annexifyadminbff.dto;

import java.util.List;

public record PostImageSaveDto(
        String id,
        String thumbnail,
        List<String> images
) {
}
