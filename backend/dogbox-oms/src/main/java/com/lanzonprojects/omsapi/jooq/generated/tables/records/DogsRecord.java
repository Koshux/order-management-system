/**
 * This class is generated by jOOQ
 */
package com.lanzonprojects.omsapi.jooq.generated.tables.records;


import com.lanzonprojects.omsapi.jooq.generated.tables.Dogs;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class DogsRecord extends UpdatableRecordImpl<DogsRecord> implements Record5<Integer, String, Integer, String, Integer> {

	private static final long serialVersionUID = -1425842275;

	/**
	 * Setter for <code>dogbox_oms.dogs.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>dogbox_oms.dogs.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>dogbox_oms.dogs.age</code>.
	 */
	public void setAge(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>dogbox_oms.dogs.age</code>.
	 */
	public String getAge() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>dogbox_oms.dogs.limitCalories</code>.
	 */
	public void setLimitcalories(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>dogbox_oms.dogs.limitCalories</code>.
	 */
	public Integer getLimitcalories() {
		return (Integer) getValue(2);
	}

	/**
	 * Setter for <code>dogbox_oms.dogs.NAME</code>.
	 */
	public void setName(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>dogbox_oms.dogs.NAME</code>.
	 */
	public String getName() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>dogbox_oms.dogs.breed_id</code>.
	 */
	public void setBreedId(Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>dogbox_oms.dogs.breed_id</code>.
	 */
	public Integer getBreedId() {
		return (Integer) getValue(4);
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
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, String, Integer, String, Integer> fieldsRow() {
		return (Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, String, Integer, String, Integer> valuesRow() {
		return (Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Dogs.DOGS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Dogs.DOGS.AGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return Dogs.DOGS.LIMITCALORIES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Dogs.DOGS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field5() {
		return Dogs.DOGS.BREED_ID;
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
		return getAge();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getLimitcalories();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value5() {
		return getBreedId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DogsRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DogsRecord value2(String value) {
		setAge(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DogsRecord value3(Integer value) {
		setLimitcalories(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DogsRecord value4(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DogsRecord value5(Integer value) {
		setBreedId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DogsRecord values(Integer value1, String value2, Integer value3, String value4, Integer value5) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached DogsRecord
	 */
	public DogsRecord() {
		super(Dogs.DOGS);
	}

	/**
	 * Create a detached, initialised DogsRecord
	 */
	public DogsRecord(Integer id, String age, Integer limitcalories, String name, Integer breedId) {
		super(Dogs.DOGS);

		setValue(0, id);
		setValue(1, age);
		setValue(2, limitcalories);
		setValue(3, name);
		setValue(4, breedId);
	}
}
