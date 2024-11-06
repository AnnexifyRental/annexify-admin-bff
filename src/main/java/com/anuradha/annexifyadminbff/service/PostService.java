package com.anuradha.annexifyadminbff.service;

import com.anuradha.annexifyadminbff.controller.outbound.CentralServiceClient;
import com.anuradha.annexifyadminbff.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final CentralServiceClient centralServiceClient;

    public List<PostDto> findAll() {
        return centralServiceClient.findAllPosts();
    }

}
