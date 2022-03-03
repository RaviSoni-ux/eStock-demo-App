package com.iiht.eStockMarket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "companies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	
	@Id
    private String id;
	
	@NotNull(message="Please provide a company code must be unique.")
    @Size(max = 10)
    @Indexed(unique = true)
	private String companyCode;
	
	@NotNull(message="Please provide a company Name.")
	private String companyName;
	
	@NotNull(message="Please provide a company CEO Name.")
	private String companyCEO;
	
	@NotNull(message="Please add  company Turnover .")
	private long companyTurnover;
	
	@NotNull(message="Please add company website .")
	private String companyWebsite;
	
	@NotNull(message="Please select  a company StockExchange .")
	private String stockExchange;
	
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    @NotNull(message="Please provide a date whit the format dd-MM-yyyy HH:mm")
	private LocalDateTime date;
   ////https://www.javaguides.net/2019/12/spring-boot-mongodb-crud-example-tutorial.html

}
