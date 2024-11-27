package jp.co.hoge.web.controller.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class updateForm {

	
	@NotNull(message = "{UpdateProductsId}")
	private Integer UpdateProductsId;
	@NotNull(message = "{UpdateProductsUnits}")
	private Integer UpdateProductsUnits;
	@NotEmpty(message = "{UpdateProductsName}")
	private String UpdateProductsName;
	
	
	public Integer getUpdateProductsId() {
		return UpdateProductsId;
	}
	public void setUpdateProductsId(Integer updateProductsId) {
		UpdateProductsId = updateProductsId;
	}
	public Integer getUpdateProductsUnits() {
		return UpdateProductsUnits;
	}
	public void setUpdateProductsUnits(Integer updateProductsUnits) {
		UpdateProductsUnits = updateProductsUnits;
	}
	public String getUpdateProductsName() {
		return UpdateProductsName;
	}
	public void setUpdateProductsName(String updateProductsName) {
		UpdateProductsName = updateProductsName;
	}
	
}
