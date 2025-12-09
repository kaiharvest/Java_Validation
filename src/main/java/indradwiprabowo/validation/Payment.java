package indradwiprabowo.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    @NotBlank(message = "order id can not blank")
    private String orderId;

    @NotNull(message = "amount can not null")
    @Range(min = 10_000, max = 100_000_000, message = "amount must between 10.000 and 100.000.000")
    private Long amount;

    @NotBlank(message = "credit card can not blank")
    @LuhnCheck(message = "invalid credit card number")
    private String creditCard;

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
                '}';
    }

}
