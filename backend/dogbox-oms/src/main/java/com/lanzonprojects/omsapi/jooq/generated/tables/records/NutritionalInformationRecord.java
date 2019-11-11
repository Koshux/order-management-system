/**
 * This class is generated by jOOQ
 */
package com.lanzonprojects.omsapi.jooq.generated.tables.records;


import com.lanzonprojects.omsapi.jooq.generated.tables.NutritionalInformation;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class NutritionalInformationRecord extends UpdatableRecordImpl<NutritionalInformationRecord> implements Record8<Integer, String, String, String, String, String, Integer, Integer> {

	private static final long serialVersionUID = -352429285;

	/**
	 * Setter for <code>dogbox_oms.nutritional_information.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>dogbox_oms.nutritional_information.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>dogbox_oms.nutritional_information.kcal_per_hundred</code>.
	 */
	public void setKcalPerHundred(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>dogbox_oms.nutritional_information.kcal_per_hundred</code>.
	 */
	public String getKcalPerHundred() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>dogbox_oms.nutritional_information.percentage_meat</code>.
	 */
	public void setPercentageMeat(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>dogbox_oms.nutritional_information.percentage_meat</code>.
	 */
	public String getPercentageMeat() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>dogbox_oms.nutritional_information.percentage_protein</code>.
	 */
	public void setPercentageProtein(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>dogbox_oms.nutritional_information.percentage_protein</code>.
	 */
	public String getPercentageProtein() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>dogbox_oms.nutritional_information.percentage_fat</code>.
	 */
	public void setPercentageFat(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>dogbox_oms.nutritional_information.percentage_fat</code>.
	 */
	public String getPercentageFat() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>dogbox_oms.nutritional_information.percentage_carbs</code>.
	 */
	public void setPercentageCarbs(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>dogbox_oms.nutritional_information.percentage_carbs</code>.
	 */
	public String getPercentageCarbs() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>dogbox_oms.nutritional_information.product_id</code>.
	 */
	public void setProductId(Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>dogbox_oms.nutritional_information.product_id</code>.
	 */
	public Integer getProductId() {
		return (Integer) getValue(6);
	}

	/**
	 * Setter for <code>dogbox_oms.nutritional_information.ingredient_id</code>.
	 */
	public void setIngredientId(Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>dogbox_oms.nutritional_information.ingredient_id</code>.
	 */
	public Integer getIngredientId() {
		return (Integer) getValue(7);
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
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, String, Integer, Integer> fieldsRow() {
		return (Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, String, Integer, Integer> valuesRow() {
		return (Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return NutritionalInformation.NUTRITIONAL_INFORMATION.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return NutritionalInformation.NUTRITIONAL_INFORMATION.KCAL_PER_HUNDRED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return NutritionalInformation.NUTRITIONAL_INFORMATION.PERCENTAGE_MEAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return NutritionalInformation.NUTRITIONAL_INFORMATION.PERCENTAGE_PROTEIN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return NutritionalInformation.NUTRITIONAL_INFORMATION.PERCENTAGE_FAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return NutritionalInformation.NUTRITIONAL_INFORMATION.PERCENTAGE_CARBS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field7() {
		return NutritionalInformation.NUTRITIONAL_INFORMATION.PRODUCT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field8() {
		return NutritionalInformation.NUTRITIONAL_INFORMATION.INGREDIENT_ID;
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
		return getKcalPerHundred();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getPercentageMeat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getPercentageProtein();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getPercentageFat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getPercentageCarbs();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value7() {
		return getProductId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value8() {
		return getIngredientId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord value2(String value) {
		setKcalPerHundred(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord value3(String value) {
		setPercentageMeat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord value4(String value) {
		setPercentageProtein(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord value5(String value) {
		setPercentageFat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord value6(String value) {
		setPercentageCarbs(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord value7(Integer value) {
		setProductId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord value8(Integer value) {
		setIngredientId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NutritionalInformationRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, Integer value7, Integer value8) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached NutritionalInformationRecord
	 */
	public NutritionalInformationRecord() {
		super(NutritionalInformation.NUTRITIONAL_INFORMATION);
	}

	/**
	 * Create a detached, initialised NutritionalInformationRecord
	 */
	public NutritionalInformationRecord(Integer id, String kcalPerHundred, String percentageMeat, String percentageProtein, String percentageFat, String percentageCarbs, Integer productId, Integer ingredientId) {
		super(NutritionalInformation.NUTRITIONAL_INFORMATION);

		setValue(0, id);
		setValue(1, kcalPerHundred);
		setValue(2, percentageMeat);
		setValue(3, percentageProtein);
		setValue(4, percentageFat);
		setValue(5, percentageCarbs);
		setValue(6, productId);
		setValue(7, ingredientId);
	}
}