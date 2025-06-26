package com.dragacevoshop.krompirApi.utils;

import com.dragacevoshop.krompirApi.models.Order;
import com.dragacevoshop.krompirApi.models.OrderItem;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFormatter {

    public static String formatOrder(Order order) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#0.00");

        LocalDateTime date = LocalDateTime.now(); // or any LocalDate.of(2025, 6, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
        String formattedDate = date.format(formatter);

        System.out.println("Formatted date: " + formattedDate);

        sb.append("Kupac:   ").append(order.getCustomerName()).append("\n");
        sb.append("Grad:    ").append(order.getCustomerEmail()).append("\n");
        sb.append("Adresa:  ").append(order.getCustomerEmail()).append("\n");
        sb.append("Telefon: ").append(order.getCustomerEmail()).append("\n");
        sb.append("Email:   ").append(order.getCustomerEmail()).append("\n");
        sb.append("Datum:   ").append(formattedDate).append("\n");
        sb.append("Porudžbina:\n");

        double grandTotal = 0;

        for (OrderItem item : order.getItems()) {
            String name = item.getProduct().getName();
            float unitPrice = item.getProduct().getPrice();
            int quantity = item.getQuantity();
            String unit = item.getProduct().getUnit();
            double total = unitPrice * quantity;
            grandTotal += total;

            sb.append(name)
                    .append("\tCena: ").append(df.format(unitPrice))
                    .append("\tKoličina: ").append(quantity).append(" ").append(unit)
                    .append("\tUkupno ").append(df.format(total))
                    .append("\n");
        }

        sb.append("Ukupno: ").append(df.format(grandTotal));
        return sb.toString();
    }
}
