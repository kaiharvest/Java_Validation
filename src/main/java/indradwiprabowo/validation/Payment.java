package indradwiprabowo.validation;

import indradwiprabowo.validation.constraint.CheckOrderId;
import indradwiprabowo.validation.groub.CreditCardPaymentGroup;
import indradwiprabowo.validation.groub.VirtualAccountPaymentGroup;
import indradwiprabowo.validation.payload.EmailErrorPayload;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "amount can not null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            min = 10_000, max = 100_000_000, message = "{order.amount.range}")
    private Long amount;

    @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "credit card can not blank")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "invalid credit card number", payload = {EmailErrorPayload.class})
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account can not blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},
            message = "customer can not null")
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    private Customer customers;

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customers=" + customers +
                '}';
    }
}
