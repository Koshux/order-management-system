/**
 * This class is generated by jOOQ
 */
package com.lanzonprojects.omsapi.jooq.generated.tables.records;


import com.lanzonprojects.omsapi.jooq.generated.tables.Breeds;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class BreedsRecord extends UpdatableRecordImpl<BreedsRecord> implements Record3<Integer, String, Integer> {

	private static final long serialVersionUID = -624750456;

	/**
	 * Setter for <code>dogbox_oms.breeds.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>dogbox_oms.breeds.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>dogbox_oms.breeds.NAME</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>dogbox_oms.breeds.NAME</code>.
	 */
	public String getName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>dogbox_oms.breeds.size_id</code>.
	 */
	public void setSizeId(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>dogbox_oms.breeds.size_id</code>.
	 */
	public Integer getSizeId() {
		return (Integer) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, String, Integer> fieldsRow() {
		return (Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, String, Integer> valuesRow() {
		return (Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Breeds.BREEDS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Breeds.BREEDS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return Breeds.BREEDS.SIZE_ID;
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
	public Integer value3() {
		return getSizeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BreedsRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BreedsRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BreedsRecord value3(Integer value) {
		setSizeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BreedsRecord values(Integer value1, String value2, Integer value3) {
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached BreedsRecord
	 */
	public BreedsRecord() {
		super(Breeds.BREEDS);
	}

	/**
	 * Create a detached, initialised BreedsRecord
	 */
	public BreedsRecord(Integer id, String name, Integer sizeId) {
		super(Breeds.BREEDS);

		setValue(0, id);
		setValue(1, name);
		setValue(2, sizeId);
	}
}
