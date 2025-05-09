package com.cookmates.backend.dto;

import com.cookmates.backend.model.Favorite;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteDTO {
    private Long id;
    private Long recipeId;
    private Long userId;


    public static FavoriteDTO toFavoriteDTO(Favorite favorite){
        return FavoriteDTO.builder()
                .id(favorite.getId())
                .userId(favorite.getUser().getId())
                .recipeId(favorite.getRecipe().getId())
                .build();
    }
}
