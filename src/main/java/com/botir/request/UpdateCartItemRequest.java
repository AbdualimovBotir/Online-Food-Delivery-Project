package com.botir.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCartItemRequest {
    private Long cartItemId;
    private int quentity;
}
