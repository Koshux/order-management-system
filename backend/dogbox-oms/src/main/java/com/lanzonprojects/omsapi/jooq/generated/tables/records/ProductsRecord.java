/**
 * This class is generated by jOOQ
 */
package com.lanzonprojects.omsapi.jooq.generated.tables.records;


import com.lanzonprojects.omsapi.jooq.generated.tables.Products;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProductsRecord extends UpdatableRecordImpl<ProductsRecord> implements Record11<Integer, String, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer> {

	private static final long serialVersionUID = 894418268;

	/**
	 * Setter for <code>dogbox_oms.products.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>dogbox_oms.products.NAME</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.NAME</code>.
	 */
	public String getName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>dogbox_oms.products.brand</code>.
	 */
	public void setBrand(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.brand</code>.
	 */
	public String getBrand() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>dogbox_oms.products.weight</code>.
	 */
	public void setWeight(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.weight</code>.
	 */
	public String getWeight() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>dogbox_oms.products.sku</code>.
	 */
	public void setSku(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.sku</code>.
	 */
	public String getSku() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>dogbox_oms.products.size_id</code>.
	 */
	public void setSizeId(Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.size_id</code>.
	 */
	public Integer getSizeId() {
		return (Integer) getValue(5);
	}

	/**
	 * Setter for <code>dogbox_oms.products.flavour_id</code>.
	 */
	public void setFlavourId(Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.flavour_id</code>.
	 */
	public Integer getFlavourId() {
		return (Integer) getValue(6);
	}

	/**
	 * Setter for <code>dogbox_oms.products.product_type_id</code>.
	 */
	public void setProductTypeId(Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.product_type_id</code>.
	 */
	public Integer getProductTypeId() {
		return (Integer) getValue(7);
	}

	/**
	 * Setter for <code>dogbox_oms.products.financial_info_id</code>.
	 */
	public void setFinancialInfoId(Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.financial_info_id</code>.
	 */
	public Integer getFinancialInfoId() {
		return (Integer) getValue(8);
	}

	/**
	 * Setter for <code>dogbox_oms.products.nutritional_info_id</code>.
	 */
	public void setNutritionalInfoId(Integer value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.nutritional_info_id</code>.
	 */
	public Integer getNutritionalInfoId() {
		return (Integer) getValue(9);
	}

	/**
	 * Setter for <code>dogbox_oms.products.suitability_info_id</code>.
	 */
	public void setSuitabilityInfoId(Integer value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>dogbox_oms.products.suitability_info_id</code>.
	 */
	public Integer getSuitabilityInfoId() {
		return (Integer) getValue(10);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record11 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row11<Integer, String, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
		return (Row11) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row11<Integer, String, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer> valuesRow() {
		return (Row11) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Products.PRODUCTS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Products.PRODUCTS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Products.PRODUCTS.BRAND;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Products.PRODUCTS.WEIGHT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return Products.PRODUCTS.SKU;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return Products.PRODUCTS.SIZE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field7() {
		return Products.PRODUCTS.FLAVOUR_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field8() {
		return Products.PRODUCTS.PRODUCT_TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field9() {
		return Products.PRODUCTS.FINANCIAL_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field10() {
		return Products.PRODUCTS.NUTRITIONAL_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field11() {
		return Products.PRODUCTS.SUITABILITY_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getBrand();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getWeight();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getSku();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getSizeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value7() {
		return getFlavourId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value8() {
		return getProductTypeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value9() {
		return getFinancialInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value10() {
		return getNutritionalInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value11() {
		return getSuitabilityInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value3(String value) {
		setBrand(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value4(String value) {
		setWeight(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value5(String value) {
		setSku(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value6(Integer value) {
		setSizeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value7(Integer value) {
		setFlavourId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value8(Integer value) {
		setProductTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value9(Integer value) {
		setFinancialInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value10(Integer value) {
		setNutritionalInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord value11(Integer value) {
		setSuitabilityInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductsRecord values(Integer value1, String value2, String value3, String value4, String value5, Integer value6, Integer value7, Integer value8, Integer value9, Integer value10, Integer value11) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		value10(value10);
		value11(value11);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ProductsRecord
	 */
	public ProductsRecord() {
		super(Products.PRODUCTS);
	}

	/**
	 * Create a detached, initialised ProductsRecord
	 */
	public ProductsRecord(Integer id, String name, String brand, String weight, String sku, Integer sizeId, Integer flavourId, Integer productTypeId, Integer financialInfoId, Integer nutritionalInfoId, Integer suitabilityInfoId) {
		super(Products.PRODUCTS);

		setValue(0, id);
		setValue(1, name);
		setValue(2, brand);
		setValue(3, weight);
		setValue(4, sku);
		setValue(5, sizeId);
		setValue(6, flavourId);
		setValue(7, productTypeId);
		setValue(8, financialInfoId);
		setValue(9, nutritionalInfoId);
		setValue(10, suitabilityInfoId);
	}
}
