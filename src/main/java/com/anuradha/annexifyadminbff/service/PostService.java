package com.anuradha.annexifyadminbff.service;

import com.anuradha.annexifyadminbff.controller.outbound.CentralServiceClient;
import com.anuradha.annexifyadminbff.dto.FilterDto;
import com.anuradha.annexifyadminbff.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final CentralServiceClient centralServiceClient;

    public List<PostDto> findAll(FilterDto filter) {
        return centralServiceClient.findAllPosts(filter);
    }

    public PostDto findById(String id) {
        return centralServiceClient.findById(id);
    }
}
