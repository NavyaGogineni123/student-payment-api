package net.navya.springtest.serivce;

import net.navya.springtest.dao.PaymentDao;
import net.navya.springtest.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentDao paymentDao;
    public List<Payment> getPaymentMethodsByStudent(int studentId) {
        return paymentDao.getById(studentId);

    }


    public List<Payment> getPaymentMethodsByStudentName(String name) {
        //return paymentDao.getPaymentsByName(name);
        return paymentDao.getPaymentsByNameFixSqlInjection(name);
    }
}
