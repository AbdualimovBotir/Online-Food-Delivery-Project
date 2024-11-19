package com.botir.request;

import com.botir.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Long restaurantId;
    private Address deliveryAddress;
}
