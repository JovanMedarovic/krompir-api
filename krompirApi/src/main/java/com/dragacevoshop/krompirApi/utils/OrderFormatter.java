package com.dragacevoshop.krompirApi.utils;

import com.dragacevoshop.krompirApi.models.Order;
import com.dragacevoshop.krompirApi.models.OrderItem;

import java.text.DecimalFormat;

public class OrderFormatter {

    public static String formatOrder(Order order) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#0.00");

        sb.append("Name: ").append(order.getCustomerName()).append("\n");
        sb.append("Email: ").append(order.getCustomerEmail()).append("\n");
        sb.append("Products:\n");

        double grandTotal = 0;

        for (OrderItem item : order.getItems()) {
            String name = item.getProduct().getName();
            float unitPrice = item.getProduct().getPrice();
            int quantity = item.getQuantity();
            String unit = item.getProduct().getUnit();
            double total = unitPrice * quantity;
            grandTotal += total;

            sb.append(name)
                    .append("... Unit Price: ").append(df.format(unitPrice))
                    .append(".... Count: ").append(quantity).append(" ").append(unit)
                    .append("........ Total ").append(df.format(total))
                    .append("\n");
        }

        sb.append("Total: ").append(df.format(grandTotal));
        return sb.toString();
    }
}
