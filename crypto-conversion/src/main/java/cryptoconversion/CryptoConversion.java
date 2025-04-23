package cryptoconversion;


import java.math.BigDecimal;

public class CryptoConversion {

    // isti atributi kao u CryptoExchange klasi
	private String from;
	private String to;
	private BigDecimal toValue;
	private String environment;

	// atributi specificni samo za CryptoConversion klasu
	private BigDecimal conversionTotal;
	private Double quantity;
    
    public CryptoConversion() {
    }

    public CryptoConversion(String from, String to, BigDecimal toValue, String environment,
            BigDecimal conversionTotal, Double quantity) {
        this.from = from;
        this.to = to;
        this.toValue = toValue;
        this.environment = environment;
        this.conversionTotal = conversionTotal;
        this.quantity = quantity;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getToValue() {
        return toValue;
    }

    public void setToValue(BigDecimal toValue) {
        this.toValue = toValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public BigDecimal getConversionTotal() {
        return conversionTotal;
    }

    public void setConversionTotal(BigDecimal conversionTotal) {
        this.conversionTotal = conversionTotal;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
     
}
