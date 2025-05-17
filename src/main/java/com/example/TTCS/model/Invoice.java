package com.example.TTCS.model;
import com.example.TTCS.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "invoice_number", unique = true, nullable = false)
    private String invoiceNumber;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    private Double tax;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceStatus status = InvoiceStatus.ISSUED;
}
