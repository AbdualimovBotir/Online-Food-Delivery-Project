package com.botir.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class AddCartItemRequest {
    private Long foodId;
    private int quentity;
    private List<String> ingredients;
}
