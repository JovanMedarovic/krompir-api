package com.dragacevoshop.krompirApi.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String customerName;
    private String customerEmail;
    private String address;
    private String phone;
    private String city;
    private String comment;
    private List<OrderItemRequest> items;
}