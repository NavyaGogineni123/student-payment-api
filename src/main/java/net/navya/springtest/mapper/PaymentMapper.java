package net.navya.springtest.mapper;

import net.navya.springtest.model.Payment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

@Component
public class PaymentMapper implements RowMapper<Payment> {

    @Override
    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        int paymentId = rs.getInt("payment_id");
        int studentId = rs.getInt("student_id");
        String cardNumber = rs.getString("card_number");
        LocalDate expiryDate = rs.getDate("expiry_date").toLocalDate();
        String cvv = rs.getString("cvv");
        String cardholderName = rs.getString("cardholder_name");
        String billingAddress = rs.getString("billing_address");
        BigDecimal paymentAmount = rs.getBigDecimal("payment_amount");
        Date paymentDate = rs.getDate("payment_date");

        Payment payment = new Payment(paymentId, studentId, cardNumber, expiryDate, cvv, cardholderName, billingAddress, paymentAmount, paymentDate);

        return payment;
    }
}
