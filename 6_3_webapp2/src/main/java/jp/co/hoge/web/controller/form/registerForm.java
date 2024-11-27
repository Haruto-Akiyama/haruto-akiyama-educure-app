package jp.co.hoge.web.controller.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class registerForm {
	
	@NotNull(message = "{productsId}")
	private Integer productsId;
	@NotNull(message = "{productsUnits}")
	private Integer productsUnits;
	@NotEmpty(message = "{productsName}")
	private String productsName;
	
	
	public Integer getProductsId() {
		return productsId;
	}
	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
	}
	public Integer getProductsUnits() {
		return productsUnits;
	}
	public void setProductsUnits(Integer productsUnits) {
		this.productsUnits = productsUnits;
	}
	public String getProductsName() {
		return productsName;
	}
	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}
	
}
