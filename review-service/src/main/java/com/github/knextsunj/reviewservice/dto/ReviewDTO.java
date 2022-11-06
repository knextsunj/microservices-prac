package com.github.knextsunj.reviewservice.dto;

public record ReviewDTO(long id,long productId,String author,String subject,String content) {
}
