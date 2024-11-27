package jp.co.hoge.web.controller.form;

import jakarta.validation.constraints.NotNull;

public class deleteForm {

	@NotNull(message = "{deleteProductsId}")
	private Integer deleteProductsId;

	public Integer getDeleteProductsId() {
		return deleteProductsId;
	}

	public void setDeleteProductsId(Integer deleteProductsId) {
		this.deleteProductsId = deleteProductsId;
	}
}
