package com.anuradha.annexifyadminbff.controller.outbound;

import com.anuradha.annexifyadminbff.dto.FilterDto;
import com.anuradha.annexifyadminbff.dto.IdResponseDto;
import com.anuradha.annexifyadminbff.dto.PostDto;
import com.anuradha.annexifyadminbff.dto.PostImageSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CentralServiceClient {

    private final RestTemplate restTemplate;

    @Value("${annexify.service.central.url}")
    private String baseUrl;

    public IdResponseDto savePost(PostDto postDto) {
        return restTemplate.postForObject(baseUrl + "/post", postDto, IdResponseDto.class);
    }

    public List<PostDto> findAllPosts(FilterDto filter) {
        ResponseEntity<List<PostDto>> response = restTemplate.exchange(
                baseUrl + "/post/filter",
                HttpMethod.POST,
                new HttpEntity<>(filter),
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public void deletePost(String id) {
        restTemplate.delete(baseUrl + "/post?id=" + id);
    }

    public void uploadPostImages(String id, String thumbnailUrl, List<String> imageUrls) {
        restTemplate.put(baseUrl + "/post/images", new PostImageSaveDto(id, thumbnailUrl, imageUrls));
    }

    public PostDto findById(String id) {
        return restTemplate.getForObject(baseUrl + "/post/by/id?id=" + id, PostDto.class);
    }
}
